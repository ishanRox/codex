/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bluetooth.client;
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
public class FrmClient extends Form {

    public FrmClient() {
        super("Client");
        initComponets();
    }
    private TextField tfText;
    private Command comSerchServer;
    private Command GotoServer;
//    private Command comNext;
    private client client;

    private void initComponets() {

        tfText = new TextField("Text", null, 20, TextField.ANY);
        append(tfText);

        comSerchServer = new Command("Search Sever", Command.OK, 2);
        addCommand(comSerchServer);
        GotoServer = new Command("Send to Server", Command.OK, 1);
        addCommand(GotoServer);
//        comNext = new Command("Next", Command.OK, 0);
//        addCommand(comNext);

        setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == comSerchServer) {
                    //search server
                    client = new client("AABBCDEF0123456789ABCDEF01234567");
                    client.connect();
                    
                    Thread t = new Thread(new Runnable() { //client msg ewanwada ewanda bala bala innwa 
                        public void run() {
                            while (true) {
                                try {
                                    if (client.status) {
                                        Alert a=new Alert("From Client");
                                        a.setType(AlertType.INFO);
                                        a.setString(client.in.readUTF());
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
                    //send to server

                    try {
                        String msg = tfText.getString();
                        client.out.writeUTF(msg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    Main.d.setCurrent(d);
                }
            }
        });

    }
}
