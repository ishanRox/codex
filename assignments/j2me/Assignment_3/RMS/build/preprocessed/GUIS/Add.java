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
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author VSD
 */
public class Add extends Form {

    private TextField tf_1;
    private Command com_add;
    private Command com_view;
    private Command com_delete;
    private Alert alt;

    
    public void initComponets() {
        tf_1 = new TextField("NAme", null, 20, TextField.ANY);
        this.append(tf_1);
        alt = new Alert(null);
        com_delete = new Command("Delete", Command.OK, 1);
        com_view = new Command("View", Command.OK, 0);
        com_add = new Command("Add", Command.OK, 2);
        this.addCommand(com_add);
        this.addCommand(com_view);
        this.addCommand(com_delete);
        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == com_add) {

                    try {

                        RecordStore rs = RecordStore.openRecordStore("user_rs", true);
                        String name = tf_1.getString();
                        byte data[] = name.getBytes();
                        int record_id = rs.addRecord(data, 0, data.length);

                        alt.setType(AlertType.INFO);
                        alt.setTitle("success");
                        alt.setString("New Name addes:" + name + "ID:" + record_id);
                        Main.Main.d.setCurrent(alt);

                    } catch (RecordStoreException e) {
                        alt.setTitle("Exception");
                        alt.setString(e.getMessage());
                        alt.setType(AlertType.ERROR);
                        Main.Main.d.setCurrent(alt);
                    }
                } else if (c == com_view) {
                    try {
                        RecordStore rs = RecordStore.openRecordStore("user_rs", false);
                        String all = "";
                        for (int i = 1; i < rs.getNextRecordID(); i++) {
                            try {
                                byte data[] = rs.getRecord(i);
                                String name = new String(data);
                                all += name + " ";
                            } catch (Exception e) {
                            }
                        }
                        alt.setType(AlertType.INFO);
                        alt.setTitle("Name List");
                        alt.setString(all);
                        Main.Main.d.setCurrent(alt);
                        rs.closeRecordStore();


                    } catch (Exception e) {
                        alt.setTitle("Exception");
                        alt.setString(e.getMessage());
                        alt.setType(AlertType.ERROR);
                        Main.Main.d.setCurrent(alt);
                    }
                } else if (c == com_delete) {
                    //delete user
                    String text = tf_1.getString();
                    try {
                        RecordStore rs = RecordStore.openRecordStore("user_rs", false);

                        for (int i = 1; i < rs.getNextRecordID(); i++) {
                            try {
                                byte data[] = rs.getRecord(i);
                                String name = new String(data);

                                if (text.equals(name)) {
                                    rs.deleteRecord(i);
                                    alt.setType(AlertType.INFO);
                                    alt.setTitle("Delete Name");
                                    alt.setString(name);
                                    Main.Main.d.setCurrent(alt);
                                    break;
                                }
                            } catch (Exception e) {
                            }

                        }



                    } catch (Exception e) {
                        alt.setTitle("Exception");
                        alt.setString(e.getMessage());
                        alt.setType(AlertType.ERROR);
                        Main.Main.d.setCurrent(alt);
                    }
                }

            }
        });

    }

    public Add() {
        super("Add");
        initComponets();
    }
}
