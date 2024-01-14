[Problem](https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/)

The idea for this approach is to use binary search to find an integer equal to ‘M’ when multiplied by itself ‘N’ times.

The exponential function is an increasing function (i.e., monotonic), and thus, using binary search, we will try out different possible square roots; let’s suppose we are currently on ‘X’, then we will find 

If ‘XN’ is greater than ‘M’, then we must reduce the higher bound of our search space.
If ‘XN’ is less than ‘M’, then we must increase the lower bound of our search space.
If ‘XN’ equals ‘M’, we found our ‘N’th root.
 
To find the value of ‘XN’, we can use a loop, which will iterate ‘N’ times.

 
The steps are as follows:-

// Function to find the Nth root of M

function NthRoot(int n, int m):

Declare a variable ‘ans’, which is initially assigned to ‘-1’.
Declare two more variables, ‘s’ and ‘e’, initially assigned to ‘1’ and ‘m’, respectively.
While ‘s <= e’:
Declare a variable ‘mid’ and assign it to ‘(s + e) / 2’.
Declare a variable ‘x’ and assign it to ‘1’.
Iterate from index ‘1’ to ‘n’:
Assign ‘x’ to ‘x * mid’.
If ‘x > m’:
Break the loop.
If ‘x == m’:
Assign ‘ans' to ‘mid’.
Break the loop.
If ‘x > m’:
Assign ‘e’ to ‘mid - 1’.
else:
Assign ‘s’ to ‘mid + 1'.
Return ‘ans'.
Time Complexity
O( n * log(M) ), Where ‘N’ and ‘M’ are input integers.

In the above algorithm, the search space is ‘M’, and hence in ‘log(M)’ iterations, we will find the ‘N’th root, and in each iteration, we find the ‘N’th power of ‘mid’ using a loop.

Hence the time complexity will be O( n * log(M) )

Space Complexity
O( 1 ).
 

In the above algorithm, we only use variables.
Hence the space complexity will be O( 1 ).

#### References
https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679?leftPanelTabValue=SOLUTION