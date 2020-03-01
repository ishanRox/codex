import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class MyHttpHandler {

  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
    HttpContext context = server.createContext("/test");
    context.setHandler(MyHttpHandler::handleRequest);
    server.start();
  }

  private static void handleRequest(HttpExchange exchange) throws IOException {
    System.out.println("inseide request");
    new Thread(() -> {

      try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter");
        String line = scanner.nextLine();
        String response = "Hi there! " + Math.random();
        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        while (true) {
          if(line.equals("close")) {
            break;
          }
        }
        os.write(response.getBytes());
        os.close();

      } catch (Exception e) {
        e.printStackTrace();
      }

    }).start();

  }
}