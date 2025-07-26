import java.util.ArrayList;

public class BSTRangeQuery {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

   
    public static void rangeQuery(TreeNode root, int min, int max, ArrayList<Integer> result) {
        if (root == null) return;

      
        if (root.data > min) {
            rangeQuery(root.left, min, max, result);
        }

       
        if (root.data >= min && root.data <= max) {
            result.add(root.data);
        }

        
        if (root.data < max) {
            rangeQuery(root.right, min, max, result);
        }
    }

    public static void main(String[] args) {
  
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        
        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, 12, 27, result);

       
        System.out.println("範圍 [12, 27] 內的節點值: " + result);
    }
}