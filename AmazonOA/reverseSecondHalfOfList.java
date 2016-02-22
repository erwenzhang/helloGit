public static ListNode fun(ListNode head){
		if(head==null||head.next==null||head.next.next==null) return head;
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode pre = slow.next;
		ListNode cur =pre.next;
		while(cur!=null){
			pre.next = cur.next;
			cur.next = slow.next;
			slow.next = cur;
			cur = pre.next;
		}
		return head;
	}
