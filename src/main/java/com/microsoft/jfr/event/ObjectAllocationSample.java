package com.microsoft.jfr.event;

import java.util.Map;

public class ObjectAllocationSample extends JfrEventConfig {

    public ObjectAllocationSample() {
        super("jdk.ObjectAllocationSample");
    }

    public static ObjectAllocationSample enabled() {
        ObjectAllocationSample objectAllocationSample = new ObjectAllocationSample();
        objectAllocationSample.enabled = true;
        return objectAllocationSample;
    }

    @Override
    public Map<String, String> toMapSettings() {
        return null;
    }

}
