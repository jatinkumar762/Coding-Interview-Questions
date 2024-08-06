https://leetcode.com/problems/online-stock-span/description/


#### Fast Solution

```java
class StockSpanner {
    
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        if(stack.isEmpty()){
            stack.add(new int[]{price, 1});
            return 1;
        } 


        int count = 1 ;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            count+=stack.pop()[1];
        }

        stack.add(new int[]{price, count});

        return count;
    }
}
```

#### Slow but same approach

```
class StockSpanner {
    
    Stack<Pair<Integer,Integer>> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        
        if(stack.isEmpty()){
            stack.add(new Pair(price, 1));
            return 1;
        } 


        int count = 1 ;
        while(!stack.isEmpty() && stack.peek().getKey() <= price){
            count+=stack.pop().getValue();
        }

        stack.add(new Pair(price, count));

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