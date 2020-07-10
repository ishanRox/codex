/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import Main.Main;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;
import javax.microedition.m3g.Image2D;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.sensor.Data;

/**
 *
 * @author VSD
 */
public class SignUP extends Form {
    
    private TextField tf_nic;
    private TextField tf_name;
    private TextField tf_username;
    private TextField tf_password;
    private ChoiceGroup cg_1;
    private Command com_signup;
    private Command com_signin;
    private Alert alt;
    
    public void clear(){
        tf_nic.setString(null);
        tf_name.setString(null);
        tf_password.setString(null);
        tf_username.setString(null);
        cg_1.setSelectedIndex(0, true);
    }
    
    public void initCOmponets() {
        
        alt = new Alert(null);
        tf_nic = new TextField("NIC", null, 10, TextField.ANY);
        tf_name = new TextField("Name", null, 20, TextField.ANY);
        tf_username = new TextField("Username", null, 10, TextField.ANY);
        tf_password = new TextField("Password", null, 10, TextField.ANY);
        this.append(tf_nic);
        this.append(tf_name);
        this.append(tf_username);
        this.append(tf_password);
        
        String[] i = {"Sri Lanka", "USA", "CANDA"};
        Image arr_image[] = new Image[3];
        try {
            arr_image[0] = Image.createImage("//Icons/s.png");
            arr_image[1] = Image.createImage("//Icons/u.png");
            arr_image[2] = Image.createImage("//Icons/c.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cg_1 = new ChoiceGroup("Country", ChoiceGroup.POPUP, i, arr_image);
        this.append(cg_1);
        
        com_signup = new Command("Sign Up", Command.OK, 0);
        com_signin = new Command("Sign In", Command.OK, 1);
        this.addCommand(com_signup);
        this.addCommand(com_signin);
        
        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == com_signup) {
                    try {
                        String nic = tf_nic.getString();
                        String name = tf_name.getString();
                        String username = tf_username.getString();
                        String password = tf_password.getString();
                        String country = cg_1.getString(cg_1.getSelectedIndex());
                        
                        RecordStore rs = RecordStore.openRecordStore("user_rs", true);
                        
//                        String user_data = nic + "," + name + "," + username + "," + password + "," + country;
                        
                        ByteArrayOutputStream baos=new ByteArrayOutputStream();
                        DataOutputStream dos=new DataOutputStream(baos);
                        dos.writeUTF(nic);
                        dos.writeUTF(name);
                        dos.writeUTF(username);
                        dos.writeUTF(password);
                        dos.writeUTF(country);
                        
//                        byte data[] = user_data.getBytes();
                        byte data[] = baos.toByteArray();
                        int record_id = rs.addRecord(data, 0, data.length);
                        
                        alt.setType(AlertType.INFO);
                        alt.setTitle("Success");
                        alt.setString("New User Saved :" + record_id);
                        clear();
                        Main.d.setCurrent(alt);
                        
                        
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //sign in
                    Main.d.setCurrent(Main.frm_signin);
                }
            }
        });
    }
    
    public SignUP() {
        super("Sign Up");
        initCOmponets();
    }
}
