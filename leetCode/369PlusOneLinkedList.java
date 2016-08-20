public class PlusOneLinkedList{
  public ListNode plusOne(ListNode head){
    if(head==null) return null;
    head = reverseLinkedList(head);
    ListNode p = head;
    int plus = 1;
    while(p!=null){
       int sum = p.val + plus;
       p.val = sum%10;
       if(sum>9){
          if(p.next==null){
              p.next = new ListNode(1);
              break;
          }
       }else{
         break;
       }
       p=p.next;
    }
    return reverseLinkedList(head);
  }

 private ListNode reverseLinkedList(ListNode head){
    if(head==null) return null;
    ListNode p = head.next;
    head.next = null;
    while(p!=null){
       ListNode tmp = p.next;
       p.next = head;
       head = p;
       p = tmp;
   }
   return head;
  }
 }
