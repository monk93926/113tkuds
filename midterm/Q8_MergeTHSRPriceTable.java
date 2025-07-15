public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] station = new String[n];
        int[][] price = new int[n][2]; // [標準, 商務]

        for (int i = 0; i < n; i++) {
            station[i] = sc.next();
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
        }

        System.out.println("Station|Standard|Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", station[i], price[i][0], price[i][1]);
        }
    }
}
