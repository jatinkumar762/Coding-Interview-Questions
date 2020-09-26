import java.io.*;
import java.util.*;

class HeapSort
{
	int arr[];
	int size;

	HeapSort(int size)
	{
		this.size=size;
		arr=new int[size];
	}

	void heapify(int arr[],int max,int root)
	{
		int left=2*root+1;
		int right=2*root+2;
		int largest=root;
		if(left<max)
		{
			if(arr[left]>arr[largest])
				largest=left;

			if(right<max)
			{
				if(arr[right]>arr[largest])
					largest=right;
			}
		}
		if(largest!=root)
		{
			int temp=arr[largest];
			arr[largest]=arr[root];
			arr[root]=temp;

			heapify(arr,max,largest);
		}
	}

	void hSort(int arr[])
	{
		// Build heap (rearrange array) 
		for(int i=this.size/2-1;i>=0;i--)
			heapify(arr,this.size,i);


		for(int i=this.size-1;i>=0;i--)
		{
			// Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
		}
	}



	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter array size:");
		int size = Integer.parseInt(br.readLine().trim());

		HeapSort hs=new HeapSort(size);

		System.out.println("Enter array elements:");
		String str[]=br.readLine().trim().split(" ");

		for(int i=0;i<size;i++)
		{
			hs.arr[i]=Integer.parseInt(str[i]);
		}

		hs.hSort(hs.arr);

		//Sorted Array
		for(int i=0;i<size;i++)
			System.out.println(hs.arr[i]);
	}

}