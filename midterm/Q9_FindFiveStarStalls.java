public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] scores = new int[n];
        String[] parts = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(parts[i]);
        }

        int count = 0;
        for (int score : scores) {
            if (score == 5) count++;
        }

        if (count == 0) {
            System.out.println("None");
            return;
        }

        int idx = 0;
        int[] result = new int[count];
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) result[idx++] = i;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(result[i]);
            if (i < count - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
