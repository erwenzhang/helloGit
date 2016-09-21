public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode head = new ListNode(-1);
    ListNode p = head;
    while(l1!=null&&l2!=null){
        if(l1.val<l2.val){
            p.next = l1;
            l1 = l1.next;
        }else{
            p.next = l2;
            l2 = l2.next;
        }
        p = p.next;
    }
    if(l1!=null){
        p.next = l1;
    }
    if(l2 != null){
        p.next = l2;
    }
   return head.next;
}

public ListNode mergeKLists(ListNode[] lists){
    if(lists.length== 0||lists == null) return null;
    return mergeKLists(lists, 0, lists.length-1);
}
        
public ListNode mergeKLists(ListNode[] lists, int lo, int hi){
    if(lo==hi) return lists[lo];
    int mid = lo+(hi-lo)/2;
    return mergeTwoLists(mergeKLists(lists,lo,mid),mergeKLists(lists,mid+1,hi));
}

//Another MergeKLists, divide conquer, 
public ListNode mergeKLists(ListNode[] lists){
    if(lists.length== 0||lists == null) return null;
    int end = lists.length - 1;
    while(end>0){
        int begin = 0;
        while(begin<end){
           lists[begin] = mergeTwoLists(lists[begin],lists[end]);
           end--;
           begin++; 
        }
    }
    return lists[0];
}

