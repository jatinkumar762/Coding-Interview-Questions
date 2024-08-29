https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1


#### Approach

* we can sort the meeting based on their end time -> those who end first will first in order
* if end time is same, then we can sort them based on start time -> those who start late will first in order
* the above approach will help in max meetings


#### Method-1

```java
class Meeting implements Comparable<Meeting> {
    int start;
    int end;
    
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Meeting m2){
        
        /*
        if (m2.end<this.end) {
            return 1;
        } 
        else if (m2.end>this.end) {
            return -1;
        }
        else if (m2.end==this.end){
             return Integer.compare(this.start, m2.start);
        }
        */

        //short version of above commented code
        int res = Integer.compare(this.end, m2.end); //1->swap, -1/0 no swap
        
        //not needed
        // if(res==0){
        //     res = Integer.compare(this.start, m2.start);
        // }
    
        return res;
    }
} 


class Solution {

    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        
        List<Meeting> meetingList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            meetingList.add(new Meeting(start[i], end[i]));
        }
        
        Collections.sort(meetingList);
        
        int count = 0;
        Meeting prev=null,curr=null;
        
        for(int i=0;i<n;i++){
            
            if (i==0) {
                prev = meetingList.get(i);
                count+=1;
                continue;
            }
            
            curr = meetingList.get(i);
            
            if(curr.start>prev.end){
                count+=1;
                prev = curr;
            }
        }
        
        return count;
    }
}
```