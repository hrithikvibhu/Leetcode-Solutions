/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k<=1)
            return head;
        
        ListNode dummy = new ListNode(-1,head);
        ListNode curr = dummy;
        int i=0;
        while(head!=null){
            i++;
            if(i%k==0){
                curr = helper(curr,head.next);
                head = curr.next;
            }
            else
                head = head.next;
        }
        return dummy.next;
    }
    
    public ListNode helper(ListNode l , ListNode r){
        ListNode curr = l.next;
        ListNode head = curr;
        ListNode prev = l;
        while(curr!=r){
            ListNode post = curr.next;
            curr.next = prev;
            prev = curr;
            curr = post;
        }
        l.next = prev;
        head.next = r;
        return head;
    }
}