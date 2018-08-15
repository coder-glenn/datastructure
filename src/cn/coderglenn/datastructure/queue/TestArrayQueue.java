package cn.coderglenn.datastructure.queue;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 14:06
 */
public class TestArrayQueue {

    public static void main(String[] args) throws IllegalAccessException {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i ++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }

}
