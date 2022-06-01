package com.microsoft.jfr.event;

import java.util.Map;

public abstract class JfrEventConfig {
    private String eventName;

    protected boolean enabled;

    public JfrEventConfig(String eventName) {
        this.eventName = eventName;
    }

    public String enableConfig() {
        return eventName + "#enabled";
    }

    public String enableConfigValue() {
        return "" + enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public abstract Map<String, String> toMapSettings();

}
