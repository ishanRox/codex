/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.User;
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
public class SignUp extends Form {

    public SignUp() {
        super("SignUp");
        initComponents();
    }
    private Command c1;
    private TextField tf1;
    private TextField tf2;
    private TextField tf3;
    private TextField tf4;

    void clear() {
        tf1.setString(null);
        tf2.setString(null);
        tf3.setString(null);
        tf4.setString(null);
    }

    public void initComponents() {
        c1 = new Command("SignUp", Command.OK, 0);
        this.addCommand(c1);
        tf1 = new TextField("NIC", null, 10, TextField.ANY);
        tf2 = new TextField("Name", null, 10, TextField.ANY);
        tf3 = new TextField("Username", null, 10, TextField.ANY);
        tf4 = new TextField("Password", null, 10, TextField.PASSWORD);
        this.append(tf1);
        this.append(tf2);
        this.append(tf3);
        this.append(tf4);

        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == c1) {
                    User u = new User(tf1.getString(), tf2.getString(), tf3.getString(), tf4.getString());
                    User.user_list.addElement(u);
                    clear();
                    Midlet.d.setCurrent(Midlet.frmsignin);
                }
            }
        });

    }
}
