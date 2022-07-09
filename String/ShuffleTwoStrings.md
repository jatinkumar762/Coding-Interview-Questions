[Problem Link](https://www.geeksforgeeks.org/check-if-the-given-string-is-shuffled-substring-of-another-string/)

```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShuffleTwoStrings
{
	
	static boolean compareFreq(int[] freq, int[] freqW) {

		for(int i=0;i<256;i++){
			if(freq[i]!=freqW[i])
				return false;
		}
		return true;
	}

	static boolean isShuffleTwoStrings(String patt, String txt) {

		int N = patt.length();
		int M = txt.length();

		if(N > M)
			return false;

		int[] freq = new int[256];

		int[] freqW = new int[256];

		int i;
		for(i=0;i<N;i++){

			freq[patt.charAt(i)]++;

			freqW[txt.charAt(i)]++;
		}

		if(compareFreq(freq, freqW))
			return true;

		for(;i<M;i++){

			freqW[txt.charAt(i)]++;


			freqW[txt.charAt(i-N)]--;
			
			if(compareFreq(freq, freqW))
				return true;

		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = br.readLine();
		String txt = br.readLine();

		System.out.println(isShuffleTwoStrings(pattern, txt));
	}
}

```