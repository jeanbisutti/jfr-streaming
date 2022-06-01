package com.microsoft.jfr.generated;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CpuProfile {

    public static Supplier<Map<String, String>>  MAP_SUPPLIER = () -> {

        Map<String, String> settingsAsMap = new HashMap<>();

        settingsAsMap.put("jdk.ThreadAllocationStatistics#enabled","true");
        settingsAsMap.put("jdk.ThreadAllocationStatistics#period","everyChunk");

        settingsAsMap.put("jdk.ClassLoadingStatistics#enabled","true");
        settingsAsMap.put("jdk.ClassLoadingStatistics#period","1000 ms");

        settingsAsMap.put("jdk.ClassLoaderStatistics#enabled","true");
        settingsAsMap.put("jdk.ClassLoaderStatistics#period","everyChunk");

        settingsAsMap.put("jdk.JavaThreadStatistics#enabled","true");
        settingsAsMap.put("jdk.JavaThreadStatistics#period","1000 ms");

        settingsAsMap.put("jdk.SymbolTableStatistics#enabled","true");
        settingsAsMap.put("jdk.SymbolTableStatistics#period","10 s");

        settingsAsMap.put("jdk.StringTableStatistics#enabled","true");
        settingsAsMap.put("jdk.StringTableStatistics#period","10 s");

        settingsAsMap.put("jdk.PlaceholderTableStatistics#enabled","true");
        settingsAsMap.put("jdk.PlaceholderTableStatistics#period","10 s");

        settingsAsMap.put("jdk.LoaderConstraintsTableStatistics#enabled","true");
        settingsAsMap.put("jdk.LoaderConstraintsTableStatistics#period","10 s");

        settingsAsMap.put("jdk.ProtectionDomainCacheTableStatistics#enabled","true");
        settingsAsMap.put("jdk.ProtectionDomainCacheTableStatistics#period","10 s");

        settingsAsMap.put("jdk.ThreadStart#enabled","true");

        settingsAsMap.put("jdk.ThreadEnd#enabled","true");

        settingsAsMap.put("jdk.ThreadSleep#enabled","true");
        settingsAsMap.put("jdk.ThreadSleep#stackTrace","true");
        settingsAsMap.put("jdk.ThreadSleep#threshold","10 ms");

        settingsAsMap.put("jdk.ThreadPark#enabled","true");
        settingsAsMap.put("jdk.ThreadPark#stackTrace","true");
        settingsAsMap.put("jdk.ThreadPark#threshold","10 ms");

        settingsAsMap.put("jdk.JavaMonitorEnter#enabled","true");
        settingsAsMap.put("jdk.JavaMonitorEnter#stackTrace","true");
        settingsAsMap.put("jdk.JavaMonitorEnter#threshold","10 ms");

        settingsAsMap.put("jdk.JavaMonitorWait#enabled","true");
        settingsAsMap.put("jdk.JavaMonitorWait#stackTrace","true");
        settingsAsMap.put("jdk.JavaMonitorWait#threshold","10 ms");

        settingsAsMap.put("jdk.JavaMonitorInflate#enabled","true");
        settingsAsMap.put("jdk.JavaMonitorInflate#stackTrace","true");
        settingsAsMap.put("jdk.JavaMonitorInflate#threshold","10 ms");

        settingsAsMap.put("jdk.BiasedLockRevocation#enabled","true");
        settingsAsMap.put("jdk.BiasedLockRevocation#stackTrace","true");
        settingsAsMap.put("jdk.BiasedLockRevocation#threshold","0 ms");

        settingsAsMap.put("jdk.BiasedLockSelfRevocation#enabled","true");
        settingsAsMap.put("jdk.BiasedLockSelfRevocation#stackTrace","true");
        settingsAsMap.put("jdk.BiasedLockSelfRevocation#threshold","0 ms");

        settingsAsMap.put("jdk.BiasedLockClassRevocation#enabled","true");
        settingsAsMap.put("jdk.BiasedLockClassRevocation#stackTrace","true");
        settingsAsMap.put("jdk.BiasedLockClassRevocation#threshold","0 ms");

        settingsAsMap.put("jdk.ReservedStackActivation#enabled","true");
        settingsAsMap.put("jdk.ReservedStackActivation#stackTrace","true");

        settingsAsMap.put("jdk.ClassLoad#enabled","false");
        settingsAsMap.put("jdk.ClassLoad#stackTrace","true");
        settingsAsMap.put("jdk.ClassLoad#threshold","0 ms");

        settingsAsMap.put("jdk.ClassDefine#enabled","false");
        settingsAsMap.put("jdk.ClassDefine#stackTrace","true");

        settingsAsMap.put("jdk.ClassUnload#enabled","false");

        settingsAsMap.put("jdk.JVMInformation#enabled","false");
        settingsAsMap.put("jdk.JVMInformation#period","beginChunk");

        settingsAsMap.put("jdk.InitialSystemProperty#enabled","false");
        settingsAsMap.put("jdk.InitialSystemProperty#period","beginChunk");

        settingsAsMap.put("jdk.ExecutionSample#enabled","true");
        settingsAsMap.put("jdk.ExecutionSample#period","1 ms");

        settingsAsMap.put("jdk.NativeMethodSample#enabled","true");
        settingsAsMap.put("jdk.NativeMethodSample#period","20 ms");

        settingsAsMap.put("jdk.SafepointBegin#enabled","true");
        settingsAsMap.put("jdk.SafepointBegin#threshold","0 ms");

        settingsAsMap.put("jdk.SafepointStateSynchronization#enabled","false");
        settingsAsMap.put("jdk.SafepointStateSynchronization#threshold","0 ms");

        settingsAsMap.put("jdk.SafepointWaitBlocked#enabled","false");
        settingsAsMap.put("jdk.SafepointWaitBlocked#threshold","0 ms");

        settingsAsMap.put("jdk.SafepointCleanup#enabled","false");
        settingsAsMap.put("jdk.SafepointCleanup#threshold","0 ms");

        settingsAsMap.put("jdk.SafepointCleanupTask#enabled","false");
        settingsAsMap.put("jdk.SafepointCleanupTask#threshold","0 ms");

        settingsAsMap.put("jdk.SafepointEnd#enabled","false");
        settingsAsMap.put("jdk.SafepointEnd#threshold","0 ms");

        settingsAsMap.put("jdk.ExecuteVMOperation#enabled","true");
        settingsAsMap.put("jdk.ExecuteVMOperation#threshold","0 ms");

        settingsAsMap.put("jdk.Shutdown#enabled","true");
        settingsAsMap.put("jdk.Shutdown#stackTrace","true");

        settingsAsMap.put("jdk.ThreadDump#enabled","true");
        settingsAsMap.put("jdk.ThreadDump#period","60 s");

        settingsAsMap.put("jdk.IntFlag#enabled","true");
        settingsAsMap.put("jdk.IntFlag#period","beginChunk");

        settingsAsMap.put("jdk.UnsignedIntFlag#enabled","true");
        settingsAsMap.put("jdk.UnsignedIntFlag#period","beginChunk");

        settingsAsMap.put("jdk.LongFlag#enabled","true");
        settingsAsMap.put("jdk.LongFlag#period","beginChunk");

        settingsAsMap.put("jdk.UnsignedLongFlag#enabled","true");
        settingsAsMap.put("jdk.UnsignedLongFlag#period","beginChunk");

        settingsAsMap.put("jdk.DoubleFlag#enabled","true");
        settingsAsMap.put("jdk.DoubleFlag#period","beginChunk");

        settingsAsMap.put("jdk.BooleanFlag#enabled","true");
        settingsAsMap.put("jdk.BooleanFlag#period","beginChunk");

        settingsAsMap.put("jdk.StringFlag#enabled","true");
        settingsAsMap.put("jdk.StringFlag#period","beginChunk");

        settingsAsMap.put("jdk.IntFlagChanged#enabled","true");

        settingsAsMap.put("jdk.UnsignedIntFlagChanged#enabled","true");

        settingsAsMap.put("jdk.LongFlagChanged#enabled","true");

        settingsAsMap.put("jdk.UnsignedLongFlagChanged#enabled","true");

        settingsAsMap.put("jdk.DoubleFlagChanged#enabled","true");

        settingsAsMap.put("jdk.BooleanFlagChanged#enabled","true");

        settingsAsMap.put("jdk.StringFlagChanged#enabled","true");

        settingsAsMap.put("jdk.ObjectCount#enabled","false");
        settingsAsMap.put("jdk.ObjectCount#period","everyChunk");

        settingsAsMap.put("jdk.GCConfiguration#enabled","true");
        settingsAsMap.put("jdk.GCConfiguration#period","everyChunk");

        settingsAsMap.put("jdk.GCHeapConfiguration#enabled","true");
        settingsAsMap.put("jdk.GCHeapConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.YoungGenerationConfiguration#enabled","true");
        settingsAsMap.put("jdk.YoungGenerationConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.GCTLABConfiguration#enabled","true");
        settingsAsMap.put("jdk.GCTLABConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.GCSurvivorConfiguration#enabled","true");
        settingsAsMap.put("jdk.GCSurvivorConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.ObjectCountAfterGC#enabled","false");

        settingsAsMap.put("jdk.GCHeapSummary#enabled","true");

        settingsAsMap.put("jdk.PSHeapSummary#enabled","true");

        settingsAsMap.put("jdk.G1HeapSummary#enabled","true");

        settingsAsMap.put("jdk.MetaspaceSummary#enabled","true");

        settingsAsMap.put("jdk.MetaspaceGCThreshold#enabled","true");

        settingsAsMap.put("jdk.MetaspaceAllocationFailure#enabled","true");
        settingsAsMap.put("jdk.MetaspaceAllocationFailure#stackTrace","true");

        settingsAsMap.put("jdk.MetaspaceOOM#enabled","true");
        settingsAsMap.put("jdk.MetaspaceOOM#stackTrace","true");

        settingsAsMap.put("jdk.MetaspaceChunkFreeListSummary#enabled","true");

        settingsAsMap.put("jdk.GarbageCollection#enabled","true");
        settingsAsMap.put("jdk.GarbageCollection#threshold","0 ms");

        settingsAsMap.put("jdk.ParallelOldGarbageCollection#enabled","true");
        settingsAsMap.put("jdk.ParallelOldGarbageCollection#threshold","0 ms");

        settingsAsMap.put("jdk.YoungGarbageCollection#enabled","true");
        settingsAsMap.put("jdk.YoungGarbageCollection#threshold","0 ms");

        settingsAsMap.put("jdk.OldGarbageCollection#enabled","true");
        settingsAsMap.put("jdk.OldGarbageCollection#threshold","0 ms");

        settingsAsMap.put("jdk.G1GarbageCollection#enabled","true");
        settingsAsMap.put("jdk.G1GarbageCollection#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhasePause#enabled","true");
        settingsAsMap.put("jdk.GCPhasePause#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhasePauseLevel1#enabled","true");
        settingsAsMap.put("jdk.GCPhasePauseLevel1#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhasePauseLevel2#enabled","true");
        settingsAsMap.put("jdk.GCPhasePauseLevel2#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhasePauseLevel3#enabled","false");
        settingsAsMap.put("jdk.GCPhasePauseLevel3#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhasePauseLevel4#enabled","false");
        settingsAsMap.put("jdk.GCPhasePauseLevel4#threshold","0 ms");

        settingsAsMap.put("jdk.GCPhaseConcurrent#enabled","false");
        settingsAsMap.put("jdk.GCPhaseConcurrent#threshold","0 ms");

        settingsAsMap.put("jdk.GCReferenceStatistics#enabled","true");

        settingsAsMap.put("jdk.PromotionFailed#enabled","true");

        settingsAsMap.put("jdk.EvacuationFailed#enabled","true");

        settingsAsMap.put("jdk.EvacuationInformation#enabled","true");

        settingsAsMap.put("jdk.G1MMU#enabled","true");

        settingsAsMap.put("jdk.G1EvacuationYoungStatistics#enabled","true");

        settingsAsMap.put("jdk.G1EvacuationOldStatistics#enabled","true");

        settingsAsMap.put("jdk.GCPhaseParallel#enabled","true");
        settingsAsMap.put("jdk.GCPhaseParallel#threshold","0 ms");

        settingsAsMap.put("jdk.G1BasicIHOP#enabled","true");

        settingsAsMap.put("jdk.G1AdaptiveIHOP#enabled","true");

        settingsAsMap.put("jdk.PromoteObjectInNewPLAB#enabled","true");

        settingsAsMap.put("jdk.PromoteObjectOutsidePLAB#enabled","true");

        settingsAsMap.put("jdk.ConcurrentModeFailure#enabled","true");

        settingsAsMap.put("jdk.AllocationRequiringGC#enabled","false");
        settingsAsMap.put("jdk.AllocationRequiringGC#stackTrace","true");

        settingsAsMap.put("jdk.TenuringDistribution#enabled","true");

        settingsAsMap.put("jdk.G1HeapRegionInformation#enabled","false");
        settingsAsMap.put("jdk.G1HeapRegionInformation#period","everyChunk");

        settingsAsMap.put("jdk.G1HeapRegionTypeChange#enabled","false");

        settingsAsMap.put("jdk.OldObjectSample#enabled","true");
        settingsAsMap.put("jdk.OldObjectSample#stackTrace","true");
        settingsAsMap.put("jdk.OldObjectSample#cutoff","0 ns");

        settingsAsMap.put("jdk.CompilerConfiguration#enabled","true");
        settingsAsMap.put("jdk.CompilerConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.CompilerStatistics#enabled","true");
        settingsAsMap.put("jdk.CompilerStatistics#period","1000 ms");

        settingsAsMap.put("jdk.Compilation#enabled","true");
        settingsAsMap.put("jdk.Compilation#threshold","100 ms");

        settingsAsMap.put("jdk.CompilerPhase#enabled","true");
        settingsAsMap.put("jdk.CompilerPhase#threshold","10 s");

        settingsAsMap.put("jdk.CompilationFailure#enabled","true");

        settingsAsMap.put("jdk.CompilerInlining#enabled","true");

        settingsAsMap.put("jdk.CodeSweeperConfiguration#enabled","true");
        settingsAsMap.put("jdk.CodeSweeperConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.CodeSweeperStatistics#enabled","true");
        settingsAsMap.put("jdk.CodeSweeperStatistics#period","everyChunk");

        settingsAsMap.put("jdk.SweepCodeCache#enabled","true");
        settingsAsMap.put("jdk.SweepCodeCache#threshold","100 ms");

        settingsAsMap.put("jdk.CodeCacheConfiguration#enabled","true");
        settingsAsMap.put("jdk.CodeCacheConfiguration#period","beginChunk");

        settingsAsMap.put("jdk.CodeCacheStatistics#enabled","true");
        settingsAsMap.put("jdk.CodeCacheStatistics#period","everyChunk");

        settingsAsMap.put("jdk.CodeCacheFull#enabled","true");

        settingsAsMap.put("jdk.OSInformation#enabled","false");
        settingsAsMap.put("jdk.OSInformation#period","beginChunk");

        settingsAsMap.put("jdk.VirtualizationInformation#enabled","true");
        settingsAsMap.put("jdk.VirtualizationInformation#period","beginChunk");

        settingsAsMap.put("jdk.CPUInformation#enabled","true");
        settingsAsMap.put("jdk.CPUInformation#period","beginChunk");

        settingsAsMap.put("jdk.ThreadContextSwitchRate#enabled","true");
        settingsAsMap.put("jdk.ThreadContextSwitchRate#period","10 s");

        settingsAsMap.put("jdk.CPULoad#enabled","true");
        settingsAsMap.put("jdk.CPULoad#period","1000 ms");

        settingsAsMap.put("jdk.ThreadCPULoad#enabled","true");
        settingsAsMap.put("jdk.ThreadCPULoad#period","10 s");

        settingsAsMap.put("jdk.CPUTimeStampCounter#enabled","true");
        settingsAsMap.put("jdk.CPUTimeStampCounter#period","beginChunk");

        settingsAsMap.put("jdk.SystemProcess#enabled","false");
        settingsAsMap.put("jdk.SystemProcess#period","endChunk");

        settingsAsMap.put("jdk.NetworkUtilization#enabled","true");
        settingsAsMap.put("jdk.NetworkUtilization#period","5 s");

        settingsAsMap.put("jdk.InitialEnvironmentVariable#enabled","false");
        settingsAsMap.put("jdk.InitialEnvironmentVariable#period","beginChunk");

        settingsAsMap.put("jdk.PhysicalMemory#enabled","true");
        settingsAsMap.put("jdk.PhysicalMemory#period","everyChunk");

        settingsAsMap.put("jdk.ObjectAllocationInNewTLAB#enabled","true");
        settingsAsMap.put("jdk.ObjectAllocationInNewTLAB#stackTrace","true");

        settingsAsMap.put("jdk.ObjectAllocationOutsideTLAB#enabled","true");
        settingsAsMap.put("jdk.ObjectAllocationOutsideTLAB#stackTrace","true");

        settingsAsMap.put("jdk.NativeLibrary#enabled","true");
        settingsAsMap.put("jdk.NativeLibrary#period","everyChunk");

        settingsAsMap.put("jdk.ModuleRequire#enabled","true");
        settingsAsMap.put("jdk.ModuleRequire#period","endChunk");

        settingsAsMap.put("jdk.ModuleExport#enabled","true");
        settingsAsMap.put("jdk.ModuleExport#period","endChunk");

        settingsAsMap.put("jdk.FileForce#enabled","true");
        settingsAsMap.put("jdk.FileForce#stackTrace","true");
        settingsAsMap.put("jdk.FileForce#threshold","10 ms");

        settingsAsMap.put("jdk.FileRead#enabled","true");
        settingsAsMap.put("jdk.FileRead#stackTrace","true");
        settingsAsMap.put("jdk.FileRead#threshold","10 ms");

        settingsAsMap.put("jdk.FileWrite#enabled","true");
        settingsAsMap.put("jdk.FileWrite#stackTrace","true");
        settingsAsMap.put("jdk.FileWrite#threshold","10 ms");

        settingsAsMap.put("jdk.SocketRead#enabled","true");
        settingsAsMap.put("jdk.SocketRead#stackTrace","true");
        settingsAsMap.put("jdk.SocketRead#threshold","10 ms");

        settingsAsMap.put("jdk.SocketWrite#enabled","true");
        settingsAsMap.put("jdk.SocketWrite#stackTrace","true");
        settingsAsMap.put("jdk.SocketWrite#threshold","10 ms");

        settingsAsMap.put("jdk.SecurityPropertyModification#enabled","false");
        settingsAsMap.put("jdk.SecurityPropertyModification#stackTrace","true");

        settingsAsMap.put("jdk.TLSHandshake#enabled","false");
        settingsAsMap.put("jdk.TLSHandshake#stackTrace","true");

        settingsAsMap.put("jdk.X509Validation#enabled","false");
        settingsAsMap.put("jdk.X509Validation#stackTrace","true");

        settingsAsMap.put("jdk.X509Certificate#enabled","false");
        settingsAsMap.put("jdk.X509Certificate#stackTrace","true");

        settingsAsMap.put("jdk.JavaExceptionThrow#enabled","false");
        settingsAsMap.put("jdk.JavaExceptionThrow#stackTrace","true");

        settingsAsMap.put("jdk.JavaErrorThrow#enabled","true");
        settingsAsMap.put("jdk.JavaErrorThrow#stackTrace","true");

        settingsAsMap.put("jdk.ExceptionStatistics#enabled","true");
        settingsAsMap.put("jdk.ExceptionStatistics#period","1000 ms");

        settingsAsMap.put("jdk.ActiveRecording#enabled","true");

        settingsAsMap.put("jdk.ActiveSetting#enabled","true");

        settingsAsMap.put("jdk.DataLoss#enabled","true");

        settingsAsMap.put("jdk.DumpReason#enabled","true");

        settingsAsMap.put("jdk.ZPageAllocation#enabled","true");
        settingsAsMap.put("jdk.ZPageAllocation#threshold","10 ms");

        settingsAsMap.put("jdk.ZThreadPhase#enabled","true");
        settingsAsMap.put("jdk.ZThreadPhase#threshold","0 ms");

        settingsAsMap.put("jdk.ZStatisticsCounter#threshold","10 ms");
        settingsAsMap.put("jdk.ZStatisticsCounter#enabled","true");

        settingsAsMap.put("jdk.ZStatisticsSampler#enabled","true");
        settingsAsMap.put("jdk.ZStatisticsSampler#threshold","10 ms");

        return settingsAsMap;
    };


}