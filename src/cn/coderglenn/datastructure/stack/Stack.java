package cn.coderglenn.datastructure.stack;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 11:11
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e) throws IllegalAccessException;

    E pop();

    E peek();

}
