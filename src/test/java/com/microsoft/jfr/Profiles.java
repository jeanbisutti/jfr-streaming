package com.microsoft.jfr;

import com.microsoft.jfr.event.JfrEventConfig;
import com.microsoft.jfr.event.ObjectAllocationInNewTLAB;
import com.microsoft.jfr.event.ObjectAllocationOutsideTLAB;
import com.microsoft.jfr.event.ObjectAllocationSample;

import java.util.*;
import java.util.function.Supplier;

public class Profiles {

    public static Supplier<Collection<JfrEventConfig>> CPU = new Supplier<Collection<JfrEventConfig>>() {
        @Override
        public Collection<JfrEventConfig> get() {
            return null;
        }
    };

    public static Supplier<Collection<JfrEventConfig>> MEMORY = new Supplier<Collection<JfrEventConfig>>() {


        @Override
        public Collection<JfrEventConfig> get() {

            List<JfrEventConfig> memoryEvents = new ArrayList<>();

            if (JVM.INSTANCE.version.isLessThanTo16()) {
                memoryEvents.add(ObjectAllocationInNewTLAB.enabled(true));
                memoryEvents.add(ObjectAllocationOutsideTLAB.enabled());
            } else {
                memoryEvents.add(ObjectAllocationSample.enabled());
            }

            return memoryEvents;

        }
    };

}
