[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

```java
class Solution 
{
    public boolean isValid(String s) 
    {
        
            int len=s.length();
	        
            if(len%2!=0)
                return false;
            
	        char ch[]=s.toCharArray();
	        char stack[]=new char[len];
	        int top=-1;
	        int i=0;
	        boolean flag=false;
            for(i=0;i<len;i++)
            {
                flag=false;
                switch(ch[i])
                {
                    case '{':stack[++top]=ch[i];
                             break;
                    case '[':stack[++top]=ch[i];
                            break;
                    case '(':stack[++top]=ch[i];
                            break;
                    case '}':if(top<0 || (top>=0 && stack[top]!='{')){flag=true;}
                             --top; break;
                    case ']':if(top<0 || (top>=0 && stack[top]!='[')){flag=true;}
                            --top; break;
                    case ')':if(top<0 || (top>=0 && stack[top]!='(')){flag=true;}
                            --top; break;
                }
                if(flag)
                    break;
            }
	        
	        if(top==-1 && i==len)
	            return true;
	        else
	            return false;
        
    }
}
```