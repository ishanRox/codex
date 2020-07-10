/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import Main.Main;
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
public class SingIn extends Form {

    private TextField tf_username;
    private TextField tf_password;
    private Command com_signup;
    private Command com_signin;
    private Alert alt;

    public void initComponents() {
        alt = new Alert(null);
        tf_username = new TextField("Username", null, 10, TextField.ANY);
        tf_password = new TextField("Password", null, 10, TextField.ANY);
        this.append(tf_username);
        this.append(tf_password);

        com_signup = new Command("Sign Up", Command.OK, 0);
        com_signin = new Command("Sign In", Command.OK, 1);
        this.addCommand(com_signup);
        this.addCommand(com_signin);

        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == com_signin) {
                    try {

                        String username = tf_username.getString();
                        String password = tf_password.getString();


                        RecordStore rs = RecordStore.openRecordStore("user_rs", true);

                        for (int i = 1; i < rs.getNextRecordID(); i++) {
                            byte data[] = rs.getRecord(i);
                            String user_data = new String(data);

                            //split
                            int co = 0;

                            int co1_index = 0;
                            int co2_index = 0;
                            int co3_index = 0;

                            for (int j = 0; j < user_data.length(); j++) {
                                if (user_data.charAt(j) == ',') {
                                    //,found
                                    co++;
                                    if (co == 2) {
                                        co1_index = j;
                                    } else if (co == 3) {
                                        co2_index = j;
                                    } else if (co == 4) {
                                        co3_index = j;
                                    }
                                }
                            }
                            String un = user_data.substring(co1_index + 1, co2_index);
                            String pw = user_data.substring(co2_index + 1, co3_index);

                            if (un.equals(tf_username.getString()) && pw.equals(tf_password.getString())) {
                                //sign in sucess
                                alt.setType(AlertType.INFO);
                                alt.setTitle("Success");
                                alt.setString("Sign in Sucess");

                                Main.d.setCurrent(alt);
                            }
                            
                            //split
                            
                        }
                    } catch (RecordStoreException e) {
                        e.printStackTrace();
                    }
                } else {
                    //sign up
                    Main.d.setCurrent(Main.frm_signup);
                }
            }
        });
    }

    public SingIn() {
        super("Sign In");
        initComponents();
    }
}
