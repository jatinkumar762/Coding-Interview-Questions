https://leetcode.com/problems/majority-element/description/


#### Approach-1 Using Hashing

* if count goes above n/2, will return the element

&rarr; TimeComplexity - $O(N)$

&rarr; SpaceComplexity - $O(N)$

#### Approach-2 Using Boyer-Moore Voting Algorithm

&rarr; TimeComplexity - $O(N)$

&rarr; SpaceComplexity - $O(1)$

1. problem asks, element that appears more than ⌊n / 2⌋ times &rarr; only 1 element possible in array
2. here we use counter for element, when counter goes to 0, means till current index from last zero counter index, can't be max element ⌊n / 2⌋ for current sub array

**How it works:**

**Step 1:** Candidate Selection

* Maintain a candidate and a counter initialized to 0.
* Traverse the array:
  * If the counter is 0, pick the current element as the candidate.
  * If the current element is the same as the candidate, increase the counter.
  * If the current element is different from the candidate, decrease the counter.

**Step 2:** Candidate Verification

* After traversing the array, you’ll end up with a candidate. In this step, verify if it is indeed the majority element by counting its occurrences.