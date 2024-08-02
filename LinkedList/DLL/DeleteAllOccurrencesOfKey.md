https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1

```java
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        
        Node curr = head;
        Node tmp;
        while(curr!=null){
            
            if(curr.data==x) {
                tmp = curr.next; 
   
                if(curr.prev!=null){
                    curr.prev.next = curr.next;
                }   
                if(curr.next!=null){
                    curr.next.prev = curr.prev;
                }
                
                if(curr == head){
                    head = tmp;
                }
                
                curr = tmp;
            } else {
                curr = curr.next;
            }
        }
        
        return head;
    }
}
```