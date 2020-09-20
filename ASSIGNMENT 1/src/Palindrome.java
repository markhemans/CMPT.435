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




    public void pop() {
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

    public void dequeue() {
        front = front.next;
    }

    public boolean queueEmpty() {
        return front == null;
    }

    public boolean stackEmpty() {
        return top == null;
    }

    public Palindrome() throws IOException {

        BufferedReader reader = new BufferedReader((new FileReader("magicitems.txt")));
        try {

            String line = reader.readLine();
            String[] word = new String[line.length()];

            for (int i=0; i<line.length(); i++)
            {
                String a = line.substring(i);
                word[i] = a;
                new Node(a);
                push(a);
                enqueue(a);
            }


            for (int j=0; j<line.length(); j++)
            {
                //front = word[0];

                if (front == top)
                {
                    System.out.println("It's a palindrome.");
                    pop();
                    dequeue();
                }

                else
                {
                    System.out.println("It's not a palindrome.");
                    pop();
                    dequeue();
                }


            }

            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }





    public static void main(String[] args) throws IOException {

    new Palindrome();

    }


}

