import java.util.*;

public class HasPath {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        boolean hasPath = new HasPath().validPath(3, edges, 0, 2);
        System.out.println(hasPath);
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyListMap(edges);
        boolean[] visited = new boolean[n];
        return hasPath(adjacencyList, start, end, visited);
    }

    public boolean hasPath(Map<Integer, List<Integer>> adjacencyList, int start, int end, boolean[] visited) {
        if(start == end) {
            return true;
        }

        visited[start] = true;

        if(adjacencyList.get(start) != null) {
            for(int adjacent : adjacencyList.get(start)) {
                if(!visited[adjacent] && hasPath(adjacencyList, adjacent, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Integer, List<Integer>> getAdjacencyListMap(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            List<Integer> list1 = adjacencyList.getOrDefault(source, new ArrayList<>());
            List<Integer> list2 = adjacencyList.getOrDefault(destination, new ArrayList<>());

            list1.add(destination);
            list2.add(source);

            adjacencyList.put(source, list1);
            adjacencyList.put(destination, list2);
        }
        return adjacencyList;
    }
}
