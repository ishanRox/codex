/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3_player;

import Forms.F2;
import com.sun.lwuit.Display;
import javax.microedition.midlet.*;

/**
 * @author Sithara
 */
public class Midlet extends MIDlet {
    
    public static F2 f2;
    
    private void init(){
        Display.init(this);
        f2=new F2();
    }

    public void startApp() {
        init();
        f2.show();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
