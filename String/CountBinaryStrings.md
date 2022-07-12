[Problem](https://leetcode.com/problems/count-binary-substrings/)

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int res=0, prev=0, curr=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                res += prev<curr?prev:curr;
                prev = curr;
                curr = 1;
            }
            else{
                curr++;
            }
        }
        return res + (prev<curr?prev:curr);
    }
}
```

[Editorial](https://leetcode.com/problems/count-binary-substrings/solution/)