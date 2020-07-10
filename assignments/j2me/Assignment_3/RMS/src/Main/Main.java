/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUIS.Add;
import GUIS.RMS1;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Acer
 */
public class Main extends MIDlet {
    
    public static Display d;
    public static RMS1 frm_rms1;
    public static Add add;
    
    public void init(){
        d=Display.getDisplay(this);
        frm_rms1=new RMS1();
        add=new Add();
        d.setCurrent(add);
    
    }
    public void startApp() {
        init();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
