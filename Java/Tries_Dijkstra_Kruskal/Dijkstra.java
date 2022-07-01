

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException { // complete this constructor
		Graph g = IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;
	}

	public void execute(int source) { // complete this method
		distance = new int [numVertices];
		parent = new int [numVertices];
		closed = new boolean [numVertices];
		
		for (int i = 0; i < super.numVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			closed[i] = false;
		}
		distance[source] = 0;

		PriorityQueue<PriorityQueuePair> open = new PriorityQueue<>(new PriorityQueuePairComparator());
		open.add(new PriorityQueuePair(source, 0));

		while (open.size() > 0) {
			PriorityQueuePair minElement = open.peek();
			open.remove();
			int minVertex = minElement.item;
			if (closed[minVertex])
				continue;
			closed[minVertex] = true;

			for (int i = 0 ; i < adjList.get(minVertex).size(); i++) {
				int adjVertex = adjList.get(minVertex).get(i).dest;
				if (!closed[adjVertex]) {
					int newDist = distance[minVertex] + adjList.get(minVertex).get(i).weight;
					if (newDist < distance[adjVertex]) {
						distance[adjVertex] = newDist;
						parent[adjVertex] = minVertex;
						open.add(new PriorityQueuePair(adjVertex, newDist));
					}
				}
			}
			
		}
	}
}