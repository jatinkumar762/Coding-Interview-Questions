#### Methods
* Brute force approach using two nested loops
* Using Sorting and two pointers
* Using Sorting and binary search
* Using Set

---
#### Using Sorting and binary search

```java
public boolean binarySearch(int[] arr, int start, int end, int key){    
    if(start>end)
        return false;
    
    int mid = start + (end-start)/2;
    
    if(arr[mid]==key || arr[start]==key || arr[end]==key)
        return true;
    
    if(arr[mid]>key)
        return binarySearch(arr,start,mid-1,key);
    else
        return binarySearch(arr,mid+1,end,key);  
    
}

public int[] intersection(int[] nums1, int[] nums2) {
    
    Arrays.sort(nums1);
    
    int i=0,j=0;
    int len1 = nums1.length;
    int len2 = nums2.length;
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(i=0;i<len2;i++){
        if(i==0 || nums2[i]!=nums2[i-1]){
            if(binarySearch(nums1,0,len1-1,nums2[i])){
                    result.add(nums2[i]);
            }
        }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
}
```

----

#### Using Set

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}
```
