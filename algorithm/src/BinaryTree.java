public class BinaryTree {
    class TreeNode {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public static void preOrderTraveral(TreeNode node){//先序
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void inOrderTraveral(TreeNode node){//中序
        if(node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data+" ");
        inOrderTraveral(node.rightChild);
    }
    public static void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.data+" ");
    }

}
