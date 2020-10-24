import java.util.ArrayList;

public class LowestCommonAncestorofaBinaryTree {
    //    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null)
//            return null;
//        if (p.val == root.val)
//            return root;
//        if (q.val == root.val)
//            return root;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null)
//            return root;
//        return (left != null) ? left : right;
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(contains(root.left,p,q))
                return lowestCommonAncestor(root.left,p,q);
            else if(contains(root.right,p,q))
                return lowestCommonAncestor(root.right,p,q);
            else
                return root;
    }

    public boolean contains(TreeNode root, TreeNode p,TreeNode q) {
        if(preOrder(root,p)&&preOrder(root,q))
            return true;
        return false;
    }

    public boolean preOrder(TreeNode root, TreeNode p) {
        if (null != root) {
            if(root.val==p.val)
                return true;
            preOrder(root.left,p);
            preOrder(root.right,p);
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


