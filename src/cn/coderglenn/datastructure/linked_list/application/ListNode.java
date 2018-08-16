package cn.coderglenn.datastructure.linked_list.application;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 16:55
 */
public class ListNode {

   public int val;
   public ListNode next;
   public ListNode(int x) {
       this.val = x;
   }

   public ListNode(int[] arr) {
       if (arr == null || arr.length == 0) {
           throw new IllegalArgumentException("array cannot be empty");
       }

       this.val = arr[0];
       ListNode current = this;
       for (int i = 1; i < arr.length; i ++) {
           current.next = new ListNode(arr[i]);
           current = current.next;
       }
   }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            builder.append(current.val + "->");
            current = current.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
