https://leetcode.com/problems/hand-of-straights/description/

### Approach-1 Using HashMap

```java
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int N = hand.length;

        if (N % groupSize != 0) {
            return false;
        }

        // TreeMap to store the count of each card value
        Map<Integer, Integer> cardCount = new TreeMap<>();

        for (int h : hand) {
            cardCount.put(h, cardCount.getOrDefault(h, 0) + 1);
        }

        while (!cardCount.isEmpty()) {

            int currentCard = cardCount.entrySet().iterator().next().getKey();

            for (int i = 0; i < groupSize; i++) {

                // why i = 0 ? bcz first element of group is currentCard
                if (!cardCount.containsKey(currentCard + i)) {
                    return false;
                }

                cardCount.put(currentCard + i, cardCount.get(currentCard + i) - 1);

                if (cardCount.get(currentCard + i) == 0) {
                    cardCount.remove(currentCard + i);
                }
            }
        }

        return true;
    }
}
```