
```java
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		String input = "ABCD";
		List<String> outputList = new ArrayList<String>();
		for(int i=0;i<input.length();i++){
		    String output = "";
		    for(int j=i;j<input.length();j++){
		        output += input.charAt(j);
		        outputList.add(output);
		    }
		}
		System.out.println(outputList);
	}
}
```

[Editorial](https://www.geeksforgeeks.org/program-print-substrings-given-string/)