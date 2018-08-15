package cn.coderglenn.datastructure.queue;

import cn.coderglenn.datastructure.array.CustomerArray;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 13:54
 */
public class ArrayQueue<E> implements Queue<E> {

    CustomerArray<E> customerArray;

    public ArrayQueue(int capacity) {
        customerArray = new CustomerArray<>(capacity);
    }

    public ArrayQueue() {
        customerArray = new CustomerArray<>();
    }

    @Override
    public void enQueue(E e) throws IllegalAccessException {
        customerArray.addLast(e);
    }

    @Override
    public E deQueue() {
        return customerArray.removeFirst();
    }

    @Override
    public E getFront() {
        return customerArray.getFirst();
    }

    @Override
    public int getSize() {
        return customerArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return customerArray.isEmpty();
    }

    public int getCapacity() {
        return customerArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: ");
        builder.append("front [");
        for (int i = 0; i <= customerArray.getSize() - 1; i ++) {
            builder.append(customerArray.get(i));
            if (i != customerArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }
}
