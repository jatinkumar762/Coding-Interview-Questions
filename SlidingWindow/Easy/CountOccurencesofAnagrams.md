[gfg - count-occurences-of-anagrams](https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)

```java

class Solution {

    boolean match(int[] patFreq, int[] txtFreq){
        
        for(int i=0;i<patFreq.length;i++){
            if(patFreq[i]!=txtFreq[i])
                return false;
        }
        return true;
    }
    
    int search(String pat, String txt) {
        // code here
        int result=0;
        int patLen = pat.length();
        
        int[] patFreq = new int[26];
        Arrays.fill(patFreq, 0);
        
        for(int i=0;i<pat.length();i++){
            patFreq[pat.charAt(i)-97]++;
        }
        
        int[] txtFreq = new int[26];
        Arrays.fill(txtFreq, 0);
        
        for(int i=0;i<patLen;i++){
            txtFreq[txt.charAt(i)-97]++;
        }
        
        if(match(patFreq, txtFreq))
            result++;
        
        for(int i=patLen;i<txt.length();i++){
            txtFreq[txt.charAt(i)-97]++;
            txtFreq[txt.charAt(i-patLen)-97]--;
            
            if(match(patFreq, txtFreq))
                result++;
        }
        
        return result;
    }
}

```