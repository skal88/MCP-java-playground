# MCP-Test

This is a sample project demonstrating the use of Spring AI with MCP (Model Context Protocol).

## What is MCP?

MCP (Model Context Protocol) is a protocol that allows language models to interact with external tools and services. It defines a standard way for models to discover the capabilities of a tool, execute operations, and handle the results.

## Technologies Used

*   Java
*   Spring Boot
*   Spring AI
*   Maven

## How to Run the Project

1.  Package the application into a JAR file:

    ```bash
    ./mvnw clean package
    ```

2.  Run the generated JAR file:

    ```bash
    java -jar target/MCP-Test-0.0.1-SNAPSHOT.jar
    ```

## How to Configure MCP Clients

You can configure your MCP client to connect to this server. Here is an example configuration for a client:

```json
{
    "mcpServers": {
        "default-server": {
            "command": "<path-to-your-java-executable>",
            "args": [
                "-jar",
                "<path-to-your-jar>/MCP-Test-0.0.1-SNAPSHOT.jar"
            ],
            "env": {}
        }
    }
}
```

Replace `<path-to-your-jar>` with the absolute path to the generated JAR file.
To find the full path to your Java executable, run the following command in your terminal:
*   **macOS / Linux:** `which java`
*   **Windows:** `where java`

## How to Configure MCP in IntelliJ

You can configure MCP servers directly in IntelliJ to use them with Gemini Code Assist.

1.  **Create `mcp.json` file:** Create a file named `mcp.json` in your IntelliJ configuration directory.

2.  **Find your configuration directory:** The location of this directory depends on your operating system. You can find the exact path in the [JetBrains documentation](https://intellij-support.jetbrains.com/hc/en-us/articles/206544519-Directories-used-by-the-IDE-to-store-settings-caches-plugins-and-logs).

3.  **Add server configuration:** Add the configuration for your MCP server to the `mcp.json` file. For this project, the configuration would look like this:

    ```json
    {
        "mcpServers": {
            "mcp-java-playground": {
                "command": "<path-to-your-java-executable>",
                "args": [
                    "-jar",
                    "<path-to-your-jar>/MCP-Test-0.0.1-SNAPSHOT.jar"
                ],
                "env": {}
            }
        }
    }
    ```

    Replace `<path-to-your-jar>` with the absolute path to the generated JAR file.
    To find the full path to your Java executable, run the following command in your terminal:
    *   **macOS / Linux:** `which java`
    *   **Windows:** `where java`

For more detailed information, you can refer to the [official Gemini Code Assist documentation](https://developers.google.com/gemini-code-assist/docs/use-agentic-chat-pair-programmer?hl=es-419#configure-mcp-servers).

## How to Debug

You can use the MCP Inspector to debug the communication between the model and the tools.
To start the inspector, run the following command in a separate terminal:

```bash
npx @modelcontextprotocol/inspector
```

Then, you can connect to the MCP server from the inspector to see the requests and responses in real-time.

## How to Run the Tests

To run the tests, you can use the following command:

```bash
./mvnw clean test
```