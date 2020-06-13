public class MergeSortedList {

    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode sol=null;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                if(head==null) {
                    head = new ListNode(l1.val);
                    sol=head;
                } else {
                    ListNode next= new ListNode(l1.val);
                    sol.next=next;
                    sol=sol.next;
                }
                l1=l1.next;
            } else {
                if(head==null) {
                    head = new ListNode(l2.val);
                    sol=head;
                } else {
                    ListNode next= new ListNode(l2.val);
                    sol.next=next;
                    sol=sol.next;
                    l2=l2.next;
                }
            }
        }
        if(l1==null && l2!=null) {
            while(l2!=null) {
                sol.next=new ListNode(l2.val);
                sol=sol.next; l2=l2.next;
            }
        }
        if(l2==null && l1!=null) {
            while(l1!=null) {
                sol.next=new ListNode(l1.val);
                sol=sol.next; l1=l1.next;
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
