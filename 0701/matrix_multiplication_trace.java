public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                
                for (int k = 0; k < 2; k++) {
                    int partial = a[i][k] * b[k][j];
                    c[i][j] += partial;

                    System.out.print(a[i][k] + "*" + b[k][j]);
                    if (k < 1) {
                        System.out.print(" + ");
                    }
                }

                System.out.print(" = ");
                System.out.print((a[i][0] * b[0][j]) + " + " + (a[i][1] * b[1][j]));
                System.out.print(" = " + c[i][j]);
                System.out.println(); 
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//這程式使用三層巢狀迴圈進行矩陣乘法，因此時間複雜度為 O(n³)