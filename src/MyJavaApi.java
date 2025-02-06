import Routes.Hello;
import Routes.PostTest;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyJavaApi {
    public static void main(String[] args) throws IOException {
        new Serve(4000);
    }
}

class Serve{

    private HttpServer server;

    public Serve(int port) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            this.routes(server);
            server.start();
            System.out.println("Server running in http://localhost:" + port);
        }catch (IOException e){
            System.err.println("Error to start server: " + e.getMessage());
        }
    }

    private void routes(HttpServer server){
        server.createContext("/", new Hello());
        server.createContext("/me", new PostTest());
    }
}

