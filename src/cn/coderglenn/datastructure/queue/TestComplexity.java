package cn.coderglenn.datastructure.queue;

import cn.coderglenn.datastructure.queue.ArrayQueue;
import cn.coderglenn.datastructure.queue.LoopQueue;
import cn.coderglenn.datastructure.queue.Queue;

import java.util.Random;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 15:41
 */
public class TestComplexity {

    public static void main(String[] args) throws IllegalAccessException {
        int operationCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, operationCount);
        System.out.println("ArrayQueue: " + time1 + " seconds");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, operationCount);
        System.out.println("LoopQueue: " + time2 + " seconds");

        //ArrayQueue: 8.376114815 seconds
        //LoopQueue: 0.054720953 seconds

        // for dequeue, ArrayQueue O(n^2), LoopQueue O(n), because ArrayQueue need to move element.
    }

    // test enqueue & dequeue
    public static double testQueue(Queue<Integer> queue, int operationCount) throws IllegalAccessException {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i ++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i ++) {
            queue.deQueue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
