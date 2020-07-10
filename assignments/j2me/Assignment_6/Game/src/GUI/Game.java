/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Acer
 */
public class Game extends GameCanvas{
    Game(){
    super(true);
    }
    public void gameLoop(){
    new Thread(new Runnable() {

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
    }
}
