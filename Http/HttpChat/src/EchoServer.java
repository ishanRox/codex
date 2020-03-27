
import java.io.*;
import java.net.*;
import javax.net.ServerSocketFactory;
import javax.net.ssl.*;

public class EchoServer {

    public static final int HTTPS_PORT = 8282;
    public static final String KEYSTORE_LOCATION = "src/myKeyStore.jks";
    public static final String KEYSTORE_PASSWORD = "123456";

    // main program
    public static void main(String argv[]) throws Exception {

        // set system properties, alternatively you can also pass them as
        // arguments like -Djavax.net.ssl.keyStore="keystore"....
        System.setProperty("javax.net.ssl.keyStore", KEYSTORE_LOCATION);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);
        System.setProperty("javax.net.debug", "ssl:record");

        EchoServer server = new EchoServer();
        server.startServer();
    }

    // Start server
    public void startServer() {
        try {
            ServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serversocket = (SSLServerSocket) ssf.createServerSocket(HTTPS_PORT);

            while (true) {
                Socket client = serversocket.accept();
                ProcessRequest cc = new ProcessRequest(client);
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }
}

class ProcessRequest extends Thread {

    Socket client;
    BufferedReader is;
    PrintWriter out ;


    public ProcessRequest(Socket s) { // constructor
        client = s;
        try {
            is = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        this.start(); // Thread starts here...this start() will call run()
    }

    public void run() {
        try {
            // get a request and parse it.
            String request = is.readLine();
            System.out.println("Received from Client: " + request);
            try {

                out.write("HTTP/1.0 200 OK\r\n");
                out.write("Server: Apache/0.8.4\r\n");
                out.write("Content-Type: text/html\r\n");
                out.write("Content-Length: 1000\r\n");
                out.write("\r\n");
                out.write("<TITLE>I am Secured</TITLE>");
                out.write("<P>Hi Client</P>");

                out.write("<h1>Server Page: Hope you are Reading this !</h1>\r\n");
                out.write("<body><b/><p>Client sent: \r\n");
                out.write(request + "</p></body></html>\r\n");

                out.flush();
            } catch (Exception e) {
                out.write("HTTP/1.0 200 OK\r\n");
                out.write("Server: Apache/0.8.4\r\n");
                out.write("HTTP/1.0 400 " + e.getMessage() + "\r\n");
                out.write("\r\n");
                out.flush();
            } finally {
                out.close();
            }
            client.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
