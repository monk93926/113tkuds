import java.util.*;

public class M11_HeapSortWithTie {
    static class Student {
        int score, index;

        Student(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Student> maxHeap = new PriorityQueue<>(
            (a, b) -> (a.score == b.score ? a.index - b.index : b.score - a.score)
        );

        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            maxHeap.offer(new Student(score, i));
        }

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll().score + " ");
        }
    }
}
