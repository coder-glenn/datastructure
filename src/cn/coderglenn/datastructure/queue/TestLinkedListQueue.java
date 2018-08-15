package cn.coderglenn.datastructure.queue;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 16:01
 */
public class TestLinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 11; i++) {
            linkedListQueue.enQueue(i);
            System.out.println(linkedListQueue);

            if (i % 4 == 2) {
                linkedListQueue.deQueue();
                System.out.println(linkedListQueue);
            }
        }

        System.out.println(linkedListQueue.getFront());

        /**
         *
         *
             Queue: front 0->NULL tail
             Queue: front 0->1->NULL tail
             Queue: front 0->1->2->NULL tail
             Queue: front 1->2->NULL tail
             Queue: front 1->2->3->NULL tail
             Queue: front 1->2->3->4->NULL tail
             Queue: front 1->2->3->4->5->NULL tail
             Queue: front 1->2->3->4->5->6->NULL tail
             Queue: front 2->3->4->5->6->NULL tail
             Queue: front 2->3->4->5->6->7->NULL tail
             Queue: front 2->3->4->5->6->7->8->NULL tail
             Queue: front 2->3->4->5->6->7->8->9->NULL tail
             Queue: front 2->3->4->5->6->7->8->9->10->NULL tail
             Queue: front 3->4->5->6->7->8->9->10->NULL tail
             3
         *
         */
    }

}
