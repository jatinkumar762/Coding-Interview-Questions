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

### Approach-2 Using Queue and Divide Conquer - 3ms Beats 79%

```java
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;

        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return lists[0];
        }

        //follows FIFO
        Queue<ListNode> q = new LinkedList<>();

        for(ListNode list: lists)
            q.offer(list);

        while(q.size() > 1) {
            //due to FIFO
            //first all small size list merged in pair
            ListNode list1 = q.poll();
            ListNode list2 = q.poll();
            q.offer(mergeTwoList(list1, list2));
        }
        return q.poll();
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = null, tail = null;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                if (head == null) {
                    head = tail = new ListNode(list1.val);
                } else {
                    tail.next = new ListNode(list1.val);
                    tail = tail.next;
                }

                list1 = list1.next;
            } else {

                if (head == null) {
                    head = tail = new ListNode(list2.val);
                } else {
                    tail.next = new ListNode(list2.val);
                    tail = tail.next;
                }

                list2 = list2.next;
            }
        }

        while (list1 != null) {
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            
            list1 = list1.next;
        }

        while (list2 != null) {
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            
            list2 = list2.next;
        }

        return head;
    }
}
```

### Approach-3 Brute Force - 107ms Beats 8%

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

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;

        if (len == 0) {
            return null;
        }

        if (len == 1) {
            return lists[0];
        }

        ListNode result = mergeTwoList(lists[0], lists[1]);

        for (int i = 2; i < len; i++) {
            result = mergeTwoList(result, lists[i]);
        }

        return result;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = null, tail = null;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                if (head == null) {
                    head = tail = new ListNode(list1.val);
                } else {
                    tail.next = new ListNode(list1.val);
                    tail = tail.next;
                }

                list1 = list1.next;
            } else {

                if (head == null) {
                    head = tail = new ListNode(list2.val);
                } else {
                    tail.next = new ListNode(list2.val);
                    tail = tail.next;
                }

                list2 = list2.next;
            }
        }

        while (list1 != null) {
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            
            list1 = list1.next;
        }

        while (list2 != null) {
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            
            list2 = list2.next;
        }

        return head;
    }
}
```