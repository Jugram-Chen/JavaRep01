import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class BinarySearchTreeIterator {
    ArrayList<Integer> al = new ArrayList<>();
    Stack<Integer> s = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        preOrderRec(root);
        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else
                    return 1;
            }
        });
        for (Integer i : al)
            s.push(i);
    }

    public void preOrderRec(TreeNode n) {
        if (n != null) {
            al.add(n.val);
            preOrderRec(n.left);
            preOrderRec(n.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return s.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !s.empty();
    }
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
        TreeNode left1 = this.left;
        this.left = left;
        this.right = right;
    }
}
