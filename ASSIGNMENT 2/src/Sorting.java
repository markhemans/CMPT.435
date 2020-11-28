import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sorting {

    public static void selectionSort(String arr[])
    {
    int selections = 0;
    for (int j=0; j<arr.length-1; j++)
        {
        int minimum = j;
        for (int k = j+1; k<arr.length; k++)
            {
            if (arr[k].toUpperCase().compareTo(arr[minimum].toUpperCase()) <0)
            {
                selections++;
                minimum = k;
            }

            String temp = arr[j];
            arr[j] = arr[minimum];
            arr[minimum] = temp;
            }
        }
    System.out.println("Selection sort comparisons: " +selections);
    }


    public static void insertionSort(String arr[])
    {
        int insertions = 0;
        for (int f=1; f<arr.length; f++)
        {
            int g = f;
            while ( (g > 0) && (arr[g-1].toUpperCase().compareTo(arr[g].toUpperCase())) >0)
            {
                String temp = arr[g-1];
                arr[g-1] = arr[g];
                arr[g] = temp;
                g--;

                insertions++;
            }
        }
        //System.out.println("Insertion sort comparisons: " +insertions);
    }

    public static void mergeSort(String arr[])
    {
        
    int size = arr.length;
        if (size < 2)
        {
            return;
        }

        int mid = size/2;
        String[] left = new String[mid];
        String[] right = new String[size-mid];

        for (int i=0; i<mid; i++)
        {
            left[i] = arr[i];

        }

        for (int i=mid; i<size; i++)
        {
            right[i-mid] = arr[i];

        }

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right,mid,size - mid);
    }

    public static void merge(String arr[], String[] left, String[] right, int leftSide, int rightSide) {

        int i = 0;
        int j = 0;
        int merged = 0;
        int mergeCount = 0;


        while ((i < leftSide) && (j < rightSide)) {

            if (left[i].toUpperCase().compareTo(right[j].toUpperCase()) < 0)
            {
                arr[merged] = left[i];
                merged++;
                i++;
                mergeCount++;
            }
            else {
                arr[merged] = right[j];
                merged++;
                j++;
                mergeCount++;
            }

        }


        while (i<leftSide)
        {
            arr[merged] = left[i];
            merged++;
            i++;

        }
        while (j<rightSide)
        {
            arr[merged] = right[j];
            merged++;
            j++;
        }

        //if (merged == 666)
        //{
            //System.out.println("Number of merges " + mergeCount);
        //}


    }




    public static void main(String[] args) {


        BufferedReader reader;
        try {

            int counter = 0;
            String[] words = new String[666];

            reader = new BufferedReader(new FileReader("magicitems.txt"));

            String line = reader.readLine();
            while (line != null)
            {

                words[counter] = line;
                counter++;
                line = reader.readLine();

            }
            reader.close();

        selectionSort(words);
        //insertionSort(words);
          //  mergeSort(words);

        for (int z=0;z<words.length;z++)
        {
            System.out.println(words[z]);
        }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

