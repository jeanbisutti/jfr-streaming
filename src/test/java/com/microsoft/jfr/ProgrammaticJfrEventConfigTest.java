package com.microsoft.jfr;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ProgrammaticJfrEventConfigTest {
    private FlightRecorderConnection flightRecorderConnection = null;

    @BeforeTest
    public void setup() {
        flightRecorderConnection = RecordingTest.getFlightRecorderConnection();
    }

    @AfterTest
    public static void tearDown() {
        RecordingTest.tearDown();
    }

    @Test
    public void programmaticEventConfigWithMap() {

        Map<String, String> recordingConfigAsMap = new HashMap<>();
        recordingConfigAsMap.put("jdk.ObjectAllocationInNewTLAB#enabled", "true");
        recordingConfigAsMap.put("jdk.ObjectAllocationOutsideTLAB#enabled", "true");

        RecordingConfiguration recordingConfiguration = new RecordingConfiguration.MapConfiguration(recordingConfigAsMap);

        executeRecording(recordingConfiguration);

    }

    @Test
    public void programmaticEventConfigWithEventSupplier() {

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

    private void executeRecording(RecordingConfiguration recordingConfiguration) {
        Path dumpFile = null;
        try {
            dumpFile = Paths.get("target", "testRecordingDump_dumped.jfr");
            Files.deleteIfExists(dumpFile);

            RecordingOptions noRecordingOption = null;
            Recording recording = flightRecorderConnection.newRecording(noRecordingOption, recordingConfiguration);
            long id = recording.start();
            Instant now = Instant.now();
            Instant then = now.plusSeconds(1);
            while (Instant.now().compareTo(then) < 0) {
                RecordingTest.fib(Short.MAX_VALUE); // do something
            }
            recording.stop();
            recording.dump(dumpFile.toString());
            assertTrue(Files.exists(dumpFile));
        } catch (IllegalArgumentException badData) {
            fail("Issue in test data: " + badData.getMessage());
        } catch (IOException ioe) {
            // possible that this can be thrown, but should not happen in this context
            fail("IOException not expected: ", ioe);
        } catch (JfrStreamingException badBean) {
            fail("Error thrown by MBean server or FlightRecorderMXBean: ", badBean);
        } finally {
            if (dumpFile != null) {

                /*
                try {
                    Files.deleteIfExists(dumpFile);
                } catch (IOException ignore) {
                }
                 */
            }
        }
    }

}
