package com.jorda.puzzle.Utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Integer> parseTextToMap(String txt) {
        String[] arr = txt.split("");

        Map<String, Integer> txtDic = new HashMap<String, Integer>();

        for (String c : arr) {
            Integer counter = txtDic.get(c) != null ? txtDic.get(c) : 0;
            counter = counter + 1;
            txtDic.put(c, counter);
        }

        return txtDic;
    }
}
