package cn.coderglenn.datastructure.queue;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 13:52
 */
public interface Queue<E> {

    void enQueue(E e) throws IllegalAccessException;

    E deQueue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
