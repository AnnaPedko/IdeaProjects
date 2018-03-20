import java.util.Arrays;

public class ArrayUtil
{
    /**
     * Sort a given array using BubbleSort algorithm
     *
     * @param array array which should be sorted ;
     **/
    public static void bubbleSort(int[] array)
    {
        if(array.length != 0)
        {
            for (int i = array.length - 1; i > 0; --i)
            {
                for (int j = 0; j < i; j++)
                {
                    if (array[j] > array[j + 1])
                    {
                        swap(array, j, j + 1);
                    }
                }
            }
        }
    }

    /**
     * Find maximum element in a given array
     *
     * @param array array of element ;
     * @return      max element in array
     **/
    public static int findMax(int[] array)
    {
        int maxElement = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if ( array[i] > maxElement)
               maxElement = array[i];
        }

        return maxElement;
    }

    /**
     * Find minimum element in a given array
     *
     * @param array array of element ;
     * @return      min element in array
     **/
    public static int findMin(int[] array)
    {
        int minElement = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if ( array[i] < minElement)
                minElement = array[i];
        }

        return minElement;
    }

    /**
     * Find an index of searching element using a BinarySearch algorithm
     *
     * @param array sorted array which contains element ;
     * @param startIndex the start index in the searching range
     * @param endIndex the endIndex in the searching range;
     * @param element the searching element
     *
     * @return index of searching element
     **/
    public static int binarySearch( int[] array, int startIndex, int endIndex, int element)
    {
        int enterIndex = startIndex + (endIndex - startIndex)/2;
        int arrayElement = array[enterIndex];

        if (element != arrayElement)
        {
            if (element > arrayElement)
            {
                enterIndex = binarySearch(array, enterIndex, endIndex, element);
            } else {
                enterIndex = binarySearch(array, startIndex, enterIndex, element);
            }
        }

        return enterIndex;
    }

    /**
     * Sort a given array using QuickSort algorithm
     *
     * @param array Array which should be sorted
     **/
    public static void quickSort(int[] array)
    {
      quickSortArray(array, 0, array.length );
    }

    private static void quickSortArray( int[] array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex )
        {
            int partitionIndex = getPartitionIndex(array, startIndex, finishIndex);
            quickSortArray(array, startIndex, partitionIndex - 1);
            quickSortArray(array, partitionIndex + 1, finishIndex );
        }
    }

    private static int getPartitionIndex(int[] array, int startIndex, int finishIndex)
    {
        int pivotIndex = finishIndex - 1;
        int pivotElement = array[pivotIndex];
        int partition = startIndex;

        for (int j = startIndex; j < finishIndex - 1; j++)
        {
            if (array[j] <= pivotElement)
            {
                swap(array, partition, j);
                partition++;
            }
        }

        swap(array, partition, pivotIndex );

        return partition;
    }

    /**
     * Sort a given array using MergeSort algorithm
     *
     * @param array Array which should be sorted ;
     **/
    public static void mergeSort(int[] array)
    {
       mergeSortArray(array, 0, array.length - 1);
    }

    private static void mergeSortArray(int[]array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex) {

            int mediana = startIndex + (finishIndex - startIndex) / 2;

            //System.out.println("First recursion -> " + "Start Index = " + startIndex + " Mediana = " + mediana + " finishIndex  = " + finishIndex);
            mergeSortArray(array, startIndex, mediana);

            //System.out.println("Second recursion -> " + "Start Index = " + startIndex+" Mediana = " + mediana + " finishIndex  = " + finishIndex);
            mergeSortArray(array, mediana + 1, finishIndex);

            merge(array, startIndex, mediana, finishIndex);
        }
    }

    private static void merge(int[] array, int startIndex, int mediana, int finishIndex)
    {
        int leftSubArrayLength =  mediana - startIndex + 1;
        int rightSubArrayLength= finishIndex - mediana;

        int [] leftSubArray = new int[leftSubArrayLength];
        int [] rightSubArray = new int[rightSubArrayLength];

        for (int i = 0; i < leftSubArrayLength; i++)
        {
            leftSubArray[i] = array[i + startIndex];
        }

        for (int j = 0; j < rightSubArrayLength ; j++)
        {
            rightSubArray[j] = array[mediana + 1 + j];
        }

        int k = startIndex;
        int i = 0;
        int j = 0;

        while(i < leftSubArrayLength && j < rightSubArrayLength)
        {
            if (leftSubArray[i] < rightSubArray[j])
            {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }

            k++;
        }

         while(i < leftSubArrayLength)
         {
             array[k] = leftSubArray[i];
             i++;
             k++;
         }

         while(j < rightSubArrayLength)
         {
             array[k] = rightSubArray[j];
             j++;
             k++;
         }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
