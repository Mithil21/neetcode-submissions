class Solution {

    public boolean hasCycle(Map<Integer, List<Integer>> graph, int node, boolean[] visited, boolean[] visiting){

        if(visited[node]){
            return false;
        }

        if(visiting[node]){
            return true;
        }

        visiting[node] = true;

        List<Integer> list = graph.getOrDefault(node, new ArrayList<>());
        for(Integer neighbout : list){
            if(hasCycle(graph, neighbout, visited, visiting)){
                return true;
            }
        }

        visited[node] = true;
        visiting[node] = false;

        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
        }

        boolean[] visited = new boolean[numCourses];

        boolean[] visiting = new boolean[numCourses];

        for(int course = 0; course < numCourses; course++){
            if(hasCycle(graph, course, visited, visiting)){
                return false;
            }
        }

        return true;
    }
}
