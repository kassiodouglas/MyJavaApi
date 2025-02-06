package Routes;

import Models.RecUser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Users implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "{" + new RecUser("01","Kassio","32165498798").toString() + "}";
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
