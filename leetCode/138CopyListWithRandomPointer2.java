/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode dummyHead = new RandomListNode(-1);
        RandomListNode q = dummyHead;
        RandomListNode p = head;
        while(p!=null){
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }  
        p = head;
        while(p!=null){
            p.next.random = (p.random!=null)?p.random.next:null;
            p = p.next.next;
        }
        p = head;
        while(p!=null){
            q.next = p.next;
            p.next = p.next.next;
            q = q.next;
            p = p.next;
        }    
        return dummyHead.next;
    }
}
