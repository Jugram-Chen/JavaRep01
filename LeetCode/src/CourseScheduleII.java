import java.util.*;

public class CourseScheduleII {
    class Node {
        int val;
        ArrayList<Node> next = new ArrayList<>();
        ArrayList<Node> pre = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if(prerequisites.length==0){
//            int[] result2=new int[numCourses];
//            for(int i=0;i<numCourses;i++)
//                result2[i]=numCourses-1-i;
//            return result2;
//        }
        Set<Integer> hs = new HashSet<>();
        List<Node> nl = new ArrayList<>();
        for (int[] i : prerequisites) {
            if (hs.contains(i[0]) && hs.contains(i[1])) {
                Node temp0 = findNode(i[0], nl);
                Node temp1 = findNode(i[1], nl);
                temp0.pre.add(temp1);
                temp1.next.add(temp0);
            } else if (!hs.contains(i[0]) && !hs.contains(i[1])) {
                hs.add(i[0]);
                hs.add(i[1]);
                Node temp0 = new Node(i[0]);
                Node temp1 = new Node(i[1]);
                temp1.next.add(temp0);
                temp0.pre.add(temp1);
                nl.add(temp0);
                nl.add(temp1);
            } else if (hs.contains(i[0]) && !hs.contains(i[1])) {
                hs.add(i[1]);
                Node temp0 = findNode(i[0], nl);
                Node temp1 = new Node(i[1]);
                temp1.next.add(temp0);
                temp0.pre.add(temp1);
                nl.add(temp1);
            } else if (!hs.contains(i[0]) && hs.contains(i[1])) {
                hs.add(i[0]);
                Node temp0 = new Node(i[0]);
                Node temp1 = findNode(i[1], nl);
                temp1.next.add(temp0);
                temp0.pre.add(temp1);
                nl.add(temp0);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(!hs.contains(i)){
                hs.add(i);
                nl.add(new Node(i));
            }
        }//到此为止把所有的node都建立了前后关系，并放在了nl
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        for (int i=0;i<nl.size();i++) {
            if (nl.get(i).pre.size() == 0) {
                q.offer(nl.get(i));
                nl.remove(nl.get(i));
            }
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            result.add(cur.val);
            for (Node n : cur.next)
                n.pre.remove(cur);
            for (int i=0;i<nl.size();i++) {
                if (nl.get(i).pre.size() == 0) {
                    q.offer(nl.get(i));
                    nl.remove(nl.get(i));
                }
            }
        }
        if (nl.size() != 0)
            return new int[]{};
        int[] result2=new int[result.size()];
        for(int i=0;i<result.size();i++)
            result2[i]=result.get(i);
        return result2;
    }
    public Node findNode(int i, List<Node> nl) {
        for (Node n : nl) {
            if (n.val == i)
                return n;
        }
        return null;
    }
}
