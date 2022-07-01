

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOHelper {

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException { 
		
		// complete this method
		ArrayList<Student> students = new ArrayList<>();
		String[] line;
		
		try {
			FileReader fr = new FileReader(filePath);
			Scanner sc = new Scanner(fr);
				 
			while (sc.hasNextLine()) {
				line = sc.nextLine().split(" ");
				students.add(new Student(line[0], Integer.parseInt(line[1])));
			}
						
		} catch  (FileNotFoundException e){
			e.printStackTrace();
		}
		
		return students;
	}


	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { 
		
		// complete this method
		Graph graph = new Graph();
		

		try {
			FileReader fr = new FileReader(filePath);
			Scanner sc = new Scanner(fr);
		
			int numVertices = Integer.parseInt(sc.nextLine());
			graph.numVertices = numVertices;
			graph.adjList = new ArrayList<ArrayList<Edge>>(numVertices);

			for (int i = 0; i < numVertices; i++)
				graph.adjList.add(new ArrayList<Edge>());
			
			while(sc.hasNextLine()) {
				String [] line = sc.nextLine().split(" ");
				int src = Integer.parseInt(line[0]);
				int dest = Integer.parseInt(line[1]);
				int weight = Integer.parseInt(line[2]);

				Edge e = new Edge(src, dest, weight);
				ArrayList<Edge> x = graph.adjList.get(src);
				x.add(e);
				graph.adjList.set(src, x);
			}
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return graph;
	}
}


