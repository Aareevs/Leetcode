/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ListNode temp1=list1;
        // ListNode temp2=list2;

        // ListNode poin=new ListNode(0);
        // ListNode curr=poin;

        // while(temp1!=null || temp2!=null)
        // {
        //     int val1=Integer.MAX_VALUE;
        //     int val2=Integer.MAX_VALUE;
        //     if (temp1!=null){
        //         val1=temp1.val;
        //     }
        //     if (temp2!=null){
        //         val2=temp2.val;
        //     }

        //     if (val1<val2)
        //     {                
        //         ListNode newNode=new ListNode(val1);
        //         poin.next=newNode;
        //         poin=poin.next;
        //         temp1=temp1.next;
        //     }
        //     else
        //     {
        //         ListNode newNode=new ListNode(val2);
        //         poin.next=newNode;
        //         poin=poin.next;
        //         temp2=temp2.next;
        //     }
        // }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}