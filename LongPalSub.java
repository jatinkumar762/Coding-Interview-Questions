import java.io.*;
import java.util.*;

public class LongPalSub
{  
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inp= br.readLine().trim();
        int len = inp.length();
        int arr[][]=new int[len+1][len+1];

        for(int[] temp:arr)
            Arrays.fill(temp, 0);

        int max=1;
        int index=0;
        for(int i=1;i<=len;i++)
        {
            for(int j=1;j<=len;j++)
            {
                if(inp.charAt(i-1)==inp.charAt(len-j))
                {
                    arr[i][j]=arr[i-1][j-1]+1;
                    if(arr[i][j]>max)
                    {
                        max=arr[i][j];
                        index=len-j;
                    }
                }
                else{
                    arr[i][j]=0;
                }
            }
        }
        System.out.println("Max Length Substring: "+inp.substring(index, index+max)+" :");
    }
}
