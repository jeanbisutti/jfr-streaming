package com.microsoft.jfr.generation;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class JfrSettingsAsMapGenerator {

    public static final JfrSettingsAsMapGenerator INSTANCE = new JfrSettingsAsMapGenerator();

    private JfrSettingsAsMapGenerator() {
    }

    private static final String MAP_PUT_TEMPLATE = "MAP_PUT";
    public static final String PROFILE_NAME_TEMPLATE = "PROFILE_NAME";
    private static final String MAP_SUPPLIER_TEMPLATE =
            "import java.util.HashMap;\n" +
                    "import java.util.Map;\n" +
                    "import java.util.function.Supplier;\n" +
                    "\n" +
                    "public class "+ PROFILE_NAME_TEMPLATE + "Profile {\n" +
                    "\n" +
                    "    public static Supplier<Map<String, String>>  MAP_SUPPLIER = () -> {\n" +
                    "\n" +
                    "        Map<String, String> settingsAsMap = new HashMap<>();\n" +
                    "\n" +
                    MAP_PUT_TEMPLATE +
                    "        return settingsAsMap;\n" +
                    "    };\n" +
                    "\n" +
                    "\n" +
                    "}";

    public void generate(Map<String, List<Setting>> settingsByEventName, String profileName, String targetDirPath) {


        StringBuilder mapPutCodeBuilder = new StringBuilder();
        for (Map.Entry<String, List<Setting>> settingEntry : settingsByEventName.entrySet()) {
            String eventName = settingEntry.getKey();
            List<Setting> settings = settingEntry.getValue();
            String blankHeader = "        ";
            for (Setting setting : settings) {
                mapPutCodeBuilder.append(blankHeader +"settingsAsMap.put(\"" + eventName + "#" + setting.name + "\",\"" + setting.value + "\");");
                mapPutCodeBuilder.append(System.lineSeparator());
            }
            mapPutCodeBuilder.append(System.lineSeparator());
        }

        byte[] content = MAP_SUPPLIER_TEMPLATE.replace(PROFILE_NAME_TEMPLATE, profileName)
                                              .replace(MAP_PUT_TEMPLATE, mapPutCodeBuilder.toString()).getBytes();

        try {
            Path javaClassPath = FileSystems.getDefault().getPath(targetDirPath, profileName + "Profile.java");
            File javaFile = javaClassPath.toFile();
            javaFile.createNewFile();
            Files.write(javaClassPath, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
