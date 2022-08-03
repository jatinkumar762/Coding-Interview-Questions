[Problem](https://leetcode.com/problems/rotate-list/)

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
        
        if(k==0)
            return head;
        
        int len=0;
        ListNode tmp = head;
        while(tmp!=null){
            len+=1;
            tmp = tmp.next;
        }
        
        if(len==0)
            return head;
        
        k = k%len;
        
        if(k==0)
            return head;
        
        tmp = head;
        for(int i=1;i<len-k;i++){
            tmp=tmp.next;
        }
        
        ListNode newHead = tmp.next;
        tmp.next = null;
        
        tmp = newHead;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next = head;
        
        return newHead;
    }
}
```
[Editorial](https://www.geeksforgeeks.org/rotate-a-linked-list/)