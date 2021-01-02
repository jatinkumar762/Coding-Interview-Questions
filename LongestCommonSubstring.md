[Problem Link](https://practice.geeksforgeeks.org/problems/longest-common-substring/0#)

```java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    
	public static void main (String[] args) throws IOException
	{
	    //code
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int test=Integer.parseInt(br.readLine());
	    int M,N;
	    int arr[][];
	    while(test-->0)
	    {
	        String lens[]=br.readLine().trim().split(" ");
	        M = Integer.parseInt(lens[0]);N=Integer.parseInt(lens[1]);
	        
	        String str1 = br.readLine().trim();
	        String str2 = br.readLine().trim();
	        
	        arr=new int[M+1][N+1];
	        for(int[] temp:arr)
	            Arrays.fill(temp,0);
	        
	        int max=0;    
	        for(int i=1;i<=M;i++)
	        {
	            for(int j=1;j<=N;j++)
	            {
	                if(str1.charAt(i-1)==str2.charAt(j-1))
	                {
	                    arr[i][j]=arr[i-1][j-1]+1;
	                    max = max<arr[i][j]?arr[i][j]:max;
	                }
	            }
	        }
	        System.out.println(max);
	    }
	 }
}
```