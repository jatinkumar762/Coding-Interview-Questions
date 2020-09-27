import java.util.*;
import java.io.*;

class MergeSort
{
	int arr[];
	int size;

	MergeSort(int size)
	{
		this.size=size;
		this.arr=new int[size];
	}


	void merge(int arr[],int left,int mid,int right)
	{
		int n1 = mid-left+1;
		int n2 = right-mid;

		int L[]=new int[n1];
		int R[]=new int[n2];

		for(int i=0;i<n1;i++)
			L[i]=arr[left+i];

		for(int i=0;i<n2;i++)
			R[i]=arr[mid+1+i];


		int i=0,j=0,k=left;
		while(i<n1 && j<n2)
		{

			if(L[i]<R[j])
			{
				arr[k]=L[i];
				i++;
			}
			else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k++]=L[i++];
		}

		while(j<n2)
		{
			arr[k++]=R[j++];
		}

	}

	void sort(int arr[],int left,int right)
	{
		if(left<right)
		{
			int mid=(left+right)/2;

			sort(arr,left,mid);
			sort(arr,mid+1,right);

			merge(arr,left,mid,right);
		}
	}



	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter array size:");
		int size = Integer.parseInt(br.readLine().trim());

		MergeSort ms=new MergeSort(size);

		System.out.println("Enter array elements:");
		String str[]=br.readLine().trim().split(" ");

		for(int i=0;i<size;i++)
		{
			ms.arr[i]=Integer.parseInt(str[i]);
		}

		ms.sort(ms.arr,0,size-1);

		//Sorted Array
		for(int i=0;i<size;i++)
			System.out.println(ms.arr[i]);

	}

}