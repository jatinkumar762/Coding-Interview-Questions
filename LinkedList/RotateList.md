[Problem](https://leetcode.com/problems/rotate-list/)

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