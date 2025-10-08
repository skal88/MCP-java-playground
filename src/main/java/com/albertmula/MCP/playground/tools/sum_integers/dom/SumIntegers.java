package com.albertmula.MCP.playground.tools.sum_integers.dom;

import org.springframework.stereotype.Service;

@Service
public class SumIntegers {
    public Integer sum( Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Parameters 'a' and 'b' must not be null");
        }

        return a + b;
    }
}
