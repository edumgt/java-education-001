
/**
 * 프로그램 설명:
 * 이 프로그램은 수영 선수가 새로운 세계 기록을 세울 수 있는지를 판단합니다.
 *
 * 입력:
 * - 기존 세계 기록 (초 단위)
 * - 수영할 거리 (미터 단위)
 * - 1미터당 수영에 걸리는 시간 (초 단위)
 *
 * 규칙:
 * - 매 15미터마다 12.5초의 지연이 발생합니다.
 * - 전체 수영 시간 = 거리 × 시간 + (15미터마다 지연 시간)
 *
 * 출력:
 * - 세계 기록보다 느린 경우: "No, he failed! He was X.XX seconds slower."
 * - 세계 기록을 깬 경우: "Yes, he succeeded! The new world record is X.XX seconds."
 */
import java.lang.management.*;
import java.util.Scanner;

public class WorldSwimmingRecordWithDiagnostics {

    public static void main(String[] args) {
        printJVMDiagnostics("🟢 프로그램 시작 시 JVM 상태");

        Scanner scanner = new Scanner(System.in); 
        // Scanner 객체는 Heap에 생성되고, 참조는 Stack에 저장됩니다.

        System.out.print("기존 세계 기록(초)을 입력하세요: ");
        double record = Double.parseDouble(scanner.nextLine());

        System.out.print("수영할 거리(미터)를 입력하세요: ");
        double meters = Double.parseDouble(scanner.nextLine());

        System.out.print("1미터당 걸리는 시간(초)을 입력하세요: ");
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        // 핵심 로직: 수영 시간 + 거리별 지연 계산
        double swimTime = meters * secondsPerMeter;
        double delay = Math.floor(meters / 15) * 12.5;
        double totalTime = swimTime + delay;

        System.out.println("\n⏱️ 계산된 총 수영 시간: " + totalTime + "초");

        if (totalTime >= record) {
            System.out.printf("❌ No, he failed! He was %.2f seconds slower.%n", totalTime - record);
        } else {
            System.out.printf("🏆 Yes, he succeeded! The new world record is %.2f seconds.%n", totalTime);
        }

        scanner.close();

        printJVMDiagnostics("🔴 프로그램 종료 시 JVM 상태");
    }

    /**
     * JVM 메모리 및 스레드/클래스 로딩 상태를 출력하는 함수
     */
    public static void printJVMDiagnostics(String phaseLabel) {
        System.out.println("\n========= " + phaseLabel + " =========");

        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

        System.out.printf("📦 Heap: 사용 %.2f MB / 최대 %.2f MB%n",
                heap.getUsed() / 1024.0 / 1024,
                heap.getMax() / 1024.0 / 1024);

        System.out.printf("📦 Non-Heap (Metaspace 포함): 사용 %.2f MB / 최대 %.2f MB%n",
                nonHeap.getUsed() / 1024.0 / 1024,
                nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = pool.getUsage();
            System.out.printf("🧩 메모리 풀 [%s]: 사용 %.2f MB%n", pool.getName(), usage.getUsed() / 1024.0 / 1024);
        }

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("📘 클래스 로딩 수: 현재 %d, 총 로드 %d, 언로드 %d%n",
                classBean.getLoadedClassCount(),
                classBean.getTotalLoadedClassCount(),
                classBean.getUnloadedClassCount());

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("🧵 현재 스레드 수: %d, 데몬 스레드 수: %d%n",
                threadBean.getThreadCount(),
                threadBean.getDaemonThreadCount());

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        System.out.printf("⏳ 프로그램 업타임: %.2f초%n", runtime.getUptime() / 1000.0);

        System.out.println("========================================\n");
    }
}
