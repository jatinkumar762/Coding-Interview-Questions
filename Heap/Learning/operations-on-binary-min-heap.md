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