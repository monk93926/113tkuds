// 定義單向鏈結串列節點
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class printReverse {

    // 遞迴反向列印
    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);      // 先遞迴到底
        System.out.print(head.val + " "); // 然後從尾端一路回印
    }

    public static void main(String[] args) {
        /*
         建立測試鏈結串列：1 -> 2 -> 3 -> 4
         預期輸出：4 3 2 1
        */
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("反向列印結果: ");
        printReverse(head);
    }
}