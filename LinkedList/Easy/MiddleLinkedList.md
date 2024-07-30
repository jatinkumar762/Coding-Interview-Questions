https://leetcode.com/problems/middle-of-the-linked-list/

```java
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
```

#### LeetCode most voted solution

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```