package com.jorda.puzzle.Algorithm;

import java.util.Map;

import com.jorda.puzzle.Utils.Utils;

/**
 * VerifyByLetters is an algorithm that given a msg String and a magazine String
 * will split those strings into letters, then it creates a dictionary where the
 * key is a letter and the value is the number of times that the letter appears
 * into the text. To verify the msg, it will be requested that all the entires
 * from the msg dictionary appear into the magazin dictionary and that the
 * values of the msg dictionary are equal or lower than the ones from the
 * magazin dictionary. the letters need to match exaclty i.e. w != W
 */
public class VerifyByLettersOp1 extends Algorithm {

    @Override
    public Boolean run(String msg, String magazine) {
        long startTime = System.currentTimeMillis();
        
        if (msg.isEmpty() || magazine.isEmpty()) {
            return false;
        }

        Map<String, Integer> msgDic = Utils.parseTextToMap(msg);
        boolean verified = false;
        String[] magazineArr = magazine.split("");
        int loopLength = magazineArr.length - 1;

        for (int i = 0; i <= loopLength; i++) {
            String c = magazineArr[i];
            Integer counter = msgDic.get(c);

            if (counter == null) {
                continue;
            }

            counter = counter - 1;

            if (counter == 0) {
                msgDic.remove(c);
                // Got enough letters to write msg
                if (msgDic.isEmpty()) {
                    verified = true;
                    System.out
                            .println("[VerifyByLettersOp1] found msg("+msg.length()+"letters) in iteration: " + i + " of " + magazineArr.length);
                    break;
                }
            }else {
                msgDic.put(c, counter);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[VerifyByLettersOp1] Took: " + (endTime - startTime) + "ms.");
        return verified;
    }

    @Override
    public String getAlgorithmName() {
        return VerifyByLettersOp1.class.getName();
    }
}
