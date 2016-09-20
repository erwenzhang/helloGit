/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while(head!=null&&head.next!=null){
            ListNode next = head.next;
            p.next = next;
            head.next = next.next;
            next.next = head;
            p = head;
            head = head.next;
        }
       return dummyHead.next;
    }
}
