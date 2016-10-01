public ListNode reverseList(ListNode head) {
    if(head==null) return head;
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode pre = head;
    ListNode cur = head.next;
    head.next = null;
    while(cur!=null){
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;       
    }    
    return pre;    
}
