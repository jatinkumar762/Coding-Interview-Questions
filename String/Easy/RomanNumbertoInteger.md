https://leetcode.com/problems/roman-to-integer/

* Adding/Subtracting Values
  - If the current value is less than the previous value, it indicates a subtraction situation (like IV, IX).
  - Otherwise, the current value is added to the total.

* in question also written, Roman numerals are usually written largest to smallest from left to right.

```java
class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // Determine whether to add or subtract the current value
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue; // Update the previous value
        }

        return total;
    }
}
```

### Integer to Roman

* https://leetcode.com/problems/integer-to-roman/description/

```java
class Solution {
    public String intToRoman(int num) {
        // Arrays to hold the Roman numerals and their corresponding integer values
        String[] romanNumerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder romanString = new StringBuilder("");
        int quotient;

        for (int i = 0; i < values.length && num > 0; i++) {

            if (values[i] <= num) {

                quotient = num / values[i];

                num = num % values[i];

                romanString.append(romanNumerals[i].repeat(quotient));
            }
        }

        return romanString.toString();
    }
}
```

**another way**

```java
 for (int i = 0; i < values.length && num > 0; i++) {
    while (num >= values[i]) {
        romanString.append(romanNumerals[i]);
        num -= values[i];
    }

}
```