public class isSorted {

    public static boolean isSorted(int[] arr, int index) {
        // 終止條件：檢查到最後一個元素了
        if (index == arr.length - 1) {
            return true;
        }

        // 如果當前比下一個還大，就不是升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 否則遞迴檢查下一組
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 4, 3, 2, 1};
        int[] a3 = {1, 2, 2, 3, 4};

        System.out.println("a1 是否升序？" + isSorted(a1, 0)); // true
        System.out.println("a2 是否升序？" + isSorted(a2, 0)); // false
        System.out.println("a3 是否升序？" + isSorted(a3, 0)); // true
    }
}