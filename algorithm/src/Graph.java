public class Graph {

    //    public void BFSWithQueue(Node root) {//广度遍历node
//        Queue<Node> queue = new LinkedList<>();
//        if (root != null)
//            queue.add(root);
//        Set<Node> visited = new HashSet<>();//用来查看该节点是否访问过
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            visited.add(node);
//            if (node.children != null) {
//                for (Node child : node.children) {//对于此节点所有的邻接节点进行遍历
//                    if (child != null && !visited.contains(child)
//                        queue.add(child);
//                }
//            }
//        }
//    }
//    public boolean[] DFS(int[] vertex, int[][] net) //vertex是顶点数组。net是每个顶点的连接情况
//        boolean[] isVisited = new boolean[vertex.length];
//        Stack<Integer> s = new Stack<>();
//        s.push(vertex[0]);
//        isVisited[0] = true;
//        while (!s.empty()) {
//            int i = s.pop();
//            for (int j = 0; j < vertex.length; j++) {
//                if (net[i][j] == 1 && isVisited[j] == false) {
//                    s.push(vertex[j]);
//                    isVisited[j] = true;
//                }
//            }
//        }
//        return isVisited;
//    }
//    public void dfsTraversing(int node, int[][] graph) {//递归深度遍历
//        help[node]=1;//表示此节点已被访问过
//        System.out.println(node);
//        for (int i = 0; i < graph[node].length; ++i) {
//            if (help[i]==0&&i != node&&graph[node][i]==1) {//对于这个节点所有没有访问过的邻接节点进行递归深度遍历
//                dfsTraversing(i, graph);
//            }
//        }
//    }
}
