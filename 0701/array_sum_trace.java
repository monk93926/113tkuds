public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }

        System.out.println("總和為：" + total);
    }
}
//這程式使用一層迴圈依序加總陣列中的每個元素，所以時間複雜度為 O(n)，其中n為陣列長度