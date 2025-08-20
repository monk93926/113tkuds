import java.util.*;

public class M12_MergeKTimeTables {
    static class TimeTable {
        int time, listIndex, timeIndex;

        TimeTable(int time, int listIndex, int timeIndex) {
            this.time = time;
            this.listIndex = listIndex;
            this.timeIndex = timeIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();

        PriorityQueue<TimeTable> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        List<List<Integer>> timeTables = new ArrayList<>();

        // 讀入每條時刻表
        for (int i = 0; i < K; i++) {
            int len = scanner.nextInt();
            List<Integer> table = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                table.add(scanner.nextInt());
            }
            timeTables.add(table);
            if (!table.isEmpty()) {
                minHeap.add(new TimeTable(table.get(0), i, 0));
            }
        }

        List<Integer> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            TimeTable curr = minHeap.poll();
            merged.add(curr.time);

            // 從相同時刻表中取出下一個元素
            int nextIndex = curr.timeIndex + 1;
            if (nextIndex < timeTables.get(curr.listIndex).size()) {
                minHeap.add(new TimeTable(timeTables.get(curr.listIndex).get(nextIndex), curr.listIndex, nextIndex));
            }
        }

        for (int time : merged) {
            System.out.print(time + " ");
        }
    }
}
