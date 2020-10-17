package com.jorda.puzzle.Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 * VerifyByWordsBasic is an algorithm that given a msg String and a magazine
 * String will split those strings into words and try to find all the msg's
 * words into the magazine words.
 */
public class VerifyByWordsBasicMix extends Algorithm {

    @Override
    public Boolean run(String msg, String magazine) {
        long startTime = System.currentTimeMillis();

        if (msg.isEmpty() || magazine.isEmpty()) {
            return false;
        }

        ArrayList<String> matched = new ArrayList<String>();
        String[] msgWords = this.cleanUpText(msg);
        String[] magazineWords = this.cleanUpText(magazine);

        if (msgWords.length > magazineWords.length) {
            return false;
        }

        ArrayList<String> magazineWordsListWithoutDuplicates = this.removeDuplicates(magazineWords);
        Collections.sort(magazineWordsListWithoutDuplicates);

        for (String msgWord : msgWords) {
            for (String magazineWord : magazineWordsListWithoutDuplicates) {
                if (msgWord.equals(magazineWord)) {
                    matched.add(msgWord);
                    break;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[VerifyByWordsBasicMix] Took: " + (endTime - startTime) + "ms.");
        return matched.size() == msgWords.length;
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByWordsBasicMix.class.getName();
    }
}
