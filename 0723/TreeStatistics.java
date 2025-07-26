public class TreeStatistics {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

   
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

 
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

  
    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

   
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        
        System.out.println("節點總和: " + sum(root));           
        System.out.println("最大值: " + findMax(root));        
        System.out.println("最小值: " + findMin(root));        
        System.out.println("葉節點數量: " + countLeaves(root)); 
        System.out.println("樹的深度: " + getDepth(root));      
    }
}