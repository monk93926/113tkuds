import java.util.*;

public class F12_TreeDiameter {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        sc.close();

        Node root = buildTree(vals);
        diameter = 0;
        height(root);
        System.out.println(diameter);
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

    static int height(Node node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        diameter = Math.max(diameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }
}
