[Longest Common Subsequence](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1)

```java
class LCS
{
    // function to find LCS
    static int lcs(int p, int q, String s1, String s2)
    {
        // your code here
        int arr[][]=new int[p+1][q+1];
        for(int[] a:arr)
            Arrays.fill(a,0);
            
        for(int i=1;i<=p;i++)
        {
            for(int j=1;j<=q;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else{
                    arr[i][j]=arr[i-1][j]>arr[i][j-1]?arr[i-1][j]:arr[i][j-1];
                }
            }
        }
        return arr[p][q];
    }
}
```

#### Editorial
* [https://www.cdn.geeksforgeeks.org/printing-longest-common-subsequence/](https://www.cdn.geeksforgeeks.org/printing-longest-common-subsequence/)