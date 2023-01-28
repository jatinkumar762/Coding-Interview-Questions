
```java
/*package whatever //do not write package name here */

import java.io.*;

class MinHeap
{
    private int[] data;
    private int size;
    MinHeap(int size){
        this.size = size;
        data = new int[size];
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
}


class GFG {
	public static void main (String[] args) {
		MinHeap minHeap = new MinHeap(10);
		minHeap.print();
		minHeap.buildHeap();
		System.out.println();
		minHeap.print();
	}
}
```