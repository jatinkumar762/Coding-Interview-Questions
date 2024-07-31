https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


#### Approach-1 Slow

```java
class Solution {

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = length(head);

        System.out.println(len);

        n = len - n + 1;

        if (n == 1) {
            return head.next;
        }

        System.out.println(n);

        ListNode prev = null, curr = head;
        n -= 1;
        while (n > 0) {
            prev = curr;
            curr = curr.next;
            n -= 1;
        }

        prev.next = curr.next;

        // not required
        curr.next = null;

        return head;
    }
}
```

#### Approach-2 Single Iteration -> fast

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev = null, tmp = head, curr=head;
    
        while (n > 0) {
            tmp = tmp.next;
            n -= 1;
        }

        if(tmp==null){
            return head.next;
        }

        while(tmp!=null){
            tmp = tmp.next;

            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        //not required - optional
        //curr.next = null;

        return head;
    }
}
```