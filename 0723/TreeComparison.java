public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

  
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

   
    public static boolean isSubtree(TreeNode a, TreeNode b) {
        if (b == null) return true;    
        if (a == null) return false;   

        if (isSameTree(a, b)) return true;

        return isSubtree(a.left, b) || isSubtree(a.right, b);
    }

    
    static class Result {
        TreeNode node;
        int size;

        Result(TreeNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    public static TreeNode findLargestCommonSubtree(TreeNode a, TreeNode b) {
        return helper(a, b).node;
    }

    private static Result helper(TreeNode a, TreeNode b) {
        if (a == null || b == null) return new Result(null, 0);

        if (a.val == b.val) {
            Result left = helper(a.left, b.left);
            Result right = helper(a.right, b.right);
            if (left.node == a.left && right.node == a.right) {
                int size = 1 + left.size + right.size;
                return new Result(a, size);
            }
        }

        Result leftSub = helper(a.left, b);
        Result rightSub = helper(a.right, b);
        Result crossLeft = helper(a, b.left);
        Result crossRight = helper(a, b.right);

        Result max = leftSub;
        if (rightSub.size > max.size) max = rightSub;
        if (crossLeft.size > max.size) max = crossLeft;
        if (crossRight.size > max.size) max = crossRight;

        return max;
    }

    
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
       
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);

      
        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(6);
        B.right = new TreeNode(7);

      
        TreeNode C = new TreeNode(2);
        C.left = new TreeNode(4);
        C.right = new TreeNode(99);  

        System.out.println("是否完全相同 (A, B): " + isSameTree(A, B)); 
        System.out.println("B 是否為 A 的子樹: " + isSubtree(A, B));    
        System.out.println("C 是否為 A 的子樹: " + isSubtree(A, C));   

     
        TreeNode common = findLargestCommonSubtree(A, B);
        System.out.print("最大公共子樹中序: ");
        printInOrder(common); 
        System.out.println();
    }
}