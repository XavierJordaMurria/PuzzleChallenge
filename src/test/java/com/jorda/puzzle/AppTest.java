package com.jorda.puzzle;

import static org.junit.Assert.*;

import com.jorda.puzzle.Algorithm.IAlgorithm;
import com.jorda.puzzle.Algorithm.VerifyByLetters;
import com.jorda.puzzle.Algorithm.VerifyByWordsBasic;
import com.jorda.puzzle.Algorithm.VerifyByWordsBasicMix;
import com.jorda.puzzle.Algorithm.VerifyByWordsCleanUp;
import com.jorda.puzzle.Algorithm.VerifyByWordsCleanUpNoSort;

import org.junit.Test;

/**
 * Unit test
 */
public class AppTest 
{
    IAlgorithm[] algorithmsArr = {
        new VerifyByWordsCleanUp(),
        new VerifyByWordsCleanUpNoSort(),
        new VerifyByWordsBasic(),
        new VerifyByWordsBasicMix(),
        new VerifyByLetters()
    };

    /**
     * Msg exist
     */
    @Test
    public void msgExist()
    {

        String msg = "Hello World!";
        String text = "Hello Mark, the World is very big!";

        Verify verify = new Verify(new VerifyByWordsCleanUp());

        for(int i = 0; i < 10; i++){
            for (IAlgorithm algorithm : algorithmsArr) {
                System.out.printf("iteration:%d-------------%s----------------------------\n", i, algorithm.getAlgorithmName());
                verify.changeAlgorithm(algorithm);
                assertTrue( verify.verifyMsg(msg, text) );
            }
            System.out.printf("\n\n");
        }
        
    }

        /**
     * Msg exist
     */
    @Test
    public void msgExistDuplicateWords()
    {

        String msg = "Hello, hello hello World!";
        String text = "Hello Mark!, the World is very big hello hello";

        Verify verify = new Verify(new VerifyByWordsCleanUp());

        for(int i = 0; i < 10; i++){
            for (IAlgorithm algorithm : algorithmsArr) {
                System.out.printf("iteration:%d-------------%s----------------------------\n", i, algorithm.getAlgorithmName());
                verify.changeAlgorithm(algorithm);
                assertTrue( verify.verifyMsg(msg, text) );
            }
            System.out.printf("\n\n");
        }
        
    }

    /**
     * Msg exist
     */
    @Test
    public void msgDoesNotExist()
    {

        String msg = "Good afternoon Hello";
        String text = "Hello Mark, the world is very big";

        Verify verify = new Verify(new VerifyByWordsCleanUp());

        for(int i = 0; i < 10; i++){
            for (IAlgorithm algorithm : algorithmsArr) {
                System.out.printf("iteration:%d-------------%s----------------------------\n", i, algorithm.getAlgorithmName());
                verify.changeAlgorithm(algorithm);
                assertFalse( verify.verifyMsg(msg, text) );
            }
            System.out.printf("\n\n");
        }
        
    }
}
