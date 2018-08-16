package cn.coderglenn.datastructure.linked_list.application;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 17:08
 */
public class RemoveElementes2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 4, 5, 6};
        ListNode head = new ListNode(array);
        System.out.println(head);
        ListNode result = (new RemoveElementes2()).removeElements(head, 6);
        System.out.println(result);

        //1->2->3->6->4->5->6->NULL
        //1->2->3->4->5->NULL
    }
}
