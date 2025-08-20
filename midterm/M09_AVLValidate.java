import java.util.*;

public class M09_AVLValidate {
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

    public static int[] checkAVL(TreeNode root) {
        if (root == null) return new int[]{1, 0};  // height, isBalanced

        int[] left = checkAVL(root.left);
        int[] right = checkAVL(root.right);

        if (left[1] == -1 || right[1] == -1 || Math.abs(left[0] - right[0]) > 1) {
            return new int[]{-1, -1};
        }

        return new int[]{Math.max(left[0], right[0]) + 1, 1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }
    }
    }
