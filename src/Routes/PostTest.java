package Routes;

import Controllers.Error405;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PostTest implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            // Lendo os dados enviados no corpo da requisição
            InputStream inputStream = exchange.getRequestBody();
            String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            // Criando uma resposta simples
            String response = "{\"received\": \"" + body + "\"}";

            // Configurando os cabeçalhos da resposta
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());

            // Enviando a resposta
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }else{
            new Error405().handle(exchange);
        }
    }
}

