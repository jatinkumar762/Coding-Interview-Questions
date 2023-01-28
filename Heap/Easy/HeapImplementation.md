
```java
/*package whatever //do not write package name here */

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