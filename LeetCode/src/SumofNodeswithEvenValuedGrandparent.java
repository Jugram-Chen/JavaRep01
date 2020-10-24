/**
 * @author Jugram Chen
 * @create 2020-08-12 16:41
 */
public class SumofNodeswithEvenValuedGrandparent {
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        inOrderTraveral(root);
        return sum;
    }
    public void inOrderTraveral(TreeNode node){//中序
        if(node == null){
            return;
        }
        if(node.val%2==0){
            addGrandchildNode(node);
            System.out.println(node.val);
        }

        inOrderTraveral(node.left);
        inOrderTraveral(node.right);
    }
    public void addGrandchildNode(TreeNode tn){
        if(tn.left!=null&&tn.left.left!=null)
            sum=sum+tn.left.left.val;
        if(tn.left!=null&&tn.left.right!=null)
            sum=sum+tn.left.right.val;
        if(tn.right!=null&&tn.right.left!=null)
            sum=sum+tn.right.left.val;
        if(tn.right!=null&&tn.right.right!=null)
            sum=sum+tn.right.right.val;
    }

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
}
