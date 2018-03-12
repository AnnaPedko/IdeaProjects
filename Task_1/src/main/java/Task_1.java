public class Task_1
{
    public static void main(String[] args)
    {
        int intArray[] = {1000, -4, 12, 2, 3 , 10, 50, 7};

        ArrayUtil.bubbleSort(intArray);
        System.out.println(ArrayUtil.findMax(intArray));
        System.out.println(ArrayUtil.findMin(intArray));
        
    }
}
