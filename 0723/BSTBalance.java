public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

   
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

   
    static class Result {
        TreeNode mostUnbalanced;
        int maxImbalance = -1;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        Result result = new Result();
        dfsFindImbalance(root, result);
        return result.mostUnbalanced;
    }

    private static void dfsFindImbalance(TreeNode node, Result result) {
        if (node == null) return;

        int balance = Math.abs(getBalanceFactor(node));
        if (balance > result.maxImbalance) {
            result.maxImbalance = balance;
            result.mostUnbalanced = node;
        }

        dfsFindImbalance(node.left, result);
        dfsFindImbalance(node.right, result);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(2);
        root.left.left.left.right.left = new TreeNode(1);

        
        System.out.println("是否為平衡樹: " + isBalanced(root));  // false

        
        System.out.println("節點平衡因子:");
        printBalanceFactors(root);

        
        TreeNode worst = findMostUnbalancedNode(root);
        System.out.println("最不平衡的節點值: " + worst.val +
                           "，平衡因子: " + getBalanceFactor(worst));
    }

    
    public static void printBalanceFactors(TreeNode node) {
        if (node == null) return;
        printBalanceFactors(node.left);
        System.out.println("節點 " + node.val + "：平衡因子 = " + getBalanceFactor(node));
        printBalanceFactors(node.right);
    }
}