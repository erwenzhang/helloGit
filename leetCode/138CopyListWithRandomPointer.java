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
        RandomListNode p = dummyHead;
        RandomListNode q = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while(q!=null){
            p.next = new RandomListNode(q.label);
            map.put(q, p.next);
            p = p.next;
            q = q.next;
        }
        q = head;
        p = dummyHead;
        while(q!=null){
            p.next.random = map.get(q.random);
            q = q.next;
            p = p.next;
        }
        return dummyHead.next;
    }
}
