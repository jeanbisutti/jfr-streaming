package com.microsoft.jfr.event;

public class ObjectAllocationOutsideTLAB extends JfrEventConfig {

    public ObjectAllocationOutsideTLAB() {
        super("jdk.ObjectAllocationOutsideTLAB");
    }

    public static ObjectAllocationOutsideTLAB enabled() {
        ObjectAllocationOutsideTLAB objectAllocationOutsideTLAB = new ObjectAllocationOutsideTLAB();
        objectAllocationOutsideTLAB.enabled = true;
        return objectAllocationOutsideTLAB;
    }

}
