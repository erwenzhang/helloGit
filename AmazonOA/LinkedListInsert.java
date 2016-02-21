
public class LinkedListInsert {
	public ListNode Solution(ListNode head, int val) {
		if (head == null) {
			ListNode rval = new ListNode(val);
			rval.next = rval;
			return rval;
		}
		
		ListNode cur = head;
		
		do {
			if (val <= cur.next.val && val >= cur.val)	break;
			if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val))	break;
			// reach the end of the linked list, either val is very largest, or smallest,
			cur = cur.next;
		} while (cur != head);
		
		ListNode newNode = new ListNode(val);
		newNode.next = cur.next;
		cur.next = newNode;
		return newNode;
	}
}
