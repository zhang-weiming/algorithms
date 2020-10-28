package nowcoder;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Jz17 {

    public static boolean preOrderTraveral(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return false;

        if (root1.val == root2.val && isSubtree(root1, root2))
            return true;
        else if (preOrderTraveral(root1.left, root2) || preOrderTraveral(root1.right, root2)) {
            return true;
        }
        return false;
    }

    public static boolean isSubtree(TreeNode node1, TreeNode node2) {
        if (node2 == null)
            return true;
        if (node1 == null)
            return false;

        if (node1.val == node2.val &&
                isSubtree(node1.left, node2.left) &&
                isSubtree(node1.right, node2.right) ) {
            return true;
        }
        return false;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return preOrderTraveral(root1, root2);
    }
}
