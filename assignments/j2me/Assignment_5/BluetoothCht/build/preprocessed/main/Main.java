/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author VSD
 */
public class Main extends MIDlet {

    public static Display d;
    public static FrmMenu frmmenu;
    public static FrmServer frmsever;
    public static FrmClient frmclient;

    public void init() {
        frmmenu = new FrmMenu();
        frmsever = new FrmServer();
        frmclient = new FrmClient();

        d = Display.getDisplay(this);

    }

    public void startApp() {
        init();
        d.setCurrent(frmmenu);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
