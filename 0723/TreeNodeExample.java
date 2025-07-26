public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

     
        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }

    
    public static void printTree(TreeNode node, int level) {
        if (node == null) return;

      
        printTree(node.right, level + 1);

      
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);

        
        printTree(node.left, level + 1);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);

       
        root.left = leftChild;
        root.right = rightChild;

       
        System.out.println("根節點資訊:");
        root.displayNode();

        System.out.println("\n左子節點資訊:");
        leftChild.displayNode();

        System.out.println("\n右子節點資訊:");
        rightChild.displayNode();

        
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        leftChild.left = node1;
        leftChild.right = node2;

        System.out.println("\n更新後的左子節點資訊:");
        leftChild.displayNode();

       
        System.out.println("\n樹的結構（橫向顯示）:");
        printTree(root, 0);
    }
}