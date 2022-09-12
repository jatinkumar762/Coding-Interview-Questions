[Missing Number](https://leetcode.com/problems/missing-number/)

#### Method:1 XOR
* Let x be the desired output elements.
* Calculate XOR of all the array elements.
  - xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]
* XOR the result with all numbers from 1 to n
  - xor1 = xor1^1^2^…..^n
* In the result xor1, all elements would nullify each other except x

```java
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
```

#### Method:2 SUM
```java
public int missingNumber(int[] nums) { //sum
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
```


#### Method:3 Binary Search
```java
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}
```

Summary: If the array is in order, prefer Binary Search method. Otherwise, the XOR method is better.

---

[Find Missing And Repeating](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1)

#### Method:1 - Use Sorting

#### Method:2 - Use count array

#### Method:3 - Use elements as Index and mark the visited places

* Traverse the array. 
* While traversing, use the absolute value of every element as an index and make the value at this index as negative to mark it visited. 
* If something is already marked negative then this is the repeating element. 
* To find missing, traverse the array again and look for a positive value.

```java
static void printTwoElements(int arr[], int size)
{
    int i;
    System.out.print("The repeating element is ");

    for (i = 0; i < size; i++) {
        int abs_val = Math.abs(arr[i]);
        if (arr[abs_val - 1] > 0)
            arr[abs_val - 1] = -arr[abs_val - 1];
        else
            System.out.println(abs_val);
    }

    System.out.print("and the missing element is ");
    for (i = 0; i < size; i++) {
        if (arr[i] > 0)
            System.out.println(i + 1);
    }
}
```

#### Method:4 - Make two equations

* Let x be the missing and y be the repeating element.
* Get the sum of all numbers using formula S = n(n+1)/2 – x + y
* Get product of all numbers using formula P = 1*2*3*…*n * y / x
* The above two steps give us two equations, we can solve the equations and get the values of x and y.

#### Method:5 - Use Map
