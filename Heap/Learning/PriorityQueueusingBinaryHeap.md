### PriorityQueue

* part of the java.util package
* implementation of a queue that orders elements based on their priority
* The queue allows elements to be retrieved in order of their priority, where the element with the highest priority is dequeued first (or the lowest, depending on the configuration).

**Key Characteristics of PriorityQueue:**

1. **Ordering:** By default, a PriorityQueue orders elements according to their natural ordering (using Comparable)

2. **Heap-based:** Internally, a PriorityQueue uses a heap (typically a binary heap) to maintain the order of elements

3. **No Capacity Limit:** Unlike other collections, the size of a PriorityQueue is not fixed. It will grow as needed.

4. **Doesn't allow null elements:** The PriorityQueue does not accept null elements. Inserting null will throw a NullPointerException.

5. **Unordered access:** Unlike a Queue, where the elements are typically processed in FIFO (First In, First Out) order, in a PriorityQueue, elements are processed based on their priority, not the order they were added.

```java

public class Main
{
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// Adds an element
		pq.add(10);
		
		// Adds another element
		pq.offer(20);
		
		//retrieves the element with the highest priority without removing it
		Integer highestPriority = pq.peek();
		
		//removes and returns the element with the highest priority.
		Integer removedElement = pq.poll(); 
		
		// Returns the number of elements in the queue
		int size = pq.size(); 
		
		// Returns true if the queue is empty
		boolean isEmpty = pq.isEmpty();  
		
		//iterating through its elements doesn't guarantee any specific order
		for (Integer num : pq) {
            System.out.println(num);
        }

	}
}
```

**Custom Ordering**




