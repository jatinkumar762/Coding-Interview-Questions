https://leetcode.com/problems/rotate-list/

* Method-1

To rotate the linked list, we need to change the next pointer of kth node to NULL, the next pointer of the last node should point to previous head node, and finally, change the head to (k+1)th node. So we need to get hold of three nodes: kth node, (k+1)th node, and last node. 

* Method-2 : rotate a linked list

To rotate a linked list by k, we can first make the linked list circular and then moving k-1 steps forward from head node, making (k-1)th node’s next to null and make kth node as head.

---


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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode tmp = head;
        int len = 1;
        while (tmp.next != null) {
            len += 1;
            tmp = tmp.next;
        }

        // will make circular
        tmp.next = head;

        // at this node, will set next pointer to null
        int tailIndex = len - (k % len) - 1;

        while (tailIndex > 0) {
            head = head.next;
            tailIndex -= 1;
        }

        // before making tail node next pointer null
        // will get newHead node
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
```
[Editorial](https://www.geeksforgeeks.org/rotate-a-linked-list/)