package com.microsoft.jfr.event;

public class ObjectAllocationInNewTLAB extends JfrEventConfig {

    public ObjectAllocationInNewTLAB() {
        super("jdk.ObjectAllocationInNewTLAB");
    }

    public static ObjectAllocationInNewTLAB enabled() {
        ObjectAllocationInNewTLAB objectAllocationInNewTLAB = new ObjectAllocationInNewTLAB();
        objectAllocationInNewTLAB.enabled = true;
        return objectAllocationInNewTLAB;
    }

}
