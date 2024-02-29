package com.staticvoid.dsa.basics.graph;

/**
 *
 *
 *
 *         0
      /    \
     1  __   2
     |       |
     3  __   4

 */
public class DfsTraversalGraph {

	public static void main(String[] args) {
		DfsTraversalGraph dfs = new DfsTraversalGraph();
		dfs.dfs(0, dfs.graph);
		System.out.println();
		DfsTraversalGraph dfs2 = new DfsTraversalGraph(true);
		dfs2.dfs(1, dfs2.graph);

	}

	private CustomAdjacentGraph graph;
	private boolean[] visited;

	public DfsTraversalGraph() {
		System.out.println("Following is DFS ");
		graph = new CustomAdjacentGraph();
		visited = new boolean[graph.getNumberOfVertices()];
	}

	public DfsTraversalGraph(boolean dummy) {
		System.out.println("Following is DFS 2 ");
		graph = new CustomAdjacentGraph(8, true);
		visited = new boolean[graph.getNumberOfVertices()];
	}

	public void dfs(int source, CustomAdjacentGraph graph) {

		visited[source] = true;
		System.out.print(source);
		for (int adjacent : graph.getAdjacentList().get(source)) {
			if (!visited[adjacent]) {
				dfs(adjacent, graph);
			}

		}

	}

}
