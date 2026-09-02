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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return head;
        }
        ListNode tmp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(tmp!=null){
            list.add(tmp.val);
            tmp = tmp.next;
        }

        int l= left-1;
        int r= right-1;
        
        while(l<r){
            int f = list.get(l);
            int s = list.get(r);
            list.set(l,s);
            list.set(r,f);
            
            l++;
            r--;
        }
        tmp =head;
        for(int i=0;i<list.size();i++){
            tmp.val = list.get(i);
            tmp = tmp.next;
        }
        return head;
    }
}