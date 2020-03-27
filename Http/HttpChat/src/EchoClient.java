import javax.net.ssl.*;
import java.io.*;
//import java.security.GeneralSecurityException;
//import java.security.cert.X509Certificate;

public class EchoClient {

    public static final int HTTPS_PORT = 8282;
    public static final String HTTPS_HOST = "localhost";
    public static final String TRUSTTORE_LOCATION = "src/myKeyStore.jks";

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);
        System.setProperty("javax.net.ssl.trustStorePassword", "1234567");
        System.setProperty("javax.net.debug", "ssl:record");

        SSLSocketFactory f = null;

        f = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            SSLSocket c = (SSLSocket) f.createSocket(HTTPS_HOST, HTTPS_PORT);
            c.startHandshake();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
            BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String msg = "Hey, here is client, how are you?";
            w.write(msg, 0, msg.length());
            w.newLine();
            w.flush();

            // now read the socket
            String m = null;
            while ((m = r.readLine()) != null) {
                System.out.println(m);
            }

        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }
}
