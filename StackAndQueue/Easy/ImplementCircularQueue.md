
```java
class MyCircularQueue {

    int[] queue;
    int front,rear;
    int K;
    public MyCircularQueue(int k) {
        this.queue = new int[k]; 
        this.front=-1;
        this.rear=-1;
        this.K=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(front==-1)
            front=0;
        rear = ((rear+1)%K);
        queue[rear] = value;   
        return true;
    }
    
    public boolean deQueue() {
        
        if(isEmpty())
            return false;
        if(front==rear){
            front=rear=-1;
            return true;
        }
        front=((front+1)%K);
        return true;
    }
    
    public int Front() {
        if(front>=0) return queue[front];
        return -1;
    }
    
    public int Rear() {
        if(rear>=0) return queue[rear];
        return -1;
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%K==front)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 ```