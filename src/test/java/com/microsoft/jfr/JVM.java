package com.microsoft.jfr;

/** Inspiration from QuickPerf (https://github.com/quick-perf/quickperf) **/
public class JVM {

    public static final JVM INSTANCE = new JVM();

    public final Version version;

    private JVM() {
        version = new Version();
    }

    public static class Version {

        private final String javaJvmSpecificationVersion = System.getProperty("java.vm.specification.version");

        private Version() { }

        public boolean is7() {
            return javaJvmSpecificationVersion.contains("1.7");
        }

        public boolean is8() {
            return javaJvmSpecificationVersion.contains("1.8");
        }

        private int findJvmVersionAsInt() {
            return Integer.parseInt(javaJvmSpecificationVersion);
        }
        public boolean isGreaterThanOrEqualTo16() {
            return !is7() && !is8() && findJvmVersionAsInt() >= 16;
        }

        public boolean isLessThanTo16() {
            return !isGreaterThanOrEqualTo16();
        }

    }

}