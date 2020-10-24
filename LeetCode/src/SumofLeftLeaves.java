/**
 * @author Jugram Chen
 * @create 2020-08-23 13:05
 */
public class SumofLeftLeaves {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        inOrderLeft(root.left);
        inOrderRight(root.right);
        return sum;
    }
    public void inOrderLeft(TreeNode node){
        if(node == null)
            return;
        if(node.left==null&&node.right==null)
            sum=sum+node.val;
        inOrderLeft(node.left);
        inOrderRight(node.right);
    }
    public void inOrderRight(TreeNode node){
        if(node == null)
            return;
        inOrderLeft(node.left);
        inOrderRight(node.right);
    }
}
