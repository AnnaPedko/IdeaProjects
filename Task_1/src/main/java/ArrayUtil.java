import java.util.Arrays;

public class ArrayUtil
{
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

        System.out.println(Arrays.toString(array));
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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

    public static void quickSort(int[] array)
    {
      quickSortArray(array, 0, array.length);
      System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array)
    {
       mergeSortArray(array, 0, array.length);
       System.out.println(Arrays.toString(array));
    }

    private static void mergeSortArray(int[]array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex)
        {
            int mediana = startIndex + (finishIndex - startIndex) / 2;
            mergeSortArray(array, 0, mediana - 1);
            mergeSortArray(array, mediana , finishIndex);

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
            leftSubArray[i] = array[i];
        }

        for (int j = 0; j < rightSubArrayLength; j++)
        {
            rightSubArray[j] = array[mediana + 1 + j];
        }
    }

    private static void quickSortArray( int[] array, int startIndex, int finishIndex)
    {
        if (startIndex < finishIndex )
        {
            int partitionIndex = getPartitionIndex(array, 0, finishIndex);
            quickSortArray(array, 0, partitionIndex - 1);
            quickSortArray(array, partitionIndex + 1, finishIndex);
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
}
