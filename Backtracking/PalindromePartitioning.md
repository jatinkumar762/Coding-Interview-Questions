[Problem](https://leetcode.com/problems/palindrome-partitioning/)

```java
class Solution {
    
    List<List<String>> result = new ArrayList<>();
    
    public boolean checkPalindrome(String str){
        
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public void getPalPart(String s, int start, int end, List<String> data)
    {
        
            if(start>=end && data.size()>0){      
                List<String> tmp=new ArrayList<String>();
                tmp.addAll(data);
                result.add(tmp);
                return;
            }
        
            for(int i=start+1;i<=end;i++){
                String tmp = s.substring(start, i);
                if(checkPalindrome(tmp))
                    data.add(tmp);
                else
                    continue;
                getPalPart(s, i, end, data);
                if(data.size()>0)
                    data.remove(data.size()-1);
            }
        
    }
    
    public List<List<String>> partition(String s) {
        getPalPart(s, 0, s.length(), new ArrayList<String>());
        return result;
    }
}
```