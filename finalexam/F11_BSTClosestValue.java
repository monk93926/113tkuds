import java.util.*;

public class F11_BSTClosestValue {
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
        // 最後一個是 target
        int target = vals.remove(vals.size() - 1);

        Node root = null;
        for (int v : vals) {
            root = insert(root, v);
        }

        int res = closestValue(root, target);
        System.out.println(res);
        sc.close();
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static int closestValue(Node root, int target) {
        int closest = root.val;
        Node curr = root;
        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(closest - target)) {
                closest = curr.val;
            } else if (Math.abs(curr.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, curr.val);
            }
            if (target < curr.val) curr = curr.left;
            else if (target > curr.val) curr = curr.right;
            else break;
        }
        return closest;
    }
}
