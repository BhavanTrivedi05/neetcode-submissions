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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1){
            List<ListNode> merged = new ArrayList<>();
            for (int i = 0;i<lists.length;i += 2){
                ListNode l2 = (i+1 < lists.length) ? lists[i+1]: null;
                merged.add(mergeTwo(lists[i],l2));
            }
            lists = merged.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeTwo(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0),tail = dummy;
        while (a != null && b!= null){
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a:b;
        return dummy.next;
    }
}
