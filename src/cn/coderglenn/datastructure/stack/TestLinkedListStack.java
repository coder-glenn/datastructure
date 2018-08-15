package cn.coderglenn.datastructure.stack;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 14:56
 */
public class TestLinkedListStack {

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        System.out.println(linkedListStack.peek());
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
