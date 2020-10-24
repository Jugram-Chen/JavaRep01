import java.util.LinkedList;
import java.util.List;

public class MinStack {
    List<Integer> ll;
    public MinStack() {
        ll=new LinkedList<>();

    }

    public void push(int x) {
        ll.add(x);
    }

    public void pop() {
        ll.remove(ll.size()-1);
    }

    public int top() {
        return ll.get(ll.size()-1);
    }

    public int getMin() {
        int min=ll.get(0);
        for(int i:ll){
            if(i<min)
                min=i;
        }
        return min;
    }
}
