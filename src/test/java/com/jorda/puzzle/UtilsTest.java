package com.jorda.puzzle;

import static org.junit.Assert.*;

import java.util.Map;
import static java.util.Map.entry;
import com.jorda.puzzle.Utils.Utils;

import org.junit.Test;

public class UtilsTest {
    
        /**
     * Msg exist
     */
    @Test
    public void parseTextToMap()
    {
        String msg = "Hello World!";
        Map<String, Integer> msgDic = Utils.parseTextToMap(msg);
        Map<String, Integer> expectedMap = Map.ofEntries(
            entry(" ",1),
            entry("!",1),
            entry("r",1),
            entry("d",1),
            entry("e",1),
            entry("W",1),
            entry("H",1),
            entry("l",3),
            entry("o",2)
        );

        msgDic.forEach((k,v)->{
            Integer expectedVal = expectedMap.get(k);
            assertTrue(v == expectedVal);
        });
    }
}
