
[https://leetcode.com/problems/linked-list-cycle-ii/description/](https://leetcode.com/problems/linked-list-cycle-ii/description/)

```java
public class Solution {
    private ListNode findIntersection(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            //for every 1 step of slow
            // we are moving 2 step of fast
            // this makes 2 times in equation, bcz begining is same
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return slow; 
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode node = findIntersection(head);
        if(node==null)
            return null;     
        ListNode start = head;  
        while(start!=node){
         start = start.next;
         node = node.next;
        }   
        return start;
    }
}
```