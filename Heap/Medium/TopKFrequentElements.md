https://leetcode.com/problems/top-k-frequent-elements/description/

https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int num:nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            } else {
                freqMap.put(num, 1);
            }
        }


        Comparator<Pair<Integer,Integer>> comparator = new Comparator<Pair<Integer,Integer>>(){

            @Override
            public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2) {
                //+1 means swap
                return p1.getValue() - p2.getValue();
            }
        };

        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(comparator);

        freqMap.forEach((num, freq) -> {
            pq.add(new Pair(num, freq));

            if(pq.size()>k){
                pq.poll();
            }
        });

        int[] result = new int[k];

        int i=0;
        while(!pq.isEmpty()){
            result[i++] = (int)(pq.poll().getKey());
        }

        return result;
    }
}
```