import java.util.*;

public class UndirectedGraph {


  //  public static ArrayList<ArrayList<Integer>> newGraph()
    //{
      //  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //return graph;
    //}

    // create vertex (inner list)
    public static void addVertex(ArrayList<Integer> innerGraph, int vertexIndex)
        {
            innerGraph.add(vertexIndex);
        }

    // create vertex (outer list)
    public static void addVertex(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> innerGraph, int s)
        {
            graph.add(innerGraph);
        }

    // create an 'edge' between 'vertexes' in a 'graph' of arrayLists
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int firstVertex, int secondVertex)
        {
            graph.get(firstVertex).add(secondVertex);
            graph.get(secondVertex).add(secondVertex);
        }



    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj)
        {
            for (int i = 0; i < adj.size(); i++)
            {
                System.out.println("\nAdjacency list of vertex" + i);
                System.out.print("head");
                for (int j = 0; j < adj.get(i).size(); j++)
                {
                    System.out.print(" -> "+adj.get(i).get(j));
                }

                System.out.println();
            }
        }


    public static void main(String[] args)
        {

            // Creating a graph with 5 vertices
            int V = 5;

            ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < V; i++)
            {
                adj.add(new ArrayList<Integer>());
            }




                addEdge(graph,0,1);
                addEdge(adj, 0, 4);
                addEdge(adj, 1, 2);
                addEdge(adj, 1, 3);
                addEdge(adj, 1, 4);
                addEdge(adj, 2, 3);
                addEdge(adj, 3, 4);

                printGraph(adj);


        }
    }

