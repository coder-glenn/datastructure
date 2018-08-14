package cn.younggus.datastructure.stack;

/**
 * @author Glenn.Zheng
 * @date 2018/8/14 11:27
 */
public class TestArrayStack {

    public static void main(String[] args) throws IllegalAccessException {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i ++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
        System.out.println("Top Element: " + arrayStack.peek());
    }

}
