package handler;

import Controllers.Errors.Error405;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public abstract class AbstractHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method = exchange.getRequestMethod();

        switch (method){
            case "GET": handleGet(exchange); break;
            case "POST": handlePost(exchange); break;
            case "PUT": handlePut(exchange); break;
            case "DELETE": handleDelete(exchange); break;
            default: new Error405().handle(exchange); break;
        }
    }

    private void handleGet(HttpExchange exchange)throws IOException{
        String response = processBody(null);
        sendResponse(exchange, response);
    }
    private void handlePost(HttpExchange exchange)throws IOException{
        String body = readRequest(exchange);
        String response = processBody(body);
        sendResponse(exchange, response);
    }
    private void handlePut(HttpExchange exchange)throws IOException{
        String body = readRequest(exchange);
        String response = processBody(body);
        sendResponse(exchange, response);
    }
    private void handleDelete(HttpExchange exchange)throws IOException{
        String response = processBody(null);
        sendResponse(exchange, response);
    }

    private String readRequest(HttpExchange exchange) throws IOException{
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException{
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    protected abstract String processBody(String body);

}
