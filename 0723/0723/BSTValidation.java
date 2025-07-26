import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

  
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBSTHelper(node.left, min, node.data)
            && isValidBSTHelper(node.right, node.data, max);
    }

    
    public static void findInvalidNodes(TreeNode node, long min, long max, List<Integer> result) {
        if (node == null) return;

        if (node.data <= min || node.data >= max) {
            result.add(node.data);
        }

        findInvalidNodes(node.left, min, Math.min(max, node.data), result);
        findInvalidNodes(node.right, Math.max(min, node.data), max, result);
    }

    
    public static int maxBSTSize(TreeNode root) {
        return postOrderMaxBST(root).maxBSTSize;
    }

    static class Info {
        boolean isBST;
        int size;
        int maxBSTSize;
        int minVal, maxVal;

        Info(boolean isBST, int size, int maxBSTSize, int minVal, int maxVal) {
            this.isBST = isBST;
            this.size = size;
            this.maxBSTSize = maxBSTSize;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    private static Info postOrderMaxBST(TreeNode node) {
        if (node == null) return new Info(true, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = postOrderMaxBST(node.left);
        Info right = postOrderMaxBST(node.right);

        boolean isBST = left.isBST && right.isBST &&
                        node.data > left.maxVal && node.data < right.minVal;

        int size = left.size + right.size + 1;

        if (isBST) {
            return new Info(true, size, size,
                    Math.min(node.data, left.minVal),
                    Math.max(node.data, right.maxVal));
        } else {
            return new Info(false, size, Math.max(left.maxBSTSize, right.maxBSTSize), 0, 0);
        }
    }

    
    public static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); 
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12); 

    
        System.out.println("是否為合法 BST: " + isValidBST(root));

       
        List<Integer> invalid = new ArrayList<>();
        findInvalidNodes(root, Long.MIN_VALUE, Long.MAX_VALUE, invalid);
        System.out.println("不合法的節點值: " + invalid);

       
        int total = countNodes(root);
        int maxBST = maxBSTSize(root);
        System.out.println("最少需要移除節點數: " + (total - maxBST));
    }
}