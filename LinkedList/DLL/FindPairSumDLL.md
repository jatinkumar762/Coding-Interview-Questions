https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

#### Approach-1: if DLL is not sorted

```java
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tmp;
        Set<Integer> set = new HashSet<>();
        while(head!=null){
            if(!set.isEmpty() && set.contains(target - head.data)){
                    tmp = new ArrayList<>();
                    tmp.add(target - head.data);
                    tmp.add(head.data);
                    result.add(tmp);
            }
            set.add(head.data);   
            head = head.next;
        }
        return result;
    }
}
```

#### Approach-2: If DLL is sorted given, we can use two pointer approach

```java
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tmp;
        
        Node left=head, right=head;
        while(right.next!=null){
            right = right.next;
        }
        
        while(left!=right && left.prev!=right){
            if(left.data+right.data == target){
                tmp = new ArrayList<>();
                tmp.add(left.data);
                tmp.add(right.data);
                result.add(tmp);
                
                left = left.next;
                right = right.prev;
            }
            else if(left.data+right.data < target){
                left = left.next;
            }
            else {
                right = right.prev;
            }
        }
        return result;
    }
}
```
