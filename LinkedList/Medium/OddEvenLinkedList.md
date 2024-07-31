https://leetcode.com/problems/odd-even-linked-list/description/


```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null)
            return head;

        ListNode odd=head, even=head.next, evenHead = even;

        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
```

TimeComplexity - O(n)
SpaceComplexity - O(1)

#### Approach-2

create odd and even LinkedList -> after this merge them

ListNode evenStart = null;
ListNode evenEnd = null;
ListNode oddStart = null;
ListNode oddEnd = null;

--> traverse the LinkedList and create even and odd different list

oddEnd.next = evenStart;
evenEnd.next = null;
head=oddStart;

TimeComplexity - O(n)
SpaceComplexity - O(1)