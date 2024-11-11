https://leetcode.com/problems/lru-cache/description/

### Approach-1 Using Inbuilt doubly linked list and Map

```java
class LRUCache {

    LinkedList<Integer> dLL;
    Map<Integer, Integer> keyToValue;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        dLL = new LinkedList<>();
        this.capacity = capacity;
        keyToValue = new HashMap<>();
        this.count = 0;
    }

    //O(capacity)
    public int get(int key) {

        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        // if directly pass int, then it will consider index not object
        dLL.remove(Integer.valueOf(key));

        dLL.addFirst(key);

        return keyToValue.get(key);
    }

    //O(capacity)
    public void put(int key, int value) {

        if (keyToValue.containsKey(key)) {
            dLL.remove(Integer.valueOf(key));
        } else {
            if (count == capacity) {
                keyToValue.remove(dLL.removeLast());
            } else {
                count += 1;
            }
        }

        keyToValue.put(key, value);
        dLL.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```