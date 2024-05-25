//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        // Expected max nodes in the tree: 4 (nodes with values 3, 3, 4, and 5)
        int result = testMaxNodes(root);
        System.out.println("Number of max nodes: " + result);
    }
    private static int testMaxNodes(TreeNode root) {
        Solution solution = new Solution();
        return solution.maxNodes(root);
    }
}