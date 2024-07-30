https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1

```java
public static Node reverseDLL(Node  head)
{
    //Your code here
    Node swap = null;
    while(head!=null){
        swap = head;
        head = head.next;
    
        Node tmp = swap.prev;
        swap.prev = swap.next;
        swap.next = tmp;
    }
    
    return swap;
}
```