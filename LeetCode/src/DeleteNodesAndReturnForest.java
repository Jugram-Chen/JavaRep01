import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jugram Chen
 * @create 2020-08-08 13:00
 */
public class DeleteNodesAndReturnForest {
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
    List<TreeNode> al=new ArrayList<>();
    List<Integer> al2=new ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i:to_delete)
            al2.add(i);
        if(!al2.contains(root.val))
            al.add(root);
        preOrderTraveral(root);
        return al;
    }
    public void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        if(al2.contains(node.val)){
            if(node.left!=null)
                al.add(node.left);
            if(node.right!=null)
                al.add(node.right);
        }
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }
}
