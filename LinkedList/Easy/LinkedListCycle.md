https://leetcode.com/problems/linked-list-cycle/

#### Approach 1: Hash Table

#### Approach 2: Floyd's Cycle Finding Algorithm

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow=head, fast=head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        
        return false;
    }
}
```