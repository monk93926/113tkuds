import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

   
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        int leftSize = inIndex - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + leftSize,
                               inorder, inStart, inIndex - 1, inMap);
        root.right = buildPreIn(preorder, preStart + leftSize + 1, preEnd,
                                inorder, inIndex + 1, inEnd, inMap);
        return root;
    }

    
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        int leftSize = inIndex - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + leftSize - 1,
                                inorder, inStart, inIndex - 1, inMap);
        root.right = buildPostIn(postorder, postStart + leftSize, postEnd - 1,
                                 inorder, inIndex + 1, inEnd, inMap);
        return root;
    }

    
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

  
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }


    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
       
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};   
        int[] postorder = {9, 15, 7, 20, 3};  

        
        TreeNode tree1 = buildTreeFromPreIn(preorder, inorder);
        System.out.print("中序驗證 (前+中建樹): ");
        printInOrder(tree1);
        System.out.println();

    
        TreeNode tree2 = buildTreeFromPostIn(postorder, inorder);
        System.out.print("中序驗證 (後+中建樹): ");
        printInOrder(tree2);
        System.out.println();

     
        System.out.print("前序驗證: ");
        printPreOrder(tree2);
        System.out.println();

        System.out.print("後序驗證: ");
        printPostOrder(tree2);
        System.out.println();
    }
}