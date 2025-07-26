public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

   
    static class Counter {
        int count = 0;
        int result = -1;
    }

   
    public static void findKth(TreeNode root, int k, Counter counter) {
        if (root == null || counter.count >= k) return;

       
        findKth(root.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = root.data;
            return;
        }

        findKth(root.right, k, counter);
    }

    
    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        findKth(root, k, counter);
        return counter.result;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

     
        for (int k = 1; k <= 7; k++) {
            System.out.println("第 " + k + " 小的元素: " + kthSmallest(root, k));
        }
    }
}