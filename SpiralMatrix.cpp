#include <iostream>
using namespace std;

int main() {
	// your code goes here
    int rows,cols,i,j;
    cin>>rows>>cols;

    /*int arr[4][4]={   {1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16}
                         };
    */
    int arr[rows][cols];
    
    for(i=0;i<rows;i++)
        for(j=0;j<cols;j++)
        cin>>arr[i][j];

    int  left=0,right=cols-1,bottom=rows-1;

    while(left<=bottom)
    {
         for(j=left;j<=right;j++)
         cout<<arr[left][j]<<" ";

         for(j=left+1;j<bottom;j++)
         cout<<arr[j][right]<<" ";

         for(j=right;j>=left;j--)
         cout<<arr[bottom][j]<<" ";

         for(j=bottom-1;j>left;j--)
         cout<<arr[j][left]<<" ";

        left=left+1;
        right=right-1;
        bottom=bottom-1;
        
        cout<<endl;
    }

	return 0;
}
