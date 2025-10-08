package com.albertmula.MCP.playground.tools.copy_to_clipboard.infra.mcp;

import com.albertmula.MCP.playground.tools.copy_to_clipboard.dom.CopyToClipboardText;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MCPCopyToClipboard {
    private final CopyToClipboardText copyToClipboardText;

    MCPCopyToClipboard(@Autowired CopyToClipboardText copyToClipboardText) {
        this.copyToClipboardText = copyToClipboardText;
    }

    @Tool(name = "copy_to_clipboard", description = "Copies the given text to the clipboard and returns a confirmation message.")
    public String copy(
            @ToolParam(description = "text to copy") String text
    ) {
        return copyToClipboardText.copy(text);
    }
}
