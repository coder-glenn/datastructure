package cn.coderglenn.datastructure.array;

/**
 * @author Glenn.Zheng
 * @date 2018/8/13 16:34
 */
public class TestCustomerArray   {
        public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
            CustomerArray<Integer> array = new CustomerArray();
            for (int i = 0; i < 10; i ++) {
                    array.addLast(i);
            }
            System.out.println(array);

            array.add(1, 100);
            System.out.println(array);

            array.addFirst(-1);
            System.out.println(array);  // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

            array.remove(2);
            System.out.println(array);  //[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

            array.removeElement(4);
            System.out.println(array);  // [-1, 0, 1, 2, 3, 5, 6, 7, 8, 9]

        }
}
