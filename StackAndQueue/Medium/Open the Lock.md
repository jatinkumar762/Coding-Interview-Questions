[Leetcode - Open the Lock](https://leetcode.com/problems/open-the-lock/)

```java
class Solution {
    public int openLock(String[] deadends, String target) {
        
        String start = "0000";
        
        if(start.equals(target))
            return 0;
        
        Set<String> setDeadEnds = new HashSet<>(Arrays.asList(deadends));
        
        if(setDeadEnds.contains(start))
            return -1;
            
        Set<String> alreadyVisisted = new HashSet<String>();
        
        LinkedList<String> queue = new LinkedList<String>();
        
        queue.add(start);
        
        int level = 0;
        while(queue.size()>0)
        {
            int size = queue.size();
            for(int s=0;s<size;s++){
                String newStr = queue.poll();
                if(!alreadyVisisted.contains(newStr))
                {
                    alreadyVisisted.add(newStr);
                    for(int i=0;i<4;i++){
                        char c = newStr.charAt(i);
                        String s1 = newStr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + newStr.substring(i + 1);
                        String s2 = newStr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + newStr.substring(i + 1);
                        
                        if(s1.equals(target) || s2.equals(target))
                            return level+1;
                        
                        if(!setDeadEnds.contains(s1))
                            queue.add(s1);
                        
                        if(!setDeadEnds.contains(s2))
                            queue.add(s2);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
```