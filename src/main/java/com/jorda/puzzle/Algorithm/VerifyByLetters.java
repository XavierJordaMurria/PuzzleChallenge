package com.jorda.puzzle.Algorithm;

import java.util.Map;

import com.jorda.puzzle.Utils.Utils;

/**
 * VerifyByLetters is an algorithm that given a msg String and a magazine String
 * will split those strings into letters, then it creates a dictionary where the key is a letter
 * and the value is the number of times that the letter appears into the text.
 * To verify the msg, it will be requested that all the entires from the msg dictionary appear into
 * the magazin dictionary and that the values of the msg dictionary are equal or lower than the ones 
 * from the magazin dictionary. the letters need to match exaclty i.e. w != W
 */
public class VerifyByLetters extends Algorithm {

    @Override
    public Boolean run(String msg, String magazine) {
        long startTime = System.currentTimeMillis();

        if (msg.isEmpty() || magazine.isEmpty()) {
            return false;
        }

        Map<String, Integer> msgDic = Utils.parseTextToMap(msg);
        Map<String, Integer> magazineDic = Utils.parseTextToMap(magazine);

        boolean verified = true;

        for (Map.Entry<String, Integer> entry : msgDic.entrySet()) {
            String key = entry.getKey();
            if (magazineDic.get(key) == null) {
                verified = false;
                break;
            }

            Integer expectedVal = magazineDic.get(key);
            if (entry.getValue() > expectedVal) {
                verified = false;
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[VerifyByLetters] Took: " + (endTime - startTime) + "ms.");
        return verified;
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByLetters.class.getName();
    }
}
