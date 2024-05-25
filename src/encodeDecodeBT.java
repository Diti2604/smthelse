import java.util.*;

public class encodeDecodeBT {

    public static class TreeNode2 {
        int val;
        TreeNode2 left;
        TreeNode2 right;

        TreeNode2(int x) {
            val = x;
        }
    }

    public String encode(TreeNode2 root) {
        if (root == null) return "";
        Queue<TreeNode2> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode2 node = queue.poll();
            if (node == null) {
                result.append("n ");
                continue;
            }
            result.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return result.toString().trim();
    }

    public TreeNode2 decode(String data) {
        if (data.isEmpty()) return null;
        Queue<TreeNode2> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode2 root = new TreeNode2(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode2 parent = queue.poll();
            if (!values[i].equals("n")) {
                TreeNode2 left = new TreeNode2(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if (++i < values.length && !values[i].equals("n")) {
                TreeNode2 right = new TreeNode2(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        encodeDecodeBT test = new encodeDecodeBT();

        TreeNode2 root1 = new TreeNode2(1);
        root1.left = new TreeNode2(2);
        root1.right = new TreeNode2(3);
        root1.right.left = new TreeNode2(4);
        root1.right.right = new TreeNode2(5);

        String encoded1 = test.encode(root1);
        System.out.println("Encoded: " + encoded1);
        TreeNode2 decoded1 = test.decode(encoded1);
        System.out.println("Decoded Tree: " + test.encode(decoded1));

    }
}
