package com.andreas.urlsimilarity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

/**
 *
 * @author Andreas Galanomatis
 * Utility methods used for calculating Jaccard index
 */
class WordUtils {
    
    /**
     * Get set of unique words in a string excluding non-alphanumeric characters
     * @param text The string
     * @return Set of unique strings
     */
    public Set<String> getWordSet(String text) {
        List<String> words = Arrays.asList(text.split("\\s+"));       
        return words
                .stream()
                .map(s -> filterAlphabetic(s))
                .collect(Collectors.toCollection(HashSet::new));  
    }
    
    public String filterAlphabetic(String s) {
        return s.codePoints()
                .filter(c -> Character.isLetterOrDigit(c))
                .collect(StringBuilder::new,
                         StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    
    /**
     * Compares two strings using the Jaccard index
     * @param string1
     * @param string2
     * @return
     */
    public float compareStrings(String string1, String string2) {
        return calculateJaccardIndex(
                getWordSet(string1),
                getWordSet(string2));
    }
    
    /**
     * Calculate the Jaccard index of two sets
     * @param set1
     * @param set2
     * @return
     */
    public float calculateJaccardIndex(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        return (float)intersection.size()/union.size();
    }
}
