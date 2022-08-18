[Problem](https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1)

* Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.

```java
class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int res[] = new int[n];
        int index=0;
        int pos=0,neg=0;
        while(pos<n && neg<n){
            while(pos<n && arr[pos]<0){
                pos++;
            }
            if(pos<n)
                res[index++] = arr[pos++];
            while(neg<n && arr[neg]>=0){
                neg++;
            }
            if(neg<n)
                res[index++] = arr[neg++];
        }
        while(pos<n){
            if(arr[pos]>=0){
                res[index++] = arr[pos];
            }
            pos++;
        }
        while(neg<n){
            if(arr[neg]<0){
                res[index++] = arr[neg];
            }
            neg++;
        }
        //System.out.println(Arrays.toString(res));
        for(int i=0;i<res.length;i++){
            arr[i] = res[i];
        }
    }
}
```