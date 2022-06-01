package com.microsoft.jfr.generation;

import java.util.List;
import java.util.Map;

public class JfrSettingsAsObjectGenerator {

    public static final String CLASS_NAME_TEMPLATE = "ObjectAllocationInNewTLAB";

    private static final String TEMPLATE =
            "public class " + CLASS_NAME_TEMPLATE + " extends JfrEventConfig {\n" +
                    "\n" +
                    "    private boolean stackTrace;\n" +
                    "\n" +
                    "    public ObjectAllocationInNewTLAB() {\n" +
                    "        super(\"jdk.ObjectAllocationInNewTLAB\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public static "+ CLASS_NAME_TEMPLATE + " enabled(boolean value) {\n" +
                    "        " +"ObjectAllocationInNewTLAB" + " objectAllocationInNewTLAB = new " + CLASS_NAME_TEMPLATE + "();\n" +
                    "        objectAllocationInNewTLAB.enabled = value;\n" +
                    "        return objectAllocationInNewTLAB;\n" +
                    "    }\n" +
                    "\n" +
                    "    public static ObjectAllocationInNewTLAB stackTrace(boolean value) {\n" +
                    "        ObjectAllocationInNewTLAB objectAllocationInNewTLAB = new ObjectAllocationInNewTLAB();\n" +
                    "        objectAllocationInNewTLAB.stackTrace = value;\n" +
                    "        return objectAllocationInNewTLAB;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Map<String, String> toMapSettings() {\n" +
                    "        Map<String, String> settings = new HashMap<>();\n" +
                    "        settings.put(\"enabled\", String.valueOf(enabled));\n" +
                    "        settings.put(\"stackTrace\", String.valueOf(stackTrace));\n" +
                    "        return settings;\n" +
                    "    }\n" +
                    "}";



    public void generate(Map<String, List<Setting>> settingsByEventName, String profileName, String targetDirPath) {


    }

}
