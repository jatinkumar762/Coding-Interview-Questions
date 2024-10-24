https://leetcode.com/problems/sort-characters-by-frequency/description/

### Approach - 1 HashMap + PriorityQueue

```
// Custom Comparator for descending order
Comparator<Integer> descendingComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return b.compareTo(a); // Reverse order
    }
};
```

- Using Lambda Expressions
- If you're using Java 8 or later, you can simplify the comparator using a lambda expression:
- PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
- This line creates a PriorityQueue that sorts integers in descending order, achieving the same result with less code.

```java
class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> charToFreqMap = new HashMap<>();

        for(Character c : s.toCharArray()){
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }

        //max heap
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(charToFreqMap.entrySet());

        StringBuilder res = new StringBuilder("");
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            
            for(int i = 1; i<= entry.getValue(); i++){
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }
}
```



### Approach - 2 NestedMap

* faster than approach-1

```java
class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> charToFreqMap = new HashMap<>();

        for (Character c : s.toCharArray()) {
            charToFreqMap.put(c, charToFreqMap.getOrDefault(c, 0) + 1);
        }

        TreeMap<Integer, List<Character>> freqToListCharMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Character, Integer> entry : charToFreqMap.entrySet()) {
            if (!freqToListCharMap.containsKey(entry.getValue())) {
                freqToListCharMap.put(entry.getValue(), new ArrayList<>());
            }
            freqToListCharMap.get(entry.getValue()).add(entry.getKey());
        }

        StringBuilder res = new StringBuilder("");
        for (Map.Entry<Integer, List<Character>> entry : freqToListCharMap.entrySet()) {

            for (char ch : entry.getValue()) {
                for (int i = 1; i <= entry.getKey(); i++) {
                    res.append(ch);
                }
            }
        }

        return res.toString();
    }
}
```