/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Canvas1;
import GUI.Form1;
import GUI.Game;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

//import static main.Midlet.d;
//import static main.Midlet.form;

/**
 * @author VSD
 */
public class Midlet extends  MIDlet {
    public static Display d;
    public static Form1 form;
    public static Canvas1 canvas;
    public static Game g;
    
    private void init(){
        d=Display.getDisplay(this);
//        form=new Form1();
//        canvas=new Canvas1();
        g=new Game();
    }
    
    
    
    public void startApp() {
        init();
        d.setCurrent(g);
//        g.manWalk();
        g.gameLoop();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
