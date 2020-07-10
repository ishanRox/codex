/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import main.Midlet;

/**
 *
 * @author Acer
 */
public class SignIn extends Form {

    private Command cmdsignin;
    private Command cmdsignup;
    private TextField tf1;
    private TextField tf2;
    public static User user;
    public int count;

    public SignIn() {
        super("Sign In");
        initComponents();
    }

    public void clear() {
        tf1.setString(null);
        tf2.setString(null);
    }

    public void initComponents() {

        cmdsignin = new Command("SignIn", Command.OK, 1);
        this.addCommand(cmdsignin);
        cmdsignup = new Command("SignUp", Command.OK, 0);
        this.addCommand(cmdsignup);
        tf1 = new TextField("Userame", null, 10, TextField.ANY);
        tf2 = new TextField("Password", null, 10, TextField.PASSWORD);
        this.append(tf1);
        this.append(tf2);

        setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == cmdsignin) {
                    //signin
                    boolean found = false;
                    if (User.user_list == null) {
                        Alert al = new Alert("Error", "Invalid Details", null, AlertType.INFO);
                        Midlet.d.setCurrent(al);
                    } else {
                        for (int i = 0; i < User.user_list.size(); i++) {
                            User u1 = (User) User.user_list.elementAt(i);
                            if (u1.getUname().equals(tf1.getString()) && u1.getPassword().equals(tf2.getString())) {
                                found = true;
                                count = 0;
                                SignIn.user = u1;
                                Midlet.frmprofile.update();
                                Midlet.d.setCurrent(Midlet.frmprofile);
                                break;
                            } else if (tf1.getString().equals("") || tf2.getString().equals("")) {
                                Alert a1 = new Alert("Error", "Invalid Details", null, AlertType.ERROR);
                                Midlet.d.setCurrent(a1);
                            }
                        }
                    }

                    if (!found) {
                        //not found
                        count++;
                        if (count == 3) {
                            Midlet.m.notifyDestroyed();
                        }
                        clear();
                        Alert a1 = new Alert("Error", "Invalid Details", null, AlertType.ERROR);
                        Midlet.d.setCurrent(a1);
                    }
                } else {
                    //sign up
                    clear();
                    Midlet.d.setCurrent(Midlet.frmsignup);

                }



            }
        });

    }
}
