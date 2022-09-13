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

#### Method-2: Sorting

```java
class SetBitCounts implements Comparator<Integer>{
    
    Map<Integer,Integer> keyBitCountMap;
    SetBitCounts(Map<Integer,Integer> keyBitCountMap){
        this.keyBitCountMap=keyBitCountMap;
    }
    
    public int compare(Integer a,Integer b){
        int bitCounts_a = keyBitCountMap.get(a);
        int bitCounts_b = keyBitCountMap.get(b);
        
        if(bitCounts_a<bitCounts_b){
            return 1;
        } else if(bitCounts_a==bitCounts_b){
            return 0;
        }
        return -1;
    }
}


class Compute  
{ 
    static Map<Integer,Integer> keyBitCountMap = new HashMap<>();
    
    private static int getBitCounts(Integer a){
        int count=0;
        while(a>0){
            if((a&1)==1)
                count+=1;
            a = a>>1;
        }
        return count;
    }

    static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
        for(int num : arr){
            if(!keyBitCountMap.containsKey(num)){
                keyBitCountMap.put(num, getBitCounts(num));
            }
        }
        
        Arrays.sort(arr, new SetBitCounts(keyBitCountMap));
        sortBySetBit(arr, n);
    } 
}
```

#### Editorial
* [https://www.geeksforgeeks.org/sort-array-according-count-set-bits/](https://www.geeksforgeeks.org/sort-array-according-count-set-bits/)

