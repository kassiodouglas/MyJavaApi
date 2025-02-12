package Controllers.Errors;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Error405 {
    public void handle(HttpExchange exchange) throws IOException {
        String response = "{" +
                "\"message\": \"Method not supported\"," +
                "\"code\": \"405\"" +
                "}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(405, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
