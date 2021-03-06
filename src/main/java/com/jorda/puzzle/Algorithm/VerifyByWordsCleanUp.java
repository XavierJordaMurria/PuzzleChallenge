package com.jorda.puzzle.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * VerifyByWordsCleanUp is an algorithm that given a msg String and a magazine String
 * will split those strings into words.
 * Also to optimize the search all the duplicates are being removed and sort the result
 */
public class VerifyByWordsCleanUp extends Algorithm {

    @Override
    public Boolean run(String msg, String magazine) {
        long startTime = System.currentTimeMillis();

        if (msg.isEmpty() || magazine.isEmpty()) {
            return false;
        }

        ArrayList<String> matched = new ArrayList<String>();
        String[] msgWords = this.cleanUpText(msg);
        String[] magazineWords = this.cleanUpText(magazine);

        ArrayList<String> msgWordsListWithoutDuplicates = this.removeDuplicates(msgWords);
        ArrayList<String> magazineWordsListWithoutDuplicates = this.removeDuplicates(magazineWords);

        // sort the array to increase the comparison speed Arrays.sort
        // uses Dual-Pivot Quicksort algorithm O(n log(n))
        Collections.sort(msgWordsListWithoutDuplicates);
        Collections.sort(magazineWordsListWithoutDuplicates);

        if (msgWords.length > magazineWords.length) {
            return false;
        }

        for (String msgWord : msgWordsListWithoutDuplicates) {
            for (String magazineWord : magazineWordsListWithoutDuplicates) {
                if (msgWord.equals(magazineWord)) {
                    matched.add(msgWord);
                    break;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[VerifyByWordsCleanUp] Took: " + (endTime - startTime) + "ms.");
        return matched.size() == msgWordsListWithoutDuplicates.size();
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByWordsCleanUp.class.getName();
    }
}
