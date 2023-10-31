package org.example;

public class AddingBigNumbers {
    /**
     * DESCRIPTION:
     * We need to sum big numbers and we require your help.
     *
     * Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
     *
     * Example
     * add("123", "321"); -> "444"
     * add("11", "99");   -> "110"
     *
     * Notes
     * The input numbers are big.
     * The input is a string of only digits
     * The numbers are positives
     */

    public static String add(String a, String b) {

        // make the string the same length by adding 0s to left end
        if(a.length() < b.length()) {
            a = padIt(a, b.length());
        } else if (b.length() < a.length()) {
            b = padIt(b, a.length());
        }


        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        // sum digits from the rightmost position
        for(int i = a.length()-1; i >= 0; i--) {
            int sum = (int)a.charAt(i) + (int)b.charAt(i) + remainder - 96;
            remainder = 0;
            if(sum > 9) {
                remainder = 1;
                sb.insert(0,  sum - 10);
            } else {
                sb.insert(0, sum);
            }
        }

        // cleanup
        if(remainder != 0) {
            sb.insert(0, remainder);
        }
        while(sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String padIt(String shorter, int length) {
        return "0".repeat(length - shorter.length()) + shorter;
    }
}
