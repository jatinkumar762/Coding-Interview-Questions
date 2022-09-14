[Longest Repeating Subsequence](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1)

```java
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int len = str.length();
        int[][] arr = new int[len+1][len+1];
        
        for(int[] a : arr){
            Arrays.fill(a,0);
        }
        
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=str.length();j++){
                if(str.charAt(i-1)==str.charAt(j-1) && (i!=j)){
                    arr[i][j] = arr[i-1][j-1]+1;
                } else {
                    int max = arr[i-1][j-1]>arr[i-1][j]?arr[i-1][j-1]:arr[i-1][j];
                    max = max>arr[i][j-1]?max:arr[i][j-1];
                    arr[i][j] = max;
                }
            }
        }
        return arr[len][len];
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/longest-repeating-subsequence/](https://www.geeksforgeeks.org/longest-repeating-subsequence/)