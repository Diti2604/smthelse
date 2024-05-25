
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxNodes(TreeNode root) {
        return countMaximumNodes(root, Integer.MIN_VALUE);
    }

    private int countMaximumNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= max) {
            count = 1;
            max = node.val;
        }

        count += countMaximumNodes(node.left, max);
        count += countMaximumNodes(node.right, max);

        return count;
    }
}
