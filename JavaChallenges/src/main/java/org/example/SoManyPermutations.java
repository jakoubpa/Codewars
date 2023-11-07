package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * In this kata, your task is to create all permutations of a non-empty input string and remove duplicates, if present.
 *
 * Create as many "shufflings" as you can!
 *
 * Examples:
 *
 * With input 'a':
 * Your function should return: ['a']
 *
 * With input 'ab':
 * Your function should return ['ab', 'ba']
 *
 * With input 'abc':
 * Your function should return ['abc','acb','bac','bca','cab','cba']
 *
 * With input 'aabb':
 * Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
 * Note: The order of the permutations doesn't matter.
 *
 * Good luck!
 */
public class SoManyPermutations {
    public static List<String> singlePermutations(String s) {
        List<String> results = new ArrayList<>();
        permute("", s, results);
        return results;
    }


    private static void permute(String current, String remaining, List<String> results) {
        if(remaining.isEmpty() && !results.contains(current)) {
            results.add(current);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String stringWithoutIndex = remaining.substring(0, i) + remaining.substring(i + 1);
                permute(current + remaining.charAt(i), stringWithoutIndex, results);
            }
        }
    }

}
