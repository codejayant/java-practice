package com.codejayant.strings;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * @link https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class FrequencySort {

    public static void main(String[] args) {

        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("Aabb"));
        System.out.println(frequencySort("cccaaa"));
    }

    /**
     * sort implementation.
     *
     * @param s input
     * @return string sorted by frequency
     */
    private static String frequencySort(String s) {

        // count and store the character frequencies in a HashMap
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Make a list of keys or characters
        List<Character> characters = new ArrayList<>(counts.keySet());

        // sort the list based on count from map using comparator
//        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));
        characters.sort((a, b) -> counts.get(b) - counts.get(a));

        // build the string back with order from sorted character one by one and count from the count map
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int individualCounts = counts.get(c);
            for (int i = 0; i < individualCounts; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
