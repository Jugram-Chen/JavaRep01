import java.util.Stack;

/**
 * @author Jugram Chen
 * @create 2020-08-23 15:07
 */
public class FlattenBinaryTreetoLinkedList {
//    TreeNode nr = new TreeNode(-1);
//    TreeNode cur = nr;
//
//    public void flatten(TreeNode root) {
//        preOrderTraveral(root);
//        root=nr.right;
//        while(root!=null){
//            System.out.println(root.val);
//            root=root.right;
//        }
//
//    }
//
//    public void preOrderTraveral(TreeNode node) {//先序
//        if (node == null) {
//            return;
//        }
//        cur.right=new TreeNode(node.val);
//        cur=cur.right;
//        preOrderTraveral(node.left);
//        preOrderTraveral(node.right);
//    }

    class TreeNode {
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

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            if (curr.right != null)
                s.push(curr.right);
            if (curr.left != null)
                s.push(curr.left);
            if (!s.isEmpty())
                curr.right = s.peek();
            curr.left = null;
        }
    }
}
