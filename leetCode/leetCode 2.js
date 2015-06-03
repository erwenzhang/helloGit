


function ListNode(val) {
     this.val = val;
      this.next = null;
  }

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
	var head= new ListNode(0);
	var l3 = head;
	var carry = 0;

	if(l1 == null)
		l3 = l2;
	if(l2 == null)
		l3 = l1;

	while(l1 !== null || l2 !==null)
	{
		var add1 = 0;
		var add2 = 0;
		var tmp;

		if( l1 !== null){
			add1 = l1.val;
			l1 = l1.next;
		}

		if(l2 !== null){
			add2 = l2.val;
			l2 = l2.next;
		}

		tmp = add1 + add2 + carry;
		l3 .next  = new ListNode(Math.floor(tmp%10));
		l3 = l3.next;


		if((add1+add2)>9)
			carry = 1;
		else
			carry = 0;

	}

	return head.next;

    
};