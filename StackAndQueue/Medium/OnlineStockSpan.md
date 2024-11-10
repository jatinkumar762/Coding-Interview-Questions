https://leetcode.com/problems/online-stock-span/description/


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