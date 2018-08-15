package cn.coderglenn.datastructure.stack;

import java.util.Random;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 15:00
 */
public class TestComplexity {

    public static void main(String[] args) throws IllegalAccessException {
        int operationCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("ArrayStack: " + testStack(arrayStack, operationCount) + " seconds");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("LinkedListStack: " + testStack(linkedListStack, operationCount) + " seconds");

        // ArrayStack need to do resize. O(n)
        // LinkedListStack need to new many objects. O(n)

        //operationCount = 100000
        //ArrayStack: 0.044469463 seconds
        //LinkedListStack: 0.038825703 seconds

        // operationCount = 10000000
        // ArrayStack: 4.652258337 seconds
        // LinkedListStack: 6.64085856 seconds
    }

    private static double testStack(Stack<Integer> stack, int operationCount) throws IllegalAccessException {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
