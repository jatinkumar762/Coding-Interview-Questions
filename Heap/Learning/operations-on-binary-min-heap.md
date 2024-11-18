https://www.geeksforgeeks.org/problems/operations-on-binary-min-heap/1

A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.

* The root element will be at Arr[0].
* $Arr[(i-1)/2]$	Returns the parent node
* $Arr[(2*i)+1]$	Returns the left child node
* $Arr[(2*i)+2]$	Returns the right child node

**Operations on Heap:**

Below are some standard operations on min heap:

&rarr; getMin(): 

- It returns the root element of Min Heap. 
- The time Complexity of this operation is O(1). 
- In case of a maxheap it would be getMax().

&rarr; extractMin():

- Removes the minimum element from MinHeap.
- The time Complexity of this Operation is O(log N) as this operation needs to maintain the heap property (by calling heapify()) after removing the root.

&rarr; decreaseKey(): 

- Decreases the value of the key. 
- The time complexity of this operation is O(log N).
- If the decreased key value of a node is greater than the parent of the node, then we don’t need to do anything
- Otherwise, we need to traverse up to fix the violated heap property.

&rarr; insert(): 

- Inserting a new key takes O(log N) time.
- We add a new key at the end of the tree. 
- If the new key is greater than its parent, then we don’t need to do anything.
- Otherwise, we need to traverse up to fix the violated heap property.

&rarr; delete():

- Deleting a key also takes O(log N) time.
- We replace the key to be deleted with the minimum infinite by calling decreaseKey().
- After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove the key.

&rarr; increaseKey();

- Increases value of given key to new_val.
- Heapify from the given key



```java
// Java program for the above approach
import java.util.*;

// A class for Min Heap 
class MinHeap {
    
    // To store array of elements in heap
    private int[] heapArray;
    
    // max size of the heap
    private int capacity;
    
    // Current number of elements in the heap
    private int current_heap_size;

    // Constructor 
    public MinHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }
    
    // Swapping using reference 
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    
    // Get the Parent index for the given index
    private int parent(int key) {
        return (key - 1) / 2;
    }
    
    // Get the Left Child index for the given index
    private int left(int key) {
        return 2 * key + 1;
    }
    
    // Get the Right Child index for the given index
    private int right(int key) {
        return 2 * key + 2;
    }
    
    
    // Inserts a new key
    public boolean insertKey(int key) {
        if (current_heap_size == capacity) {
            
            // heap is full
            return false;
        }
    
        // First insert the new key at the end 
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;
        
        // Fix the min heap property if it is violated 
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }
    
    // Decreases value of given key to new_val. 
    // It is assumed that new_val is smaller 
    // than heapArray[key]. 
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;

        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }
    
    // Returns the minimum key (key at
    // root) from min heap 
    public int getMin() {
        return heapArray[0];
    }
    
    
    // Method to remove minimum element 
    // (or root) from min heap 
    public int extractMin() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }
        
        // Store the minimum value, 
        // and remove it from heap 
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }
        
    // This function deletes key at the 
    // given index. It first reduced value 
    // to minus infinite, then calls extractMin()
    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }
    
    // A recursive method to heapify a subtree 
    // with the root at given index 
    // This method assumes that the subtrees
    // are already heapified
    private void MinHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != key) {
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }
    
    // Increases value of given key to new_val.
    // It is assumed that new_val is greater 
    // than heapArray[key]. 
    // Heapify from the given key
    public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }
    
    // Changes value on a key
    public void changeValueOnAKey(int key, int new_val) {
        if (heapArray[key] == new_val) {
            return;
        }
        if (heapArray[key] < new_val) {
            increaseKey(key, new_val);
        } else {
            decreaseKey(key, new_val);
        }
    }
}

class MinHeapTest {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(3);
        h.insertKey(2);
        h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.print(h.extractMin() + " ");
        System.out.print(h.getMin() + " ");
        
        h.decreaseKey(2, 1);
        System.out.print(h.getMin());
    }
}
```

* https://www.geeksforgeeks.org/binary-heap/
