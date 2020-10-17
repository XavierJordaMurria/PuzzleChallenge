package com.jorda.puzzle.Algorithm;

public interface IAlgorithm {
    /**
     * 
     * @param msg Message String to be validated 
     * @param magazine Magazine String where to validate the msg
     * @return true (your partner contacted you) or false (the enemy is at the gates)
     */
    public Boolean run(String msg, String magazine);

    public String getAlgorithmName();
}
