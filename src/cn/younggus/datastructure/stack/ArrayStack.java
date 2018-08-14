package cn.younggus.datastructure.stack;

import cn.younggus.datastructure.array.CustomerArray;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 11:13
 */
public class ArrayStack<E> implements Stack<E> {

    CustomerArray<E> customerArray;

    public ArrayStack(int capacity) {
        customerArray = new CustomerArray<>(capacity);
    }

    public ArrayStack() {
        customerArray = new CustomerArray<>();
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
    public void push(E e) throws IllegalAccessException {
        customerArray.addLast(e);
    }

    @Override
    public E pop() {
        return customerArray.removeLast();
    }

    @Override
    public E peek() {
        return customerArray.getLast();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack: ");
        builder.append("[");
        for (int i = 0; i <= customerArray.getSize() - 1; i ++) {
            builder.append(customerArray.get(i));
            if (i != customerArray.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
