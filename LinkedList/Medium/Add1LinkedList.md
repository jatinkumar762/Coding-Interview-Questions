https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

```java
class Solution {
    
    private Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // code here.
        
        head = reverse(head);
        
        Node newHead=null, tail=null;
        
        int carry=1, sum;
        
        while(head!=null){
            
            sum = carry + head.data;
            
            carry = sum/10;
            sum = sum%10;
            
            if(newHead==null){
                newHead = tail = new Node(sum);
            } else {
                tail.next = new Node(sum);
                tail = tail.next;
            }
            
            head=head.next;
        }
        
        if(carry!=0){
            tail.next = new Node(carry);
            tail = tail.next;
        }
        
        return reverse(newHead);
    }
}
```