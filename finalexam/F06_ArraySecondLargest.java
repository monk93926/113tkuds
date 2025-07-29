import java.util.*;

public class F06_ArraySecondLargest {
    static class Pair {
        int max, second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Pair res = secondLargest(arr, 0, n - 1);
        System.out.println("SecondMax: " + res.second);
        sc.close();
    }

    static Pair secondLargest(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        int mid = (left + right) / 2;
        Pair leftPair = secondLargest(arr, left, mid);
        Pair rightPair = secondLargest(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else if (leftPair.max < rightPair.max) {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        } else { // equal max
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.second);
        }
        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：分治遞迴遍歷陣列，每個元素最多被合併處理一次，故時間為線性 O(n)。
 */
