#### Case-1
[Problem Link](https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1#)

```java
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            res = new Sum().combinationSum(list, sum);
            if (res.size() == 0) {
    			System.out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				System.out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					System.out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 System.out.print(" ");
    				}
    				System.out.print(")");
    			}
    		}
    		System.out.println();
    		res.clear();
	    }
    }
    
}

// } Driver Code Ends


class Sum
{
    static ArrayList<Integer> temp;
    static void findNumbers(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, int B, int index)
    {
         if(B<0)
           return;
            
         if(B==0)
         {
           /*     
            for(int i=0;i<temp.size();i++)
                System.out.print(temp.get(i));
            System.out.println();
            */
            res.add(new ArrayList<>(temp));
            return;
         }
         
         for(int i=index;i<A.size();i++)
         {
            if(B-A.get(i)>=0)
            {
                temp.add(A.get(i));
                findNumbers(res, A, B-A.get(i), i);
                temp.remove(temp.size()-1);
            }
         }
    }
    
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Set<Integer> set=new HashSet<Integer>();
        set.addAll(A);
        
        A.clear();
        A.addAll(set);
        
        Collections.sort(A);
        /*
            for(int i=0;i<A.size();i++)
                System.out.println(A.get(i));
        */
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        temp=new ArrayList<Integer>();
        
        findNumbers(res,A,B,0);

        return res;
    }
}
```

#### Case-2
[Problem Link](https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1#)

```java
// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            int B = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            List<List<Integer>> result = new ArrayList<>();
            result = ob.combinationSum(A, N, B);
            if(result.size() == 0)
            System.out.println("Empty");
            else{
                for(int i = 0;i < result.size(); i++){
                    System.out.print("(");
                    for(int j = 0;j < result.get(i).size();j++){
                        System.out.print(result.get(i).get(j));
                        if(j != result.get(i).size() - 1)
                        System.out.print(" ");
                    }
                    System.out.print(")");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for java
class Solution
{
    static ArrayList<Integer> temp;
    static void findNumbers(List<List<Integer>> res, int[] A, int B, int index)
    {
         if(B<0)
           return;
            
         if(B==0)
         {
           /*     
            for(int i=0;i<temp.size();i++)
                System.out.print(temp.get(i));
            System.out.println();
            */
            if(!res.contains(temp))
                res.add(new ArrayList<>(temp));
            return;
         }
         
         for(int i=index;i<A.length;i++)
         {
            if(B-A[i]>=0)
            {
                temp.add(A[i]);
                findNumbers(res, A, B-A[i], i+1);
                temp.remove(temp.size()-1);
            }
         }
    }
    
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
        // code here
        //Set<Integer> set=new HashSet<Integer>();
        //set.addAll(A);
        
        //A.clear();
        //A.addAll(set);
        
        Arrays.sort(A);
        /*
            for(int i=0;i<A.size();i++)
                System.out.println(A.get(i));
        */
        List<List<Integer>> res=new ArrayList<>();
        temp=new ArrayList<Integer>();
        
        findNumbers(res,A,B,0);

        return res;
    }
}
```