[Problem Link](https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1#)

```java

class Solution{
    static String readOff(String input){
        
        char ch = input.charAt(0);
        int count = 1;
        
        String output = "";
        
        for(int i=1;i<input.length();i++){
            
            if(ch==input.charAt(i)){
                count++;
            }
            else {
                output += count;
                output += ch;
                
                count = 1;
                ch = input.charAt(i);
            }
        }
        output += count;
        output += ch;
        
        return output;
    }
    
    static String lookandsay(int n) {
        //your code here
        
        String out = "1";
        for(int i=1;i<n;i++){
            out = readOff(out);
        }
        return out;
    }
}

```