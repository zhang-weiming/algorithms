package nowcoder;

public class Jz18 {

    public static void preOrderTraveral(TreeNode node) {
        if (node == null)
            return;

//        swap
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public void Mirror(TreeNode root) {
        preOrderTraveral(root);
    }
}
