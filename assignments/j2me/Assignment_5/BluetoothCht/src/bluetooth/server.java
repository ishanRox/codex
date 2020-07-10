/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetooth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

/**
 *
 * @author Acer
 */
public class server {

    private String url;
    public DataInputStream in;
    public DataOutputStream out;
    public boolean status;

    public server(String uuid, String servicename) {
        url = "btspp://localhost:" + uuid + ";name=" + servicename;
    }

    public void start() {
        Thread t = new Thread(new Runnable() {
            public void run() {

                try {
                    LocalDevice d = LocalDevice.getLocalDevice();
                    d.setDiscoverable(DiscoveryAgent.GIAC);
                    StreamConnectionNotifier scn = (StreamConnectionNotifier) Connector.open(url);
                    StreamConnection sc=scn.acceptAndOpen();
                    System.out.println("Server started");
                    
                    in=sc.openDataInputStream();
                    out=sc.openDataOutputStream();
                    
                    status=true;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        t.start();
        
        
    }
}
