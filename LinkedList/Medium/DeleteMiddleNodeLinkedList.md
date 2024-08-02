https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/


#### Using 3-pointers

```java
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
    public ListNode deleteMiddle(ListNode head) {
        
        ListNode slow = head, prev=null, fast = head;

        if(fast.next==null){
            return null;
        }

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
```

#### Using 2-pointers

```java
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head==null) return head;

        if(head.next==null){
            return null;
        }
        
        if(head.next.next==null){
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }
}
```