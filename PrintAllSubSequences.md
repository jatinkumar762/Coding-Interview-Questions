[]()


#### Method-1: Recursive Solution
```java
import java.io.*;
import java.util.*;

class GFG {
    
    static List<String> outputList;
    
    public static void printSubSequences(char[] inpArr, int start, int len, String output){
        
        if(start>=len){
            outputList.add(output); 
            return;
        }
        
        printSubSequences(inpArr, start+1, len, output+inpArr[start]);
        
        printSubSequences(inpArr, start+1, len, output);
        
    }
    
	public static void main (String[] args) {
		
		String inpStr = "abca";
		
		char[] inpArr = inpStr.toCharArray(); 
		outputList = new ArrayList<String>();
		printSubSequences(inpArr, 0, inpArr.length, "");
		
		System.out.println(outputList.toString());
	}
}
````

#### Method-2: using bits logic

```java
import java.io.*;
import java.util.*;

class GFG {
    
    static List<String> outputList;
    
    public static void printSubSequences(String inpStr){
        
        int totalSeq = 1<<inpStr.length();
        for(int i=0;i<totalSeq;i++){
            String output = "";
            for(int bit=0;bit<inpStr.length();bit++){
                if((i&(1<<bit))!=0){
                    output = inpStr.charAt(bit) + output;
                }
            }
            outputList.add(output);
        }
    }
    
	public static void main (String[] args) {
		
		String inpStr = "abc";
		outputList = new ArrayList<String>();
		printSubSequences(inpStr);
		System.out.println(outputList.toString());
		
	}
}
```



[Editorial](https://www.geeksforgeeks.org/print-subsequences-string/)