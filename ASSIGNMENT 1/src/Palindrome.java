import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Palindrome {

    private static class Node
    {
        String value;
        Node next;

        Node(String value)
        {
            this.value = value;

        }


    }


    private Node top;
    private Node front;
    private Node rear;


    public void pop(String value) {
            top = top.next;

    }

    public void push(String value) {
        Node prevTop = top;
        top = new Node(value);
        top.next = prevTop;
    }

    public void enqueue(String value) {
        rear = new Node(value);


    }

    public void dequeue(String value) {
        front = front.next;

    }

    public Palindrome() throws IOException {

        BufferedReader reader = new BufferedReader((new FileReader("magicitems.txt")));
        try {

            String line = reader.readLine();

            for (int i=0; i<line.length(); i++)
            {
                String a = line.substring(i);
                new Node(a);
                push(a);
                enqueue(a);

            }



            for (int j=0; j<line.length(); j++)
            {

                if (front == top)
                {
                    System.out.println("Its a palindrome");

                    pop();

                    dequeue();
                }
                else
                {
                    System.out.println("Its not a palindrome");
                    pop();
                    dequeue();
                }

                 reader.readLine();

            }

            } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    reader.close();
    }





    public static void main(String[] args) throws IOException {

    new Palindrome();

    }


}

