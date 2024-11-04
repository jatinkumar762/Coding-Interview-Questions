
### Introduction

* A Heap is a special Tree-based Data Structure that has the following properties.
    - It is a complete Complete Binary Tree.
    - It either follows max heap or min heap property

**Max-Heap:**  

* The value of the root node must be the greatest among all its descendant nodes and the same thing must be done for its left and right sub-tree also.

**Min-Heap:**

* The value of the root node must be the smallest among all its descendant nodes and the same thing must be done for its left and right sub-tree also.

**Properties of Heap:**

1. The minimum or maximum element is always at the root of the heap, allowing constant-time access.
2. The relationship between a parent node at index ‘i’ and its children is given by the formulas: left child at index 2i+1 and right child at index 2i+2 for 0-based indexing of node numbers.
3. As the tree is complete binary, all levels are filled except possibly the last level. And the last level is filled from left to right.
4. When we insert an item, we insert it at the last available slot and then rearrange the nodes so that the heap property is maintained.
5. When we remove an item, we swap root with the last node to make sure either the max or min item is removed. Then we rearrange the remaining nodes to ensure heap property (max or min)


### Implementation

```java
import java.io.*;

class MinHeap
{
    private int[] data;
    private int size;
    private int maxSize;
    MinHeap(int size){
        this.size = size;
        this.maxSize = size + 5;
        data = new int[maxSize];
        for(int i=0;i<size;i++){
            data[i] = (int) (Math.random()*10);
        }
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(data[i] + " ");
        }
    }
    public void heapify(int index){
        int l = 2*index+1;
        int r = 2*index+2;
        int min= index;
        if(l<size && data[min]>data[l]){
            min = l;
        }
        if(r<size && data[min]>data[r]){
            min = r;
        }
        if(min!=index){
            int tmp = data[index];
            data[index] = data[min];
            data[min] = tmp;
            heapify(min);
        }
    }
    
    public void buildHeap(){
        for(int i=size/2;i>=0;i--){
            heapify(i);
        }
    }
    
    public void add(int ele){
        if(size+1>maxSize){
            throw new RuntimeException("Not allowed");
        }
        size = size+1;
        data[size-1] = ele;
        int index = size-1;
        while(data[index]<data[(index-1)/2] && index>0){
            int tmp = data[(index-1)/2];
            data[(index-1)/2] = data[index];
            data[index] = tmp;
            index = (index-1)/2;
        }
    }

    public int remove(){
      if(size==0){
        throw new RuntimeException("Not allowed");
      }
      int tmp = data[size-1];
      data[size-1] = data[0];
      data[0] = tmp;
      size-=1;
      heapify(0);
      return data[size];
    }
}


class GFG {
  public static void main (String[] args) {
      MinHeap minHeap = new MinHeap(10);
      minHeap.print();
      minHeap.buildHeap();
      System.out.println();
      minHeap.print();
      System.out.println();
      minHeap.add(-10);
      minHeap.print();
      System.out.println();
      System.out.println("Removed Elelement: "+minHeap.remove());
      minHeap.print();
  }
}
```

[https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/](https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/)