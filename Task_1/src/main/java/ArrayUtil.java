import java.util.Arrays;

public class ArrayUtil
{
    public static void bubbleSort(int[] array)
    {
        for ( int i = array.length -1; i > 0 ; --i )
        {
            for ( int j = 0; j < i; j++ )
            {
                if ( array[j] > array[j+1] )
                {
                    swapArray(array, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swapArray(int[] arr, int i, int j)
    {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
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
    }}
