package org.example;

import java.util.Map;
import java.util.stream.Collectors;

public class Scramblies {
    /**
     * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
     * <p>
     * Notes:
     * <p>
     * Only lower case letters will be used (a-z). No punctuation or digits will be included.
     * Performance needs to be considered.
     * Examples
     * scramble('rkqodlw', 'world') ==> True
     * scramble('cedewaraaossoqqyt', 'codewars') ==> True
     * scramble('katas', 'steak') ==> False
     */

    public static boolean scramble(String str1, String str2) {
        Map<Character, Long> letterCount1 = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> letterCount2 = str2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        for (Map.Entry<Character, Long> entry : letterCount2.entrySet()) {
            Character key = entry.getKey();
            Long value1 = entry.getValue();
            Long value2 = letterCount1.get(key);
            if (value2 == null || value2.compareTo(value1) < 0) {
                return false;
            }
        }
        return true;
        }
    }
