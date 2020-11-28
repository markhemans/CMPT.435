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
        if (!stackEmpty())
        {
            top = top.next;
        }
        else {
            System.out.println("EMPTY STACK ERROR");
        }
    }

    public void push(String value) {
        Node prevTop = top;
        top = new Node(value);
        top.next = prevTop;
    }

    public void enqueue(String value) {
        if (queueEmpty())
        {
            front = new Node(value);
            rear = front;
            front.next = rear;
        }
        else {
            rear = new Node(value);
        }
    }

    public void dequeue() {
        if (!queueEmpty())
        {
            front = front.next;
        }
        else {
            System.out.println("EMPTY QUEUE ERROR");
        }
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
            Node words[] = new Node[line.length()];

            for (int i=0; i<line.length(); i++)
            {
                String a = String.valueOf(line.charAt(i));


                words[i] = new Node(a);



                push(a);
                enqueue(a);


            }


            for (int j=0; j<line.length(); j++)
            {

                if (rear == top)
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

