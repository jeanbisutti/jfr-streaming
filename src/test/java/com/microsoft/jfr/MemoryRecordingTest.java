package com.microsoft.jfr;

import org.openjdk.jmc.common.item.IItem;
import org.openjdk.jmc.common.item.IItemCollection;
import org.openjdk.jmc.common.item.IItemIterable;
import org.openjdk.jmc.flightrecorder.CouldNotLoadRecordingException;
import org.openjdk.jmc.flightrecorder.JfrLoaderToolkit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

public class MemoryRecordingTest {

    private FlightRecorderConnection flightRecorderConnection = null;

    @BeforeTest
    public void setup() {
        flightRecorderConnection = RecordingTest.getFlightRecorderConnection();
    }

    @Test
    public void readJfrEventsFromMemory() throws IOException, JfrStreamingException, CouldNotLoadRecordingException {

        RecordingConfiguration recordingConfiguration = new RecordingConfiguration.JfcFileConfiguration(RecordingConfigurationTest.class.getClassLoader()
                                                                                                        .getResourceAsStream("sampleJfcFile.jfc"));

        RecordingOptions noRecordingOption = null;
        Recording recording = flightRecorderConnection.newRecording(noRecordingOption, recordingConfiguration);

        recording.start();

        Instant now = Instant.now();
        Instant then = now.plusSeconds(1);
        while (Instant.now().compareTo(then) < 0) {
            RecordingTest.fib(Short.MAX_VALUE); // do something
        }

        recording.stop();
        InputStream jfrEventsInputStream = recording.getStream(null, null);

        IItemCollection iItemIterables = JfrLoaderToolkit.loadEvents(jfrEventsInputStream);
        for (IItemIterable iItemIterable : iItemIterables) {
            for (IItem iItem : iItemIterable) {
                String eventName = iItem.getType().getIdentifier();
                System.out.println(eventName);
            }
        }

    }

}