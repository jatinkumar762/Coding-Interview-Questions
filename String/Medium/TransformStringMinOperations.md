[Transform String](https://practice.geeksforgeeks.org/problems/transform-string5648/1)

* Note - Question focuses on Find min. no of operation, not asking exact no. of operations 

```java
class Solution
{
    int transform (String A, String B)
    {
        // code here
        if (A.length() != B.length())
			return -1;

		int i, j, res = 0;
		int count[] = new int[256];

		// count characters in A
		// subtract count for every character in B
		for (i = 0; i < A.length(); i++) {
			count[A.charAt(i)]++;
			count[B.charAt(i)]--;
		}

		// Check if all counts become 0
		for (i = 0; i < 256; i++)
			if (count[i] != 0)
				return -1;

		i = A.length() - 1;
		j = B.length() - 1;
		
		while (i >= 0) {
			// If there is a mismatch, then keep
			// incrementing result 'res' until B[j] is not
			// found in A[0..i]
			if (A.charAt(i) != B.charAt(j))
				res++;
			else
				j--;
			i--;
		}
		return res;
    }
}
```

Example:

GseekForGeeks orFGeeksGeeks

why answer is 7 (min. no of operations)
it should be 8 (exact no of operations)

GseekForGeeks-> sGeekForGeeks-> ksGeeForGeeks -> eksGeForGeeks -> eeksGForGeeks -> GeeksForGeeks -> FGeeksorGeeks -> rFGeeksoGeeks -> orFGeeksGeeks


#### Editorial
* [https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/](https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/)