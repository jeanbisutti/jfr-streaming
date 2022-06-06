# Microsoft JFR Streaming

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

The ```jdk.ObjectAllocationSample``` can be used instead of the ```jdk.ObjectAllocationInNewTLAB``` and ```jdk.ObjectAllocationOutsideTLAB``` events.


From  [_Improved JFR allocation profiling in JDK 16_](https://withent.blogspot.com/2021/01/improved-jfr-allocation-profiling-in.html)  blog post: 
* "This is an incremental improvement on top of the TLAB based allocation profiling. It is using the same data source (TLAB filled up, outside of TLAB allocation) but is applying an adaptive throttling mechanism to guarantee the maximum number of samples per recording (or time unit, more generally speaking)."
* "let's ponder the fact that the event rate emission control (throttling) is not TLAB event specific and can be used for other event types as well if there is such demand."
=> **Potential new low-overhead JFR events in future JVM version**

### A solution

We have added the ability to configure JFR events programmatically to _Microsoft JFR Streaming_ in the case of using```FlightRecorderConnection``` (_it would be possible to add the same feature to ```FlightRecorderDiagnosticCommandConnection```_).

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

**We have also created a feature to transform a _.jcf_ file configuration into a programmatic configuration.** The entry point of this feature is [here](src/main/java/com/microsoft/jfr/generation/JfcToJava.java).

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
