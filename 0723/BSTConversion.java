public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    
    static TreeNode head = null, prev = null;
    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        convertToDLL(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private static void convertToDLL(TreeNode node) {
        if (node == null) return;

        convertToDLL(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        convertToDLL(node.right);
    }

    
    public static void printDLL(TreeNode head) {
        TreeNode curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.right;
        } while (curr != head);
        System.out.println();
    }

    
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    
    static int sum = 0;
    public static void convertToGreaterTree(TreeNode root) {
        if (root == null) return;

        convertToGreaterTree(root.right);
        sum += root.val;
        root.val = sum;
        convertToGreaterTree(root.left);
    }

   
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
       
        TreeNode bst1 = new TreeNode(4);
        bst1.left = new TreeNode(2);
        bst1.right = new TreeNode(6);
        bst1.left.left = new TreeNode(1);
        bst1.left.right = new TreeNode(3);
        bst1.right.left = new TreeNode(5);
        bst1.right.right = new TreeNode(7);

        System.out.println("功能 1：BST 轉雙向鏈表");
        TreeNode dll = treeToDoublyList(bst1);
        printDLL(dll);

      
        int[] sortedArray = {-10, -3, 0, 5, 9};
        TreeNode bst2 = sortedArrayToBST(sortedArray);
        System.out.print("功能 2：陣列轉 BST 的中序結果: ");
        printInOrder(bst2);
        System.out.println();

        
        TreeNode bst3 = new TreeNode(4);
        bst3.left = new TreeNode(2);
        bst3.right = new TreeNode(6);
        bst3.left.left = new TreeNode(1);
        bst3.left.right = new TreeNode(3);
        bst3.right.left = new TreeNode(5);
        bst3.right.right = new TreeNode(7);

        System.out.println("功能 3：轉成 Greater Tree 前:");
        printInOrder(bst3);
        System.out.println();
        convertToGreaterTree(bst3);
        System.out.println("轉換後的 Greater Tree:");
        printInOrder(bst3);
        System.out.println();
    }
}