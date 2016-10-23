  public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverse(slow.next);

        while(first!=null&&second!=null){
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null;// important!!!!
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
