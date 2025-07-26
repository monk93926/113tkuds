import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }


    public static void printAllRootToLeafPaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfsAllPaths(root, path);
    }

    private static void dfsAllPaths(TreeNode node, List<Integer> path) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println("根到葉路徑: " + path);
        } else {
            dfsAllPaths(node.left, new ArrayList<>(path));
            dfsAllPaths(node.right, new ArrayList<>(path));
        }
    }

    
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

      
        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.data)
            || hasPathSum(root.right, targetSum - root.data);
    }

    public static List<Integer> findMaxSumPath(TreeNode root) {
        List<Integer> bestPath = new ArrayList<>();
        maxSumPathHelper(root, 0, new ArrayList<>(), new int[]{Integer.MIN_VALUE}, bestPath);
        return bestPath;
    }

    private static void maxSumPathHelper(TreeNode node, int sum, List<Integer> path,
                                         int[] maxSum, List<Integer> bestPath) {
        if (node == null) return;

        sum += node.data;
        path.add(node.data);

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                bestPath.clear();
                bestPath.addAll(path);
            }
        } else {
            maxSumPathHelper(node.left, sum, new ArrayList<>(path), maxSum, bestPath);
            maxSumPathHelper(node.right, sum, new ArrayList<>(path), maxSum, bestPath);
        }
    }

    public static void main(String[] args) {
       

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

       
        System.out.println("所有根到葉路徑：");
        printAllRootToLeafPaths(root);

        
        System.out.println("\n是否存在總和為 22 的根到葉路徑？" + hasPathSum(root, 22));

        
        List<Integer> maxPath = findMaxSumPath(root);
        System.out.println("\n總和最大的根到葉路徑: " + maxPath);
    }
}
