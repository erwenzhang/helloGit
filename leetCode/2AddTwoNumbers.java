public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int carry = 0;
        while(l1!=null||l2!=null){
            int add1 = (l1!=null)?l1.val:0;
            int add2 = (l2!=null)?l2.val:0;
            int sum = add1 + add2 + carry;
            p.next = new ListNode(sum%10);
            p = p.next;
            carry = sum/10;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;    
        }   
        if(carry>0) p.next = new ListNode(carry);
        return dummyHead.next;     
    }
}
