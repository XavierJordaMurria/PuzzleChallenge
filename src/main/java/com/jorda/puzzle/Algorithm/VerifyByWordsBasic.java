package com.jorda.puzzle.Algorithm;

import java.util.ArrayList;

/**
 * VerifyByWordsBasic is an algorithm that given a msg String and a magazine
 * String will split those strings into words and try to find all the msg's
 * words into the magazine words.
 */
public class VerifyByWordsBasic extends Algorithm {

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

        for (String msgWord : msgWords) {
            for (String magazineWord : magazineWords) {
                if (msgWord.equals(magazineWord)) {
                    matched.add(msgWord);
                    break;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[VerifyByWordsBasic] Took: " + (endTime - startTime) + "ms.");
        return matched.size() == msgWords.length;
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByWordsBasic.class.getName();
    }
}
