import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UndirectedGraph {

    private static final String FILE_NAME = "graphs1.txt";

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int firstVertex, int secondVertex)
        {
            graph.get(firstVertex).add(secondVertex);
            graph.get(secondVertex).add(firstVertex);
        }


    static void printGraph(ArrayList<ArrayList<Integer>> graph)
        {
            for (int i = 0; i < graph.size(); i++)
                {
                    System.out.println("Vertex " + i + ":");
                    for (int j = 0; j < graph.get(i).size(); j++)
                        {
                            System.out.print(" -> " + graph.get(i).get(j));
                        }
                System.out.println();
            }
        }


    public static void main(String[] args)
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                String line = "";
                line = br.readLine();
                ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

                if (line.startsWith("n")) {
                    graph = new ArrayList<ArrayList<Integer>>(0);
                } else {

                    while (line != null) {

                        // add vertex
                        if (line.contains("add vertex")) {
                            graph.add(new ArrayList<>());

                        }

                        // add edge
                        else if (line.contains("add edge")) {
                            char parseEdge1 = line.charAt(9);
                            char parseEdge2 = line.charAt(13);

                            int firstEdge = Character.getNumericValue(parseEdge1);
                            int secondEdge = Character.getNumericValue(parseEdge2);

                            addEdge(graph,firstEdge, secondEdge);
                        }

                        printGraph(graph);
                        line = br.readLine();
                    }
                }
                    br.close();
                } catch(Exception ex){
                    ex.printStackTrace();
                }

        }
    }

