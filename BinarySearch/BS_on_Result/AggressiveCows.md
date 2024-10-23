* https://www.naukri.com/code360/problems/aggressive-cows_1082559
* https://www.spoj.com/problems/AGGRCOW/
* https://www.geeksforgeeks.org/problems/aggressive-cows/0


Aggressive cows &rarr; max of (min distance between cows)

arr[] = [1 2 4 8], cows = 3


arr[] &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 1 &emsp; 2 &emsp; 4 &emsp; 8

combination-1 &emsp; c1  &emsp; c2 &emsp; c3

(c1, c2) &rarr; 1; (c1, c3) &rarr; 3 ; (c2, c3) &rarr; 2  

min of all dist  &rarr; 1

if array is sorted, &rarr; no need to compare (c1, c3) when we are finding min

similarly other combinations possible, where can put cow at different indexes

after all combination, we need to find max of all combinations

Max ( comb-1, comb2, ...)