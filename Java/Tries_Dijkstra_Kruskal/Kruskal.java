

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Kruskal extends Graph {

	public Kruskal(String filePath) throws FileNotFoundException { // complete this constructor
		Graph g = IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;
		
	}

	public ArrayList<Edge> runKruskal() { // complete this method
		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < adjList.size(); i++) {
			for (int j = 0; j < adjList.get(i).size(); j++) {
				edgeList.add(adjList.get(i).get(j));
			}
		}
		Collections.sort(edgeList, new SortEdgesByWeight());

		UnionFind objUF = new UnionFind(numVertices);
		ArrayList<Edge> edges = new ArrayList<>();
		int numEdgesAdded = 0;

		for (int i = 0; i < edgeList.size(); i++) {
			int src = edgeList.get(i).src;
			int dest = edgeList.get(i).dest;

			if (objUF.find(src).equals(objUF.find(dest)) == false) {
				objUF.doUnion(src, dest);
				edges.add(edgeList.get(i));
				numEdgesAdded += 1;
				if (numEdgesAdded == numVertices - 1)
					break;
			}
		}
		return edges;
	}

}

class SortEdgesByWeight implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		return o1.weight - o2.weight;
	}

}
