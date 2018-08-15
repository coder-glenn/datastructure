package cn.younggus.datastructure.queue;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 15:19
 */
public class TestLoopQueue {
    public static void main(String[] args) throws IllegalAccessException {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 11; i ++) {
            arrayQueue.enQueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.deQueue();
                System.out.println(arrayQueue);
            }
        }
    }
}
