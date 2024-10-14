https://leetcode.com/problems/edit-distance/description/

f(n-1, m-1) &rarr; min operations to convert S1[0..i] to S2[0..j]

### Recursion

1. express in terms of index
2. explore all paths of matching
      1. if S1[i]==S2[j] return 0 + f(i-1, j-1)
      2. 1 + f(i, j-1) //insert
      3. 1 + f(i-1, j) //delete
      4. 1 + f(i-1, j-1) //replace 
3. return min of all paths
4. Base case
      1. s1 gets exhausted i<0
      2. s2 gets exhausted j<0

