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
                    System.out.print( i + ":");
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



                    while (line != null) {

                        if (line.startsWith("n"))
                        {
                            printGraph(graph);
                            graph.clear();
                            graph.add(new ArrayList<>());
                        }

                        // add vertex
                        if (line.contains("add vertex"))
                        {
                            graph.add(new ArrayList<>());
                        }

                        // add edge
                        else if (line.contains("add edge"))
                        {
                            if (line.length()==14)
                            {
                                char parseEdge1 = line.charAt(9);
                                char parseEdge2 = line.charAt(13);
                                int firstEdge = Character.getNumericValue(parseEdge1);
                                int secondEdge = Character.getNumericValue(parseEdge2);

                                addEdge(graph, firstEdge, secondEdge);
                            }
                            else if (line.length()==15)
                            {

                                String firstparse = line.substring(9,15);
                                String delims = "[ -]+";
                                String[] tokens = firstparse.split(delims);
                                int firstoken = Integer.parseInt(tokens[0]);
                                int secondtoken = Integer.parseInt(tokens[1]);
                                addEdge(graph, firstoken,secondtoken);
                            }
                            else if (line.length()==16)
                            {

                                String firstparse = line.substring(9,16);
                                String delims = "[ -]+";
                                String[] tokens = firstparse.split(delims);
                                int firstoken = Integer.parseInt(tokens[0]);
                                int secondtoken = Integer.parseInt(tokens[1]);
                                addEdge(graph, firstoken,secondtoken);
                            }
                        }


                        line = br.readLine();
                    }

                printGraph(graph);

                    br.close();
                } catch(Exception ex){
                    ex.printStackTrace();
                }

        }
    }

