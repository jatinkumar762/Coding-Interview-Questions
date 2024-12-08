https://www.youtube.com/watch?v=9GMECGQgWrQ&ab_channel=takeUforward


**Case-1:** PreOrder and PostOrder given

PreOrder  &rarr; 1 2 3

PostOrder &rarr; 3 2 1  

```
      1
    2
  3
```

```
      1
    2
      3
```

Multiple answers possible for binary tree


**Case-2:** InOrder and PreOrder given

InOrder &rarr; 9 3 15 20 7

PreOrder &rarr; 3 9 20 15 7

* PreOrder first element is root, from InOrder we can say, left of 3 is part of left subtree and right elements of 3 are in right subtree
* similarly for next elements of PreOrder

```
      3
  9       20
      15      7
```

* In-Order is very important to create a unique binary tree