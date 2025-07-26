public class SimpleBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

 
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(25);
        root.left.right.left = new TreeNode(35);
        root.left.right.right = new TreeNode(45);
        root.right.right.left = new TreeNode(75);
        root.right.right.right = new TreeNode(90);

        
        System.out.println("搜尋 30: " + search(root, 30));
        System.out.println("搜尋 40: " + search(root, 40));
        System.out.println("搜尋 60: " + search(root, 60));
        System.out.println("搜尋 25: " + search(root, 25));
        System.out.println("搜尋 75: " + search(root, 75)); 
        System.out.println("搜尋 100: " + search(root, 100)); 
    }
}