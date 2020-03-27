import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * A simple example to send HTTP request from Java
 *
 */
public class Client {

    public static void main(String args[]) throws IOException {

        callServer();
    }

    private static void callServer() throws IOException {
        URL url = new URL("http://localhost:8500/test");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        callServer();
    }
}