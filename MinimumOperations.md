[Problem Link](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)

#### Dynamic Programming Solution
```
import java.io.*;
import java.util.*;
class MinNoCoins
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                Solution ob = new Solution();
                System.out.println(ob.minOperation(n));
            }
        }
}    // } Driver Code Ends


//User function Template for Java
class Solution
{
    int arr[];
    public int minOperation(int n)
    {
        //code here.
        arr=new int[n+1];
        Arrays.fill(arr,0);
        arr[0]=0;
        arr[1]=1;
     
        for(int i=2;i<=n;i++)
        {
            int a=arr[i-1]+1;
            int b=arr[i/2]+1;
            if(i%2!=0)
                b+=1;
                
            arr[i]=a>b?b:a;
        }
        return arr[n];
        
    }
}
```