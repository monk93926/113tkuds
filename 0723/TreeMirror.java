public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

  
    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.data != b.data) return false;

        
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

  
    public static void mirror(TreeNode root) {
        if (root == null) return;

        
        mirror(root.left);
        mirror(root.right);

     
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
       
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);

        System.out.println("是否為對稱樹: " + isSymmetric(root1));

       
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);

        System.out.println("兩棵樹是否互為鏡像: " + isMirror(root1, root2)); 

        mirror(root1);
        System.out.print("鏡像後的 root1（中序走訪）: ");
        inOrder(root1);  
        System.out.println();
    }
}