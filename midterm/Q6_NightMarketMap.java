public class Q6_NightMarketMap {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        char[][] map = new char[10][10];

        // 初始化全部為 #
        for (int i = 0; i < 10; i++) {
            java.util.Arrays.fill(map[i], '#');
        }

        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= 0 && row < 10 && col >= 0 && col < 10) {
                map[row][col] = '*';
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
