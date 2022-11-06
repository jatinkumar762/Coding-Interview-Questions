```java
public class Solution {
  public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
  }
}
```

* it is a stable sort
* space complexity - O(1)
* time complexity - O(N^2)
* Advantages -
  * Generally, on almost sorted arrays where the number of inversions is relatively small compared to the size of the array, insertion sort will be quite fast since the number of swaps required will be low on almost sorted arrays.
  * best choice on small arrays. This is more of an empirical observation (practical experience rather than theories) based on experiments. Many sorting functions have a quick check for the size of the collection and if that value is below a threshold, the program will default to insertion sort. Java's official implementation of Arrays.sort() performs such a check before performing more theoretically optimal sorts.
* Disadvantages -
  *  on larger collections with many inversions, other sorts will generally outperform insertion sort

#### Editorial
* [https://www.geeksforgeeks.org/insertion-sort/](https://www.geeksforgeeks.org/insertion-sort/)
* [https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4435/](https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4435/)