/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.m3g.Graphics3D;

/**
 *
 * @author Acer
 */
public class Game extends GameCanvas {

    private Sprite man;
    private Graphics g;
    private LayerManager lm;

    public Game() {
        super(true);
        g = getGraphics();
        lm = new LayerManager();

    }

//    public void manWalk() {
//
//
//        try {
//            System.out.println("ok");
//            Image i = Image.createImage("/im/man.png");
//            man = new Sprite(i, 75, 132);
//
//            int seq[] = {0, 1, 2, 3, 4, 5, 6, 7};
//            man.setFrameSequence(seq);
//
////            final LayerManager lm = new LayerManager();
//            lm.append(man);
//
//            lm.paint(g, 0, 0);
//
//            new Thread(new Runnable() {
//                public void run() {
//
//                    while (true) {
//                        try {
//                            g.setColor(223, 249, 251);
//                            g.fillRect(0, 0, getWidth(), getHeight()); //animate wddi blru wena eka nati krnna tama Rect dnne
//
//                            System.out.println("oll");
//                            man.nextFrame();
//                            man.move(10, UP);
//                            lm.paint(g, 0, 0);
//                            flushGraphics();
//                            Thread.sleep(100);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }).start();
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
    public void manInit() {
        try {

            Image i = Image.createImage("/im/man.png");
            man = new Sprite(i, 75, 132);
            int seq[] = {0, 1, 2, 3, 4, 5, 6, 7};
            man.setFrameSequence(seq);
//            final LayerManager lm = new LayerManager();
            lm.append(man);
            lm.paint(g, 0, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manwalk1() {
//        try {
//            g.setColor(254, 254, 254); //kalin image eka wahanna tamai aluthin color eak set krnne 
//            g.fillRect(0, 0, getWidth(), getHeight());
//
//            man.nextFrame();
//            man.move(5, 0);
//            lm.paint(g, 0, 0);
//            flushGraphics();
//            Thread.sleep(100);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 8; i++) {
                    g.setColor(254, 254, 254); //kalin image eka wahanna tamai aluthin color eak set krnne 
                    g.fillRect(0, 0, getWidth(), getHeight());

                    man.nextFrame();
                    man.move(1, 0);
                    lm.paint(g, 0, 0);
                    flushGraphics();
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    public void gameLoop() {
        manInit();
//
//        Thread t = new Thread(new Runnable() {
//            public void run() {


        new Thread(new Runnable() {
            public void run() {

                while (true) {

                    if ((getKeyStates() & GameCanvas.RIGHT_PRESSED) != 0) {
                        manwalk1();
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();



//            }
//        });
//        t.start();
    }
}
