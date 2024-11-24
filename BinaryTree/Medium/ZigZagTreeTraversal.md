
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

### Optimized Code

```java

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return result;
        }

				List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        int count = 1;
        int newCount = 0;
        queue.add(root);

				boolean odd = true;

        while (!queue.isEmpty()) {

            List<Integer> levelResult = new LinkedList<>();

						//instead of newCount
						//we can initialize count = queue.size()

            for (int i = 0; i < count; i++) {

                TreeNode tmp = queue.poll();

                if (odd) {
                    levelResult.add(tmp.val);
                } else {
                    levelResult.addFirst(tmp.val);
                }

                if (tmp.left != null) {
                    queue.add(tmp.left);
                    newCount++;
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                    newCount++;
                }

            }

            count = newCount;
            newCount = 0;
            odd = !odd;

            result.add(levelResult);
        }

        return result;
    }
}
```

### Approach-2

```java

//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    int level=1;
	    LinkedList<Node> queue=new LinkedList<Node>();
	    ArrayList<Integer> result=new ArrayList<Integer>();
	    
	    
	    queue.add(root);
	    int count=1;
	    Node data;
	    while(queue.size()>0)
	    {
	        int tmp=0;
	        
	        if(level%2==0)
	        {
	            //pick values from rear of linkedlist
	            for(int i=1;i<=count;i++)
	            {
	                data=queue.poll();
	                result.add(data.data);
	                if(data.right!=null)
	                {
	                    queue.add(data.right);
	                    tmp+=1;
	                }
	                if(data.left!=null)
	                {
	                    queue.add(data.left);
	                    tmp+=1;
	                }
	                
	            }
	            
	        }
	        else{
	            
	            //pick values from front of linkedlist
	            for(int i=1;i<=count;i++)
	            {
	                data=queue.pollLast();
	                result.add(data.data);
	                if(data.left!=null)
	                {
	                    queue.addFirst(data.left);
	                    tmp+=1;
	                }
	                if(data.right!=null)
	                {
	                    queue.addFirst(data.right);
	                    tmp+=1;
	                }
	   
	            }
	            
	        }
	        count = tmp;
	        level+=1;
	    }
	    return result;
	}
}
```
