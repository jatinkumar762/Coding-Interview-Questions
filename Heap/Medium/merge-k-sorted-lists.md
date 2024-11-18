https://leetcode.com/problems/merge-k-sorted-lists/description/

### Using PriorityQueue - 5ms Beats 36%

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    class Node {
        int val;
        ListNode nodeIndex;

        public Node(int v, ListNode n) {
            this.val = v;
            this.nodeIndex = n;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;

        if (len == 0) {
            return null;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                pq.add(new Node(lists[i].val, lists[i]));
            }
        }

        ListNode result = null, tail = null;

        while (!pq.isEmpty()) {

            Node min = pq.remove();

            if (result == null) {
                result = tail = new ListNode(min.val);
            } else {
                tail.next = new ListNode(min.val);
                tail = tail.next;
            }

            ListNode nextCandidate = min.nodeIndex.next;
            if (nextCandidate != null) {
                pq.add(new Node(nextCandidate.val, nextCandidate));
            }
        }

        return result;
    }
}
```