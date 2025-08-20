import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int value;
        char color;  // 'R' for Red, 'B' for Black
        Node left, right;

        Node(int value, char color) {
            this.value = value;
            this.color = color;
            this.left = this.right = null;
        }
    }

    public static void checkRBProperties(Node root) {
        if (root == null) return;

        if (root.color == 'R' && (root.left != null && root.left.color == 'R' || root.right != null && root.right.color == 'R')) {
            System.out.println("RedRedViolation at index " + root.value);
            return;
        }

        int leftBlackHeight = countBlackHeight(root.left);
        int rightBlackHeight = countBlackHeight(root.right);
        if (leftBlackHeight != rightBlackHeight) {
            System.out.println("BlackHeightMismatch");
            return;
        }

        if (root.color == 'B' && root.left == null && root.right == null) {
            System.out.println("RootNotBlack");
            return;
        }
    }

    private static int countBlackHeight(Node node) {
        if (node == null) return 1;
        return (node.color == 'B' ? 1 : 0) + Math.max(countBlackHeight(node.left), countBlackHeight(node.right));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Node root = null;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            char color = scanner.next().charAt(0);
            root = new Node(value, color);
        }

        checkRBProperties(root);
    }
}
