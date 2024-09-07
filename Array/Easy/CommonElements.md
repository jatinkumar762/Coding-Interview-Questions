[Problem](https://practice.geeksforgeeks.org/problems/common-elements1132/1)

```java
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        int i=0,j=0,k=0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lastElement = -1;
        //we are seeing common elements in all 3
        //if any array end means no common in all 3 possible after it
        while(i<n1 && j<n2 && k<n3){
            if(A[i]==B[j] && B[j]==C[k])
            {
                if(result.size()==0 || lastElement!=A[i]){
                    result.add(A[i]);
                    lastElement=A[i];
                }
                i++; j++; k++;
            }
            else if(A[i]<=B[j] && A[i]<=C[k]){
                i++;
            }
            else if(B[j]<=C[k]){
                j++;
            }
            else{
                k++;
            }
        }
        return result;
    }
}
```

#### Editorial
* 