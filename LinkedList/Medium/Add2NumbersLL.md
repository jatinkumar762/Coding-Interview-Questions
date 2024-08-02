https://leetcode.com/problems/add-two-numbers/description/

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {

            sum = carry;

            if (l1 != null) {
                sum += l1.val;
            }

            if (l2 != null) {
                sum += l2.val;
            }

            carry = sum / 10;
            sum = sum % 10;

            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }

        return head;
    }
}
```


#### UnOptimized Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head=null, tail=null;
        int carry = 0;
        int sum;
        while(l1!=null && l2!=null){

            sum = l1.val + l2.val + carry;

            carry = sum/10;
            sum = sum%10;

            if(head==null){
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        while(l1!=null){
            
            sum = l1.val + carry;
            carry = sum/10;
            sum = sum%10;
            
            if(head==null){
                head = tail = l1;
                break;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1=l1.next;
        }

        while(l2!=null){
            
            sum = l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            
            if(head==null){
                head = tail = l2;
                break;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l2 = l2.next;
        }

        if(carry!=0){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        
        return head;
    }
}
```