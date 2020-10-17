package com.jorda.puzzle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.jorda.puzzle.Algorithm.IAlgorithm;
import com.jorda.puzzle.Algorithm.VerifyByWordsBasic;
import com.jorda.puzzle.Algorithm.VerifyByWordsBasicMix;
import com.jorda.puzzle.Algorithm.VerifyByWordsCleanUp;
import com.jorda.puzzle.Algorithm.VerifyByWordsCleanUpNoSort;

/**
 * Main App Verify Msg
 *
 */
public class App {
    private String getFileFromResourceAsStream(String fileName) throws IllegalArgumentException {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        String fileStr = "";
        try {
            // the stream holding the file content
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {
                fileStr = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStr;
    }

    private String readFileToString(String fileName) {
        String fileStr = "";
        try {
            System.out.println("getResourceAsStream : " + fileName);
            fileStr = this.getFileFromResourceAsStream(fileName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return fileStr;
    }

    public static void main(String[] args) {
        App app = new App();
        
        String msg = app.readFileToString("msg.txt");
        System.out.println("Msg:" + msg);

        String magazine = app.readFileToString("DON_QUIJOTE_DE_LA_MANCHA.txt");

        App.benchMark(msg, magazine);

        // For large text comparisons
        // App.benchMark(magazine, magazine);
    }

    private static void benchMark(String msg, String text) {
        IAlgorithm[] algorithmsArr = {
            new VerifyByWordsCleanUp(),
            new VerifyByWordsCleanUpNoSort(),
            new VerifyByWordsBasic(),
            new VerifyByWordsBasicMix()
        };

        Verify verify = new Verify(new VerifyByWordsCleanUp());

        for(int i = 0; i < 10; i++){
            for (IAlgorithm algorithm : algorithmsArr) {
                System.out.printf("iteration:%d-------------%s----------------------------\n", i, algorithm.getAlgorithmName());
                verify.changeAlgorithm(algorithm);
                System.out.println(verify.verifyMsg(msg, text));
            }
            System.out.printf("\n\n");
        }
    }
}
