public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[] power = new int[7];
        for (int i = 0; i < 7; i++) {
            power[i] = sc.nextInt();
        }

        // 反轉
        int left = 0, right = 6;
        while (left < right) {
            int temp = power[left];
            power[left] = power[right];
            power[right] = temp;
            left++;
            right--;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(power[i]);
            if (i < 6) System.out.print(" ");
        }
        System.out.println();
    }
}
