import Routes.Hello;
import Routes.PostTest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {

        int PORT = 4000;
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Definindo o endpoints
        server.createContext("/me", new PostTest());

        server.createContext("/", new Hello());



        // Iniciando o servidor
        server.setExecutor(null);
        server.start();

        System.out.println("Server running in http://localhost:" + PORT);
    }

    public class MethodNotSupported implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {
            String response = "{\"message\": \"Not, World!\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(405, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}


