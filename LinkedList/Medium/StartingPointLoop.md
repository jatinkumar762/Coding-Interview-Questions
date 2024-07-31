
https://leetcode.com/problems/linked-list-cycle-ii/description/

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {

        // m + k = multiple of n
        // m - start point to loop start point
        // k - loop start point to meeting point of slow and fast
        // n - length of loop

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // suppose they are meeting at k distance (from loop starting point)
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
```