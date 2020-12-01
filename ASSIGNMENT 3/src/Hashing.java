/*
 Hash code tests and analytics.
 */

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;


public class Hashing extends Sorting {

    /*
    Private
    */

    private static final String FILE_NAME = "magicitems.txt";
    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;
    private static int LINEAR_COMPARISONS = 0;
    private static int BINARY_COMPARISONS = 0;

    private static final int RANDOM_VALUES = 42;

    private static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int) thisLetter;
            letterTotal = letterTotal + thisValue;
            // Test: print the char and the hash.
            /*
            System.out.print(" [");
            System.out.print(thisLetter);
            System.out.print(thisValue);
            System.out.print("] ");
            // */
        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE; // % is the "mod" operator
        // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.
        return hashCode;
    }


    public static int linearSearch(String arr[], String x) {
        int arrayLength = arr.length;
        for (int i = 0; i < arrayLength; i++) {
            if (!(arr[i].equals(x)))
            {
                LINEAR_COMPARISONS++;
            }
            else if (arr[i].equals(x))
            {
                LINEAR_COMPARISONS++;
            }
        }
        return LINEAR_COMPARISONS;
    }

    public static int binarySearch(String[] arr, String x)  {

            int leftIndex = 0;
            int rightIndex = arr.length-1;
            while (leftIndex <= rightIndex)
                {

                int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
                int result = x.compareTo(arr[middleIndex]);

                // is argument = middle position?
                if (result == 0) {
                    BINARY_COMPARISONS++;
                }

                // It is in the right side (Trump Supporter)
                if (result > 0) {
                    leftIndex = middleIndex + 1;
                    BINARY_COMPARISONS++;
                }

                // It's on the left side
                else {
                    rightIndex = middleIndex - 1;
                    BINARY_COMPARISONS++;
                }
            }
            return BINARY_COMPARISONS;
        }
        



        private static void analyzeHashValues(int[] hashValues) {
            System.out.println("\nHash Table Usage:");
            // Sort the hash values.
            Arrays.sort(hashValues);
            // This is a "dual-pivot" quicksort.
            // See https://zgrepcode.com/java/oracle/jdk-8u181/java/util/dualpivotquicksort.java
            // Actually, look at that JDK source code; it's a bunch of sorts.

            // Test: print the sorted hash values.


            for (int i=0; i < LINES_IN_FILE; i++)
            {
            System.out.println(hashValues[i]);
            }



            // Create a histogram-like report based on the count of each unique hash value,
            // count the individual entry size,
            // the total space used (in items),
            // and the standard deviation of their distribution over the hash table.
            int asteriskCount = 0;
            int[] bucketCount = new int[HASH_TABLE_SIZE];
            int totalCount = 0;
            int arrayIndex = 0;

            for (int i = 0; i < HASH_TABLE_SIZE; i++) {
                System.out.format("%03d ", i);
                asteriskCount = 0;
                while ((arrayIndex < LINES_IN_FILE) && (hashValues[arrayIndex] == i)) {
                    System.out.print("*");
                    asteriskCount = asteriskCount + 1;
                    arrayIndex = arrayIndex + 1;
                }

                System.out.print(" ");
                System.out.println(asteriskCount);
                bucketCount[i] = asteriskCount;
                totalCount = totalCount + asteriskCount;
            }


            System.out.print("Average load (count): ");
            float averageLoad = (float) totalCount / HASH_TABLE_SIZE;
            System.out.format("%.2f%n", averageLoad);

            System.out.print("Average load (calc) : ");
            averageLoad = (float) LINES_IN_FILE / HASH_TABLE_SIZE;
            System.out.format("%.2f%n", averageLoad);

            System.out.print("Standard Deviation: ");
            // TODO: Refactor this into its own method.
            double sum = 0;


            for (int i = 0; i < HASH_TABLE_SIZE; i++) {
                // For each value in the array...
                // ... subtract the mean from each one ...
                double result = bucketCount[i] - averageLoad;
                // ... and square the result.
                double square = result * result;
                // Sum all of those squares.
                sum = sum + square;
            }

            // Divide the sum by the number of values ...
            double temp = sum / HASH_TABLE_SIZE;
            // ... and take the square root of that.
            double stdDev = Math.sqrt(temp);
            System.out.format("%.2f%n", stdDev);
        }

            /*
            Public
            */

        public static void main(String[] args) {

            System.out.println("Hash code tests and analysis.");
            System.out.println("-----------------------------");

            String[] magicItems = new String[LINES_IN_FILE];
            int[] hashValues = new int[LINES_IN_FILE];

            // Read the contents of FILE_NAME into our array of size LINES_IN_FILE.

            int index = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
                String line = "";
                line = br.readLine();

                while (line != null) {
                    magicItems[index] = line;
                    index = index + 1;
                    line = br.readLine();
                }
                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //sort items
            Sorting.mergeSort(magicItems);

            // Print the array and hash values.
            int hashCode = 0;

            for (int i = 0; i < LINES_IN_FILE; i++) {
                System.out.print(i);
                System.out.print(". " + magicItems[i] + " - ");
                hashCode = makeHashCode(magicItems[i]);
                System.out.format("%03d%n", hashCode);
                hashValues[i] = hashCode;
            }

            // random items array
            String[] randomItems = new String[42];

            // select 42 random values from sorted array and put them into randomItems
            for (int k=0; k<=41; k++)
            {
                Random randomGenerator = new Random();
                int upperbound = 665;
                int int_random = randomGenerator.nextInt(upperbound);
                randomItems[k] = magicItems[int_random];
            }

            // search arrays for random items
            for (int j=0; j<=41; j++)
            {
                linearSearch(magicItems, randomItems[j]);
                binarySearch(magicItems, randomItems[j]);
            }

            // print comparisons
            System.out.println("Number of linear comparisons: " +LINEAR_COMPARISONS);
            System.out.println("Number of binary comparisons: " +BINARY_COMPARISONS);

            // Analyze the distribution of hash values.
            analyzeHashValues(hashValues);
        }

    }


