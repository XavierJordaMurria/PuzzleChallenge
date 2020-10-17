package com.jorda.puzzle;

import com.jorda.puzzle.Algorithm.IAlgorithm;

public class Verify {
    private IAlgorithm algorithm;

    public Verify(IAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public void changeAlgorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Boolean verifyMsg(String msg, String magazine)
    {
        return this.algorithm.run(msg, magazine);
    }
}
