package com.microsoft.jfr.event;

import java.util.HashMap;
import java.util.Map;

public class ObjectAllocationInNewTLAB extends JfrEventConfig {

    private boolean stackTrace;

    public ObjectAllocationInNewTLAB() {
        super("jdk.ObjectAllocationInNewTLAB");
    }

    public static ObjectAllocationInNewTLAB enabled(boolean value) {
        ObjectAllocationInNewTLAB objectAllocationInNewTLAB = new ObjectAllocationInNewTLAB();
        objectAllocationInNewTLAB.enabled = value;
        return objectAllocationInNewTLAB;
    }

    public static ObjectAllocationInNewTLAB stackTrace(boolean value) {
        ObjectAllocationInNewTLAB objectAllocationInNewTLAB = new ObjectAllocationInNewTLAB();
        objectAllocationInNewTLAB.stackTrace = value;
        return objectAllocationInNewTLAB;
    }

    @Override
    public Map<String, String> toMapSettings() {
        Map<String, String> settings = new HashMap<>();
        settings.put("enabled", String.valueOf(enabled));
        settings.put("stackTrace", String.valueOf(stackTrace));
        return settings;
    }
}
