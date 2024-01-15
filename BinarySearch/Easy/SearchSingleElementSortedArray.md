[Problem](https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/)

#### Approach-1 (Single Traversal)

#### Approach-2 (XOR)
* a ^ a = 0, XOR of two same numbers results in 0.
* a ^ 0 = a, XOR of a number with 0 always results in that number.

#### Approach-3 (Binary Search)

1. If (i % 2 == 0 and arr[i] == arr[i+1]) or (i%2 == 1 and arr[i] == arr[i-1]), we are in the left half.
2. If (i % 2 == 0 and arr[i] == arr[i-1]) or (i%2 == 1 and arr[i] == arr[i+1]), we are in the right half.
here i represents mid