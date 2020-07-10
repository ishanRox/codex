/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.sensor.Data;

/**
 *
 * @author Acer
 */
public class RMS1 extends Form {

    private Command com_create;
    private Alert alt;

    public void initComponents() {
        com_create = new Command("Create", Command.OK, 0);
        alt = new Alert(null);
        this.addCommand(com_create);

        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == com_create) {
                    try {
                        RecordStore rs = RecordStore.openRecordStore("rs1", true);

                        String x = "10";
                        byte data[] = x.getBytes();
                        
                        for (int i = 0; i < data.length; i++) {
                            System.out.println(data[1]);
                        }
                        int record_id = rs.addRecord(data, 0, data.length);
                        
                        alt.setTitle("success");
                        alt.setString("Record Store:" + record_id);
                        alt.setType(AlertType.INFO);
                        Main.Main.d.setCurrent(alt);

                    } catch (RecordStoreException e) {
                        alt.setTitle("Exception");
                        alt.setString(e.getMessage());
                        alt.setType(AlertType.ERROR);
                        Main.Main.d.setCurrent(alt);
                    }
                }
            }
        });

    }

    public RMS1() {
        super("RMS");
        initComponents();
    }
}
