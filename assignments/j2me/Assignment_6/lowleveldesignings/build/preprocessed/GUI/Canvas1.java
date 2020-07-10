/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author VSD
 */
public class Canvas1 extends Canvas {
    
    protected void paint(Graphics g) {
        
        System.out.println(getWidth());
        System.out.println(getHeight());
        g.setColor(9, 132, 227);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(255, 234, 167);
        g.fillArc(100, 100, 60, 60, 0, 360);
        
        g.setColor(255, 118, 117);
        g.fillTriangle(90, 200, 130, 160, 180, 200);
        
        g.setColor(214, 48, 49);
//        g.drawString("hell0", 100, 100, Graphics.TOP | Graphics.BOTTOM);
        
        try {
            Image i = Image.createImage("/im/a.png");
            g.drawImage(i, 50, 50, Graphics.HCENTER | Graphics.VCENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
