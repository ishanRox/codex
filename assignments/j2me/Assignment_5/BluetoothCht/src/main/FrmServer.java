/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bluetooth.client;
import bluetooth.server;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Acer
 */
public class FrmServer extends Form {

    public FrmServer() {
        super("Server");
        initComponets();

    }
    private TextField tfMEssage;
    private Command comStartSever;
    private Command comToCLient;
    private server server;
    private client client;

    private void initComponets() {
        tfMEssage = new TextField("message", null, 10, TextField.ANY);
        append(tfMEssage);

        comStartSever = new Command("Start Sever", Command.OK, 1);
        addCommand(comStartSever);
        comToCLient = new Command("Send TO Client", Command.OK, 0);
        addCommand(comToCLient);

        setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == comStartSever) {
                    //start sever
                    server = new server("AABBCDEF0123456789ABCDEF01234567", "xyz");
                    server.start();

                    Thread t = new Thread(new Runnable() { //client msg ewanwada ewanda bala bala innwa 
                        public void run() {
                            while (true) {
                                try {
                                    if (server.status) {
                                        Alert a=new Alert("From Client");
                                        a.setType(AlertType.INFO);
                                        a.setString(server.in.readUTF());
                                        Main.d.setCurrent(a);
                                    }
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    t.start();
                } else {
                    //sent to client
                    try {

//                        client = new client("AABBCDEF0123456789ABCDEF01234567");
//                        client.connect();
                        String msg = tfMEssage.getString();
                        server.out.writeUTF(msg);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
