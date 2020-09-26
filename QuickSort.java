import java.util.*;
import java.io.*;


class QuickSort
{
	int arrSize;

	int findPivot(int arr[],int left,int right)
	{
		int pivot=arr[right];
		int i=left-1;
		int temp;
		for(int j=left;j<right;j++)
		{
			if(arr[j]<arr[right])
			{
				i++;
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		temp = arr[i+1];
		arr[i+1]=arr[right];
		arr[right]=temp;

		return (i+1);
	}

	void qSort(int arr[],int left,int right)
	{
		if(left<right)
		{
			int pivot=findPivot(arr,left,right);
			qSort(arr,left,pivot-1);
			qSort(arr,pivot+1,right);
		}
	}

	public static void main(String[] args) throws IOException
	{
		
		QuickSort qs=new QuickSort();

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Array Size:");
		qs.arrSize = Integer.parseInt(br.readLine());
		System.out.println("Enter array elements:");
		String str[]=br.readLine().trim().split(" ");

		int arr[]=new int[qs.arrSize]; 
		for(int i=0;i<qs.arrSize;i++)
			arr[i]=Integer.parseInt(str[i]);

		qs.qSort(arr,0,qs.arrSize-1);

		System.out.println("Sorted Array:");
		for (int i=0;i<qs.arrSize;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}
}
