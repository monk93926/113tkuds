import java.util.*;

public class F10_BSTRangeSum {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        // 假設最後兩個為 L R
        int R = vals.remove(vals.size() - 1);
        int L = vals.remove(vals.size() - 1);

        Node root = null;
        for (int v : vals) {
            root = insert(root, v);
        }

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
        sc.close();
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static int rangeSumBST(Node root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
