
class Trim {
    public TreeNode3 trim(TreeNode3 root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.value < low){
            root = trim(root.right, low, high);
        }else if(root.value > high){
            root = trim(root.left, low, high);
        }else if(root.value == low){
            root.left = null;
            root.right = trim(root.right, low, high);
        }else if(root.value == high){
            root.left = trim(root.left, low, high);
            root.right = null;
        }else{
            root.left = trim(root.left, low, high);
            root.right = trim(root.right, low, high);
        }
        return root;
    }
}
class TreeNode3 {
    int value;
    TreeNode3 left;
    TreeNode3 right;
    TreeNode3() {}
    TreeNode3(int value) { this.value = value; }
    TreeNode3(int value, TreeNode3 left, TreeNode3 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}