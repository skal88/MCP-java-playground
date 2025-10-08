package com.albertmula.MCP.playground.tools.sum_integers.infra.mcp;

import com.albertmula.MCP.playground.tools.sum_integers.dom.SumIntegers;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MCPSumIntegers {
    private final SumIntegers sumIntegers;

    MCPSumIntegers(@Autowired SumIntegers sumIntegers) {
        this.sumIntegers = sumIntegers;
    }

    @Tool(name = "sum_integers", description = "Sum two integers")
    public Integer sum(
            @ToolParam(description = "first number") Integer a,
            @ToolParam(description = "second number") Integer b
    ) {
        return sumIntegers.sum(a, b);
    }
}
