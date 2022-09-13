[Sort by Set Bit Count](https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1)

#### Method-1: CountingSort

```java
class Compute  
{ 
    static int countBits(int a)
    {
      int count = 0;
      while (a > 0)
      {
        if ((a & 1) > 0 )
          count += 1;
        a = a >> 1;
      }
      return count;
    }

    static void sortBySetBitCount(Integer arr[], int n)
    { 
        Vector<Integer> []count = new Vector[32];
    
        for (int i = 0;i < count.length; i++)
            count[i] = new Vector<Integer>();
           
        int setbitcount = 0;
           
        for (int i = 0; i < n; i++)
        {
            setbitcount = countBits(arr[i]);
            count[setbitcount].add(arr[i]);
        }
         
        // Used as an index in
        // final sorted array
        int j = 0; 
        
        // Traverse through all bit
        // counts (Note that we sort
        // array in decreasing order)
        for (int i = 31; i >= 0; i--)
        {
            Vector<Integer> v1 = count[i];
         
            for (int p = 0; p < v1.size(); p++)
              arr[j++] = v1.get(p);
        }
    } 
}
```

