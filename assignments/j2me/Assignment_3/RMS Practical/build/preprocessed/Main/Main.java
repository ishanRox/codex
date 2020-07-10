/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUIS.SignUP;
import GUIS.SingIn;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author VSD
 */
public class Main extends MIDlet {

    public static Display d;
    public static SignUP frm_signup;
    public static SingIn frm_signin;

    

    public void init() {
        d = Display.getDisplay(this);
        frm_signup = new SignUP();
        frm_signin = new SingIn();
        d.setCurrent(frm_signup);
    }

    public void startApp() {
        init();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
