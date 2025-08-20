import java.util.Scanner;

public class M01_BuildHeap {

    // 堆化方法，將節點從下往上調整為符合堆的結構
    public static void heapify(int[] arr, int n, int i, String type) {
        int largestOrSmallest = i;
        int left = 2 * i + 1; // 左子節點
        int right = 2 * i + 2; // 右子節點

        // 根據堆類型選擇最大堆或最小堆
        if (type.equals("max")) {
            // 最大堆：若左子節點更大，更新 largestOrSmallest
            if (left < n && arr[left] > arr[largestOrSmallest]) {
                largestOrSmallest = left;
            }
            // 最大堆：若右子節點更大，更新 largestOrSmallest
            if (right < n && arr[right] > arr[largestOrSmallest]) {
                largestOrSmallest = right;
            }
        } else {
            // 最小堆：若左子節點更小，更新 largestOrSmallest
            if (left < n && arr[left] < arr[largestOrSmallest]) {
                largestOrSmallest = left;
            }
            // 最小堆：若右子節點更小，更新 largestOrSmallest
            if (right < n && arr[right] < arr[largestOrSmallest]) {
                largestOrSmallest = right;
            }
        }

        // 若最大的（或最小的）值不是當前節點，則交換並遞歸調整
        if (largestOrSmallest != i) {
            int temp = arr[i];
            arr[i] = arr[largestOrSmallest];
            arr[largestOrSmallest] = temp;
            heapify(arr, n, largestOrSmallest, type);
        }
    }

    // 自底向上的建堆過程
    public static void buildHeap(int[] arr, int n, String type) {
        // 從最後一個非葉子節點開始，逐一執行heapify
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 讀取堆的類型（max 或 min）
        String type = scanner.nextLine();
        
        // 讀取陣列的大小 n
        int n = scanner.nextInt();
        
        // 讀取陣列元素
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // 建堆
        buildHeap(arr, n, type);
        
        // 輸出建堆後的陣列
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
