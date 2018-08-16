package cn.coderglenn.datastructure.recursion;

import cn.coderglenn.datastructure.linked_list.application.ListNode;

import java.util.LinkedList;

/**
 * @author Glenn.Zheng
 * @date 2018/8/16 10:09
 */
public class RemoveElements3 {

    /**
     * Remove elements from linkedlist can be breakdown to:
     * head + nextLinkedList, we just need to remove elements from nextLinkedList,
     * and then we compare head.val with val, if its equal, we return nextLinkedList,
     * if its not equal, we make head.next = nextLinkedList, then return head.
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }


        ListNode result = removeElements(head.next, val);

        if (head.val == val) {
            return result;
        } else {
            head.next = result;
            return head;
        }

//        if (head == null) {
//            return null;
//        }
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 6, 4, 5, 6};
        ListNode head = new ListNode(numbers);
        System.out.println(head);

        ListNode result = (new RemoveElements3()).removeElements(head, 6);
        System.out.println(result);
    }

}
