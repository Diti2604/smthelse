import java.util.*;

class BSTIterator implements Iterator<Integer> {
    private Stack<TreeNode2> stacks;

    public BSTIterator(TreeNode2 root) {
        stacks = new Stack<>();
        pushAll(root);
    }

    @Override
    public boolean hasNext() {
        return !stacks.isEmpty();
    }

    @Override
    public Integer next() {
        TreeNode2 node = stacks.pop();
        pushAll(node.right);
        return node.value;
    }

    private void pushAll(TreeNode2 node) {
        while (node != null) {
            stacks.push(node);
            node = node.left;
        }
    }
}

class TreeNode2 {
    int value;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        value = x;
    }
}

class BinarySearchTree implements Iterable<Integer> {
    private TreeNode2 root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private TreeNode2 insertHelper(TreeNode2 root, int value) {
        if (root == null) {
            return new TreeNode2(value);
        }

        if (value < root.value) {
            root.left = insertHelper(root.left, value);
        } else if (value > root.value) {
            root.right = insertHelper(root.right, value);
        }

        return root;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BSTIterator(root);
    }
}

public class BTIterator {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        for (int value : bst) {
            System.out.println(value);
        }
    }
}
