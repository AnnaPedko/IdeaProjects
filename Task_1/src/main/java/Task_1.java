import java.util.Arrays;

public class Task_1
{
    public static void main(String[] args)
    {
        int intArray[] = {1000, -4, 12, 2, 3 , 10, 50, 7};
        int quickSortArray[] = {1000, -4, 10, 92, 3 , 11, 50, 7};
        //ArrayUtil.mergeSort(intArray);
        ArrayUtil.bubbleSort(intArray);
        ArrayUtil.quickSort(quickSortArray);
        System.out.println(ArrayUtil.findMax(intArray));
        System.out.println(ArrayUtil.findMin(intArray));
    }
}
