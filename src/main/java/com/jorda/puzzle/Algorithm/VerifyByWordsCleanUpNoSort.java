package com.jorda.puzzle.Algorithm;

import java.util.ArrayList;

/**
 * VeryfyByWords is an algorithm that given a msg String and a magazine String
 * will split those strings into words and try to find all the msg's words into
 * the magazine words. Also to
 * optimize the search all the duplicates are being removed
 */
public class VerifyByWordsCleanUpNoSort extends Algorithm {

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
        System.out.println("[VerifyByWordsCleanUpNoSort] Took: " + (endTime - startTime) + "ms.");
        return matched.size() == msgWordsListWithoutDuplicates.size();
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByWordsCleanUpNoSort.class.getName();
    }
}
