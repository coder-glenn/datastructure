package cn.younggus.datastructure.array;

/**
 * @author Glenn.Zheng
 * @date 2018/8/9 22:26
 */
public class CustomerArray<E> {

    private E[] data;

    private int size;

    public CustomerArray() {
        this(10);
    }

    public CustomerArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // get the data size
    public int getSize() {
        return size;
    }

    // get array length
    public int getCapacity() {
        return data.length;
    }

    // is Array empty
    public boolean isEmpty() {
        return size == 0;
    }

    // add element into last
    public void addLast(E element) throws IllegalAccessException {
        add(size, element);
    }

    // add element into first
    public void addFirst(E element) throws IllegalAccessException {
        add(0, element);
    }

    // add element into index
    public void add(int index, E element) throws IllegalAccessException {
        if (size == this.data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalAccessException("add last failed. Require index >= 0 or index < size.");
        }

        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size ++;
    }

    // get element by index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, illegal index.");
        }
        return data[index];
    }

    // update data at specific index
    public void update(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, illegal index.");
        }
        data[index] = element;
    }

    // find one element in array
    public boolean contains(E element) {
        for (int i = 0; i <= size - 1; i ++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // find index for element, if it does not exist, return -1
    public int getIndexByElement(E element) {
        for (int i = 0; i <= size - 1; i ++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    // remove element from array, return the element which removed
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, illegal index.");
        }
        E ret = data[index];
        for (int i = index + 1; i <= size - 1; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null; // loitering objects != memory leak
        if ((size == data.length / 4) && (data.length / 2 != 0)) {
            resize(data.length / 2);
        }
        return ret;
    }

    // remove first element in array
    public E removeFirst() {
        return remove(0);
    }

    // remove last element in array
    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E element) {
        int index = getIndexByElement(element);
        if (-1 != index) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i ++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i <= this.size - 1; i ++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
}
