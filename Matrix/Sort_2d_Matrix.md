[Problem](https://www.geeksforgeeks.org/sort-the-given-matrix-memory-efficient-approach/)

#### Normal Approach
Create a temp[] array of size Rows*Cols. Starting with the first row one by one copy the elements of the given matrix into temp[]. Sort temp[]. Now one by one copy the elements of temp[] back to the given matrix.

#### Optiomal Approach
* Consider 2D array as a 1D array.
* Ith Element of the Matrix = Mat[ i / cols ][ i % cols ]  


```java
class Solution {
    int cols;
    int getPivotIndex(int Mat[][],int start,int end){
        
        int rIndex = (start) + (int)(Math.random() * (end - start + 1));
        int tmp;
        
        tmp = Mat[end/cols][end%cols];
        Mat[end/cols][end%cols] = Mat[rIndex/cols][rIndex%cols];
        Mat[rIndex/cols][rIndex%cols] = tmp;
        
        int pivotElement = Mat[end/cols][end%cols];
        int i = start-1;
        
        for(int j=start;j<end;j++){
            if(Mat[j/cols][j%cols] < pivotElement){
                i++;
                tmp = Mat[j/cols][j%cols];
                Mat[j/cols][j%cols] = Mat[i/cols][i%cols];
                Mat[i/cols][i%cols] = tmp;
            } 
        }
        i++;
        tmp = Mat[end/cols][end%cols];
        Mat[end/cols][end%cols] = Mat[i/cols][i%cols];
        Mat[i/cols][i%cols] = tmp;
        return i;
    }
    
    void QuickSort(int Mat[][],int start,int end){
        
        if(start<end){
            int pivot = getPivotIndex(Mat, start, end); 
            QuickSort(Mat, start, pivot-1);
            QuickSort(Mat, pivot+1, end);
        }
    }
    
    int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        int size = N*N;
        cols = N;
        QuickSort(Mat,0,size-1);
        return Mat;
    }
};
```