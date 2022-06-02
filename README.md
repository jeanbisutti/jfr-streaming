# Microsoft JFR Streaming


## Read JFR recording from memory (not from a .jfr file)
There are several types of API to profile with the JDK Flight Recording (JFR).

1) Basic API from JDK 8 (non-streaming API) => JFR events can be saved in a _.fr_ file or an ```InputStream```
2) The [RecordingStream](https://docs.oracle.com/en/java/javase/17/docs/api/jdk.jfr/jdk/jfr/consumer/RecordingStream.html) from JDK 14 
=>  stream that produces events from the current JVM, [JVM Blog paper: A Closer Look at JFR Streaming](http://hirt.se/blog/?p=1239)
3) The [RemoteRecordingStream](https://docs.oracle.com/en/java/javase/17/docs/api/jdk.management.jfr/jdk/management/jfr/RemoteRecordingStream.html) from JDK 16
=>   stream that produces events and can serialize them over the network

Thereafter, we give information about the "basic" API, used by _Microsoft JFR Streaming_. We also explain how to upload the JFR profiling data straight from memory (without using a _.jfr_ file). 

### The "basic" API

The "basic" API can be controlled with:
* [FlightRecorderMXBean](https://docs.oracle.com/javase/9/docs/api/jdk/management/jfr/FlightRecorderMXBean.html) or [jdk.jfr.Recording](https://docs.oracle.com/en/java/javase/12/docs/api/jdk.jfr/jdk/jfr/Recording.html) class => ```FlightRecorderConnection``` in _Microsoft JFR Streaming_
  * OpenJDK JDK 8 with a version of at least u262/u272 (following vendors)
  * From OpenJDK JDK 11
  * Oracle JDK 9
  * Oracle JDK 10
* DiagnosticCommandMBean => ```FlightRecorderDiagnosticCommandConnection``` in _Microsoft JFR Streaming_
  * Oracle JDK 8 (removed from Oracle JDK 9)

The recording result can be saved in a file or in an ```InputStream```.

The JDK [RecordingFile](https://docs.oracle.com/en/java/javase/11/docs/api/jdk.jfr/jdk/jfr/consumer/RecordingFile.html) class allows reading the JFR event contained in a _.jfr_ file (_the ```RecordingFile``` class is available in the same JDK versions as the ```Recording``` class, see above_).

There is apparently no API in the JDK to read JFR events from an ```InputStream```, but it is possible to use the [org.openjdk.jmc.flightrecorder](https://mvnrepository.com/artifact/org.openjdk.jmc/flightrecorder) library:

```java
       ...
       InputStream jfrEventsInputStream = recording.getStream(null, null);
       ...
       IItemCollection iItemIterables = JfrLoaderToolkit.loadEvents(jfrEventsInputStream);
        for (IItemIterable iItemIterable : iItemIterables) {
        ...
        }
```

The full example is given [here](src/test/java/com/microsoft/jfr/MemoryRecordingTest.java).

## Programmatically configure JFR events

### Why
Easily be able to dynamically configure JFR events according to JVM characteristics, such as the JVM version.

### A use case

[In JDK 16, a low overhead allocation event was introduced](https://bugs.openjdk.java.net/browse/JDK-8257602):
```xml
    <event name="jdk.ObjectAllocationSample">
      <setting name="enabled">true</setting>
      <setting name="throttle">300/s</setting>
      <setting name="stackTrace">true</setting>
    </event>
```

The ```jdk.ObjectAllocationSample``` can be used instead of the ```jdk.ObjectAllocationInNewTLAB``` and ```"jdk.ObjectAllocationOutsideTLAB"``` events.


From  [_Improved JFR allocation profiling in JDK 16_](https://withent.blogspot.com/2021/01/improved-jfr-allocation-profiling-in.html)  blog post: 
* "This is an incremental improvement on top of the TLAB based allocation profiling. It is using the same data source (TLAB filled up, outside of TLAB allocation) but is applying an adaptive throttling mechanism to guarantee the maximum number of samples per recording (or time unit, more generally speaking)."
* "let's ponder the fact that the event rate emission control (throttling) is not TLAB event specific and can be used for other event types as well if there is such demand."
=> **Potential new low-overhead JFR events in future JVM version**

### A solution

We have added the ability to configure JFR events programmatically to _Microsoft JFR Streaming_ in the case of the use of ```FlightRecorderConnection``` (it would be possible to add the same feature to ```FlightRecorderDiagnosticCommandConnection```).

We give below an example available in the [ProgrammaticJfrEventConfigTest](src/test/java/com/microsoft/jfr/ProgrammaticJfrEventConfigTest.java) class.
```java
    @Test
    public void programmaticEventConfigWithMap() {

        Map<String, String> recordingConfigAsMap = new HashMap<>();
        recordingConfigAsMap.put("jdk.ObjectAllocationInNewTLAB#enabled", "true");
        recordingConfigAsMap.put("jdk.ObjectAllocationOutsideTLAB#enabled", "true");

        RecordingConfiguration recordingConfiguration = new RecordingConfiguration.MapConfiguration(recordingConfigAsMap);

        executeRecording(recordingConfiguration);

    }
```

With this feature, it becomes possible to easily configure specific allocation events according to the JVM version ([ProgrammaticJfrEventConfigTest](src/test/java/com/microsoft/jfr/ProgrammaticJfrEventConfigTest.java) class):

```java
    @Test
    public void selectJfrEventAccordingToJvmVersion() {

        Supplier<Map<String, String>> allocationEvents = () -> {
            Map<String, String> recordingConfigAsMap = new HashMap<>();

            if (JVM.INSTANCE.version.isLessThanTo16()) {
                recordingConfigAsMap.put("jdk.ObjectAllocationInNewTLAB#enabled", "true");
                recordingConfigAsMap.put("jdk.ObjectAllocationOutsideTLAB#enabled", "true");
            } else {
                recordingConfigAsMap.put("jdk.ObjectAllocationSample#enabled", "true");
            }

            return recordingConfigAsMap;
        };

        RecordingConfiguration recordingConfiguration = new RecordingConfiguration.MapConfiguration(allocationEvents);

        executeRecording(recordingConfiguration);

    }
``` 

_We have also created a feature to transform an event configuration defined with a _.jcf_ file into a programmatic configuration._ The entry point of this feature is [here](src/main/java/com/microsoft/jfr/generation/JfcToJava.java).

An example of the use of a generated programmatic configuration is given in the [ProgrammaticJfrEventConfigTest](src/test/java/com/microsoft/jfr/ProgrammaticJfrEventConfigTest.java) class:
```java
    @Test
    public void useGeneratedProgrammaticProfile() {

        // The MemoryProfile class was generated from the src/test/resources/reduced-memory-profile.jfc file with the help of the JfcToJava class
        Supplier<Map<String, String>> memoryProfile = MemoryProfile.MAP_SUPPLIER;
        
        RecordingConfiguration recordingConfiguration = new RecordingConfiguration.MapConfiguration(memoryProfile);
        
        executeRecording(recordingConfiguration);

    }
```
