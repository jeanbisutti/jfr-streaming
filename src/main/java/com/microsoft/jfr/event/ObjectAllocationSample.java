package com.microsoft.jfr.event;

public class ObjectAllocationSample extends JfrEventConfig {

    public ObjectAllocationSample() {
        super("jdk.ObjectAllocationSample");
    }

    public static ObjectAllocationSample enabled() {
        ObjectAllocationSample objectAllocationSample = new ObjectAllocationSample();
        objectAllocationSample.enabled = true;
        return objectAllocationSample;
    }

}
