package com.microsoft.jfr.event;

import java.util.Map;

public class ObjectAllocationOutsideTLAB extends JfrEventConfig {

    public ObjectAllocationOutsideTLAB() {
        super("jdk.ObjectAllocationOutsideTLAB");
    }

    public static ObjectAllocationOutsideTLAB enabled() {
        ObjectAllocationOutsideTLAB objectAllocationOutsideTLAB = new ObjectAllocationOutsideTLAB();
        objectAllocationOutsideTLAB.enabled = true;
        return objectAllocationOutsideTLAB;
    }

    @Override
    public Map<String, String> toMapSettings() {
        return null;
    }

}
