import java.util.ArrayList;

/**
 * @author Donglin Chen
 * @create 2020-01-20-21:46
 */
public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean b = true;
    ArrayList<Integer> al = new ArrayList<>();


    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
//        if(root.val==Integer.MIN_VALUE)
//            return true;
//        al.add(Integer.MIN_VALUE);
        inOrderRec(root);
        return b;
    }

    public void inOrderRec(TreeNode n) {
        if (n != null) {
            inOrderRec(n.left);
            if(al.size()==0)
                al.add(n.val);
            else if (n.val <= al.get(al.size() - 1)) {
                b = false;
                return;
            } else {
                al.add(n.val);
            }
            inOrderRec(n.right);
        }
    }
}
