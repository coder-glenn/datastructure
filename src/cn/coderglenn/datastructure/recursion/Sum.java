package cn.coderglenn.datastructure.recursion;

/**
 * @author Glenn.Zheng
 * @date 2018/8/16 9:57
 */
public class Sum {

    // sum for array
    public static int sum(int[] array) {
        return sum(array, 0);
    }

    // sum for arr[leftPosition...n)
    public static int sum(int[] arr, int leftPosition) {
        if (leftPosition == arr.length) {
            return 0;
        }
        return arr[leftPosition] + sum(arr, leftPosition + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println(sum(numbers));
    }

}
