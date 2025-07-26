import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

  
    public static int distance(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        int d1 = depth(lca, val1, 0);
        int d2 = depth(lca, val2, 0);
        return d1 + d2;
    }

    public static TreeNode findLCA(TreeNode node, int v1, int v2) {
        if (node == null) return null;
        if (node.val == v1 || node.val == v2) return node;

        TreeNode left = findLCA(node.left, v1, v2);
        TreeNode right = findLCA(node.right, v1, v2);

        if (left != null && right != null) return node;
        return (left != null) ? left : right;
    }

    public static int depth(TreeNode node, int target, int level) {
        if (node == null) return -1;
        if (node.val == target) return level;

        int left = depth(node.left, target, level + 1);
        if (left != -1) return left;

        return depth(node.right, target, level + 1);
    }

    
    static int diameter = 0;

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        calcHeight(root);
        return diameter;
    }

    private static int calcHeight(TreeNode node) {
        if (node == null) return 0;

        int left = calcHeight(node.left);
        int right = calcHeight(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    
    public static List<Integer> nodesAtDistance(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        collectAtDistance(root, k, result);
        return result;
    }

    private static void collectAtDistance(TreeNode node, int dist, List<Integer> result) {
        if (node == null) return;

        if (dist == 0) {
            result.add(node.val);
        } else {
            collectAtDistance(node.left, dist - 1, result);
            collectAtDistance(node.right, dist - 1, result);
        }
    }

    public static void main(String[] args) {
   
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

       
        System.out.println("節點 4 和 5 的距離: " + distance(root, 4, 5)); 
        System.out.println("節點 4 和 6 的距離: " + distance(root, 4, 6)); 

        System.out.println("樹的直徑（最長距離）: " + treeDiameter(root)); 

        
        System.out.println("距離根節點 2 的節點: " + nodesAtDistance(root, 2)); 
    }
}