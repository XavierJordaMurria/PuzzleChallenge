package com.jorda.puzzle.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class Algorithm implements IAlgorithm {

    abstract public String getAlgorithmName();

    protected ArrayList<String> removeDuplicates(String[] testArr) {
        List<String> textList = Arrays.asList(testArr);
        LinkedHashSet<String> textHst = new LinkedHashSet<>(textList);
        return new ArrayList<>(textHst);
    }

    protected String[] cleanUpText(String txt) {
        return txt.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
    }
}