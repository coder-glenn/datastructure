package cn.coderglenn.datastructure.linked_list;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 13:02
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.addLast(888);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(999));
        System.out.println(linkedList.contains(666));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println("size: " + linkedList.getSize());
        System.out.println(linkedList.isEmpty());
        linkedList.set(1,000);
        System.out.println(linkedList);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);

        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);
    }
}
