import java.util.*;

public class M07_BinaryTreeLeftView {
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

    public static void printLeftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    System.out.print(node.val + " ");
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }

        TreeNode root = buildTree(nodes);
        System.out.print("LeftView: ");
        printLeftView(root);
    }
}
