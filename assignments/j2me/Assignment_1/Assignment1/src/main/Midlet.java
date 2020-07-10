/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.Profile;
import gui.SignIn;
import gui.SignUp;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Acer
 */
public class Midlet extends MIDlet {

    public static Display d;
    public static Profile frmprofile;
    public static SignIn frmsignin;
    public static SignUp frmsignup;
    public static Midlet m;

    public void init() {
        d = Display.getDisplay(this);
        frmprofile = new Profile();
        frmsignin = new SignIn();
        frmsignup = new SignUp();
        d.setCurrent(frmsignin);
        m = this;
    }

    public void startApp() {
        init();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
