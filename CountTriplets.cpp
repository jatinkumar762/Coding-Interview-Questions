//https://practice.geeksforgeeks.org/problems/count-the-triplets/0

#include<bits/stdc++.h>
using namespace std;

#define ll long long int

int main()
 {
	//code
	ll test,size,*arr,count,val;
	cin>>test;
	while(test--)
	{
	    cin>>size;
	    count=0;
	    arr =new ll[size];
	    
	    ll hsh[100007] = {0};
	    
	    for(ll i=0;i<size;i++)
	    {
	        cin>>arr[i];
	        hsh[arr[i]] = 1;
	    }
	   
	    if(size<=2)
	    {
	        cout<<-1<<endl;
	    }
	    else
	    {
    	    sort(arr,arr+size);
    	    
    	    for(ll j=size-1;j>=2;j--)
    	    {
    	        for(ll k=j-1,l=0;k>l;)
    	        {
    	            if(arr[k]+arr[l]==arr[j])
    	            {
    	                k--;l++;
    	                count++;
    	            }
    	            else if(arr[k]+arr[l]>arr[j]){
    	                k--;
    	            }
    	            else{
    	                l++;
    	            }
    	        }
    	    }
    	    if(count>0)
    	      cout<<count<<endl;
    	    else
    	      cout<<-1<<endl;
	    }
	    
	}
	return 0;
}
