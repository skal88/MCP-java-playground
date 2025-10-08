package com.albertmula.MCP.playground;

import com.albertmula.MCP.playground.tools.copy_to_clipboard.infra.mcp.MCPCopyToClipboard;
import com.albertmula.MCP.playground.tools.sum_integers.infra.mcp.MCPSumIntegers;
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
	public List<ToolCallback> mcpTools(MCPCopyToClipboard mcpCopyToClipboard, MCPSumIntegers sumIntegers) {
		return List.of(ToolCallbacks.from(
				mcpCopyToClipboard,
				sumIntegers));
	}
}
