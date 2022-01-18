import java.util.*;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> paths;
    public int destinationVertex;

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, {3}, {3}, {}
        };

        List<List<Integer>> paths = new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);
        for(List<Integer> path : paths) {
            for(int x : path) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        destinationVertex = graph.length - 1;
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        solve(graph, 0, currPath);
        return paths;
    }

    public void solve(int[][] graph, int sourceVertex, List<Integer> currPath) {
        if(sourceVertex == destinationVertex) {
            paths.add(new ArrayList<>(currPath));
        }
        for(int i = 0;i < graph[sourceVertex].length; i++) {
            currPath.add(graph[sourceVertex][i]);
            solve(graph, graph[sourceVertex][i], currPath);
            currPath.remove(currPath.size() - 1);
        }
    }

}
