[Problem](https://practice.geeksforgeeks.org/problems/three-way-partitioning/1)

```java
class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here 
        int start=0,end=array.length-1,tmp;
        for(int i=0;i<array.length && i<=end;){
            
            if(array[i]<a){
                if(i==start){
                    i++; start++;
                } else {
                    tmp = array[start];
                    array[start] = array[i];
                    array[i] = tmp;
                    start++;
                    i++;
                }
            } else if(array[i]>b){
                    tmp = array[end];
                    array[end] = array[i];
                    array[i] = tmp;
                    end--;
            } else i++;
        }
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/](https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/)