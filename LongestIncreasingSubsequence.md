[Problem Link](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1)

```java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception
	{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0)
		{
		    int N = Integer.parseInt(br.readLine());
		    
		    String str[]=br.readLine().trim().split(" ");
		    
		    int arr[]=new int[N];
		    
		    for(int i=0;i<N;i++)
		        arr[i]=Integer.parseInt(str[i]);
		    
		    
		    int count[]=new int[N];
		    Arrays.fill(count,1);
		    
		    for(int j=1;j<N;j++)
		    {
		        for(int i=0;i<j;i++)
		        {
		            if(arr[j]>arr[i] && count[j]<(count[i]+1))
		                count[j]=count[i]+1;
		        }
		    }
		    
		    int max=count[0];
		    for(int j=1;j<N;j++)
		        max = (max<count[j]) ? count[j]:max;
		    
		    System.out.println(max);
		}
	}
}
```