https://leetcode.com/problems/online-stock-span/description/


Example &rarr; 100, 80, 60, 70, 60, 75, 85

Output &rarr; 1, 1, 1, 2, 1, 4, 6

* we can observe, when any greater element on left side present, we stop count
* For each element, we can store count of element less than on equal to on its left side
* Bcz when any greater element come, can use this count, no need to traverse till end of left side
* we can use stack
* if small element present, we can remove and add remove element count in current count
* if grater element present, we just push 

#### Fast Solution

```java
class StockSpanner {
    
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
    
        int count = 1 ;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            count+=stack.pop()[1];
        }

        stack.add(new int[]{price, count});

        return count;
    }
}
```

#### Another way to write

```
class StockSpanner {

    class Node {
        int price;
        int count; // less than or equal to

        Node(int p, int c) {
            this.price = p;
            this.count = c;
        }
    }

    Stack<Node> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        Node popped;
        int count = 1; // current day;
        while (!stack.isEmpty() && stack.peek().price <= price) {

            popped = stack.pop();

            count += popped.count;
        }

        stack.push(new Node(price, count));

        return count;
    }
}
```

#### Brute Force

```java
class StockSpanner {

    ArrayList<Integer> priceList;

    public StockSpanner() {
        priceList = new ArrayList<>();   
    }
    
    public int next(int price) {
        
        if(priceList.isEmpty()){
            priceList.add(price);
            return 1;
        }

        int count=1; //include current;

        for(int p : priceList){
            if(p<=price){
                count+=1;
            } else {
                count=1;
            }
        }

        priceList.add(price);

        return count;
    }
}
```