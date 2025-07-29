import java.util.*;

public class F09_BinaryTreeLeftView {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        while (sc.hasNextInt()) {
            input.add(sc.nextInt());
        }
        sc.close();

        Node root = buildTree(input);
        List<Integer> leftView = getLeftView(root);
        System.out.print("LeftView:");
        for (int v : leftView) {
            System.out.print(" " + v);
        }
    }

    static Node buildTree(List<Integer> vals) {
        if (vals.isEmpty()) return null;
        Node root = new Node(vals.get(0));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < vals.size()) {
            Node curr = q.poll();
            int leftVal = vals.get(i++);
            if (leftVal != -1) {
                curr.left = new Node(leftVal);
                q.offer(curr.left);
            }
            if (i < vals.size()) {
                int rightVal = vals.get(i++);
                if (rightVal != -1) {
                    curr.right = new Node(rightVal);
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }

    static List<Integer> getLeftView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0) res.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return res;
    }
}
