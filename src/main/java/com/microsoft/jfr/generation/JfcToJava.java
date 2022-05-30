package com.microsoft.jfr.generation;

import java.util.List;
import java.util.Map;

public class JfcToJava {

    static final String TARGET_DIR_PATH = "src/test/resources";
    static final String CPU_PROFILE_NAME = "Cpu";
    static final String CPU_PROFILE_SOURCE_FILE_PATH = "src/test/resources/reduced-cpu-profile.jfc";

    static final String MEMORY_PROFILE_NAME = "Memory";
    static final String MEMORY_PROFILE_SOURCE_FILE_PATH = "src/test/resources/reduced-memory-profile.jfc";

    public static void main(String[] args) {

        JfcParser jfcParser = new JfcParser(MEMORY_PROFILE_SOURCE_FILE_PATH);
        jfcParser.parse();
        Map<String, List<Setting>> settingsByEventName = jfcParser.getSettingsByEventName();

        System.out.println("settingsByEventName = " + settingsByEventName);

        JfrSettingsAsMapGenerator.INSTANCE.generate(settingsByEventName, MEMORY_PROFILE_NAME, TARGET_DIR_PATH);

    }


}
