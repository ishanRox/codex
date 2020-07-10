/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Acer
 */
public class Form1 extends Form{
    
    public Form1(){
        super("Form");
        initComponets();
    }
    
    private TextField tfUserName;
    
    public void initComponets(){
        tfUserName=new TextField("USername", null, 20, TextField.ANY);
    }
}
