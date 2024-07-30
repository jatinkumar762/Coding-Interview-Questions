https://leetcode.com/problems/reverse-linked-list/description/

#### Iterative

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tmp, prev = null;

        while (head != null) {
            tmp = head.next;

            head.next = prev;

            prev = head;
            head = tmp;
        }

        return prev;
    }
}
```

#### [Recursive]

```java
class Solution {

    public ListNode reverse(ListNode head, ListNode prev){

        if(head==null){
            return prev;
        }

        ListNode tmp = head.next;
        head.next = prev;

        return reverse(tmp, head);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}
```