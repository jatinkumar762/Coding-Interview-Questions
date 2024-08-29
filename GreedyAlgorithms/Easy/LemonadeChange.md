https://leetcode.com/problems/lemonade-change/description/

```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fiveCount=0,tenCount=0;

        for(int bill:bills){

            if(bill==5){
                fiveCount++;
            }
            else if(bill==10) {
                if(fiveCount>0) {
                    fiveCount--;
                    tenCount++;
                } 
                else {
                    return false;
                }
            } 
            else {
                if(fiveCount>0 && tenCount>0) {
                    tenCount--;
                    fiveCount--;
                } 
                else if(fiveCount>2){
                    fiveCount-=3;
                } 
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
```
