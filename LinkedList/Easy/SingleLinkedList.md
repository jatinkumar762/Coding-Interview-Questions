[design-linked-list](https://leetcode.com/problems/design-linked-list/description/)

```java
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        next=null;
    }
}
class MyLinkedList {
    
    Node head;
    int size;
    public MyLinkedList() {
        head = null;
        size=0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node tmp = head;
        while(index-->0){
            tmp = tmp.next;
        }
        return tmp.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        
        if (index > size) return;
        if (index < 0) index = 0;
        ++size;
        
        Node toAdd = new Node(val);
        if(index==0){
            toAdd.next = head;
            head = toAdd;
            return;
        }
             
        Node target = head;
        while(--index>0){
            target = target.next;
        }
        toAdd.next = target.next;
        target.next = toAdd;
        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        
        if(index==0){
            head = head.next;
            return;
        }  
        Node tmp = head;
        while(--index>0){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
 ```