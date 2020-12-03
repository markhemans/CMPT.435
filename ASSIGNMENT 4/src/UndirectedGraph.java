import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UndirectedGraph {

    private static final String FILE_NAME = "graphs1.txt";

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int firstVertex, int secondVertex)
        {
            graph.get(firstVertex).add(secondVertex);
            graph.get(secondVertex).add(secondVertex);
        }


    static void printGraph(ArrayList<ArrayList<Integer>> graph)
        {
            for (int i = 0; i < graph.size(); i++) {
                System.out.println("\nVertex " + i + ":");
                for (int j = 0; j < graph.get(i).size(); j++) {
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
                ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

                if (line.startsWith("n"))
                {
                    graph = new ArrayList<ArrayList<Integer>>();
                }

                else {

                    while (line != null) {


                        // add vertex
                        if (line.contains("vertex")) {
                            graph.add(new ArrayList<>());
                            line = br.readLine();
                        }

                        // add edge
                        else if (line.contains("edge")) {
                            addEdge(graph, line.charAt(10), line.charAt(14));
                            line = br.readLine();
                        }

                        printGraph(graph);
                    }
                    }
                    br.close();
                } catch(Exception ex){
                    ex.printStackTrace();
                }

        }
    }

