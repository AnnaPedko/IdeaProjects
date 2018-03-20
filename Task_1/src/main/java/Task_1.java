import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

interface SortAlgorithm {
    void sort(int[] array);
    String getName();
}

abstract class AlgorithmName implements SortAlgorithm {
    AlgorithmName(String name)
    {
       name_ = name;
    }

    @Override
    public String getName()
    {
        return name_;
    }
    private String name_;
}

class BubbleSort extends AlgorithmName
{
    BubbleSort()
    {
        super("BubbleSort");
    }

    @Override
    public void sort(int[] array)
    {
        ArrayUtil.bubbleSort(array);
    }
}

class MergeSort extends AlgorithmName
{
    MergeSort()
    {
        super("MergeSort");
    }

    @Override
    public void sort(int[] array)
    {
        ArrayUtil.mergeSort(array);
    }
}

class QuickSort extends AlgorithmName
{
    QuickSort()
    {
        super("QuickSort");
    }

    @Override
    public void sort(int[] array)
    {
        ArrayUtil.quickSort(array);
    }
}

class SortApplier{
    public static void applySort(SortAlgorithm algorithm, int[] array)
    {
        System.out.println("Array BEFORE applying " + algorithm.getName() + " Algo" + Arrays.toString(array));
        algorithm.sort(array);
        System.out.println("Array AFTER applying " + algorithm.getName() +" Algo" + Arrays.toString(array));
    }
}

public class Task_1 {

    public static void main(String[] args)
    {
        int arraySize = 8;
        int binaryArray[] = {1, 2, 4, 6, 8, 10, 20, 1000};

        //Binary search
       int findElement = binaryArray[random(0, binaryArray.length - 1)];
       int indexElement = ArrayUtil.binarySearch(binaryArray, 0, binaryArray.length, findElement);

        System.out.println("Sorted Array for Binary Search = " + Arrays.toString(binaryArray));
        System.out.println("Index  = " + indexElement  + " of searching element = " + findElement);
        printDelimiter();

        //BubbleSort algo
        SortApplier.applySort(new MergeSort(), generateArray(arraySize, 0, 10));
        printDelimiter();
        SortApplier.applySort(new QuickSort(), generateArray(arraySize, 0, 10));
        printDelimiter();
        SortApplier.applySort(new BubbleSort(), generateArray(arraySize, 0, 10));
        printDelimiter();

        //find min, max in bubble sort array
        System.out.println("Array for finding max, min = " + Arrays.toString(binaryArray));
        System.out.println(ArrayUtil.findMax(binaryArray));
        System.out.println(ArrayUtil.findMin(binaryArray));
    }

    public static int random(int min, int max)
    {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int[] generateArray(int elementNumber, int min, int max)
    {
     int [] array = new int[elementNumber];

         for(int i = 0; i < array.length; i++)
         {
            array[i] = random(min, max);
         }

     return array;
    }

    public static void printDelimiter()
    {
        System.out.println("----------------------------------------------");
    }

}
