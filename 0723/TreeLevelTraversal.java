import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.data);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(level);
        }

        return result;
    }

   
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

               
                if (leftToRight) {
                    level.addLast(curr.data);
                } else {
                    level.addFirst(curr.data);
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

  
    public static void printLastNodeEachLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                last = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            System.out.println("最後節點: " + last.data);
        }
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

    
        System.out.println("層序走訪（每層一列）:");
        List<List<Integer>> levelResult = levelOrder(root);
        for (List<Integer> level : levelResult) {
            System.out.println(level);
        }

        System.out.println("\n之字形層序走訪:");
        List<List<Integer>> zigzagResult = zigzagLevelOrder(root);
        for (List<Integer> level : zigzagResult) {
            System.out.println(level);
        }

        System.out.println("\n每層最後一個節點:");
        printLastNodeEachLevel(root);
    }
}