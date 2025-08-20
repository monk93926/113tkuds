import java.util.*;

public class M08_BSTRangedSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static TreeNode buildTree(int[] nodes) {
        if (nodes.length == 0) return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (index < nodes.length) {
            TreeNode current = queue.poll();
            if (nodes[index] != -1) {
                current.left = new TreeNode(nodes[index]);
                queue.add(current.left);
            }
            index++;
            if (index < nodes.length && nodes[index] != -1) {
                current.right = new TreeNode(nodes[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static int rangeSum(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.val > L) {
            sum += rangeSum(root.left, L, R);
        }
        if (root.val < R) {
            sum += rangeSum(root.right, L, R);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }

        TreeNode root = buildTree(nodes);
        int L = scanner.nextInt();
        int R = scanner.nextInt();

        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
    }
}
