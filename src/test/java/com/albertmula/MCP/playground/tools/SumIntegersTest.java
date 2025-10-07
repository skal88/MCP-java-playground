package com.albertmula.MCP.playground.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumIntegersTest {
    private SumIntegers sut = new SumIntegers();

    @Test
    void sum_2_and_3_should_return_5() {
        Integer result = sut.sum(2, 3);
        assertEquals(5, result);
    }

    @Test
    void sum_12345_and_98765_should_return_111110(){
        Integer result = sut.sum(12345, 98765);
        assertEquals(111110, result);
    }

    @Test
    void sum_negative_values_should_return_correct_value(){
        var result = sut.sum(-1, -2);
        assertEquals(-3, result);
    }
}