/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bluetooth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

/**
 *
 * @author Acer
 */
public class client {

    public DataInputStream in;
    public DataOutputStream out;
    private String uuid;
    public boolean status;

    public client(String uuid) {
        this.uuid = uuid;
    }

    public void connect() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {

                    LocalDevice d = LocalDevice.getLocalDevice();
                    final DiscoveryAgent da = d.getDiscoveryAgent();
                    da.startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
                        public void deviceDiscovered(RemoteDevice rd, DeviceClass dc) {
                            try {
                                UUID uuids[] = new UUID[1];
                                UUID uid = new UUID(uuid, false);
                                uuids[0] = uid;
                                da.searchServices(null, uuids, rd, this);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        public void inquiryCompleted(int i) {
                        }

                        public void serviceSearchCompleted(int i, int i1) {
                            status = true;
                        }

                        public void servicesDiscovered(int i, ServiceRecord[] srs) {
                            try {
                                for (int j = 0; j < srs.length; j++) {
                                    String url = srs[j].getConnectionURL(0, false);

                                    StreamConnection sc = (StreamConnection) Connector.open(url);

                                    in = sc.openDataInputStream();
                                    out = sc.openDataOutputStream();

                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
