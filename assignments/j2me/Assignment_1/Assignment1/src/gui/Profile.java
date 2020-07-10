/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import main.Midlet;

/**
 *
 * @author Acer
 */
public class Profile extends Form {

    private Command c1;
    private StringItem si1;
    private StringItem si2;
    private StringItem si3;
    private StringItem si4;

    public void update() {
        si1.setText(SignIn.user.getNic());
        si2.setText(SignIn.user.getName());
        si3.setText(SignIn.user.getUname());
        si4.setText(SignIn.user.getPassword());
    }

    public void initComponents() {
        c1 = new Command("SignOut", Command.OK, 0);
        this.addCommand(c1);
        si1 = new StringItem("NIC", "");
        si2 = new StringItem("Name", "");
        si3 = new StringItem("Username", "");
        si4 = new StringItem("Password", "");
        this.append(si1);
        this.append(si2);
        this.append(si3);
        this.append(si4);

        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == c1) {
                    //signout
                    Midlet.frmsignin.clear();
                    Midlet.d.setCurrent(Midlet.frmsignin);
                }
            }
        });

    }

    public Profile() {
        super("Profile");
        initComponents();
    }
}
