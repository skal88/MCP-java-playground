package com.albertmula.MCP.playground;

import com.albertmula.MCP.playground.mcp.McpTools;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpPlaygroundApplication.class, args);
	}

	@Bean
	public List<ToolCallback> firstTestTool(McpTools mcpTools) {
		return List.of(ToolCallbacks.from(mcpTools));
	}
}
