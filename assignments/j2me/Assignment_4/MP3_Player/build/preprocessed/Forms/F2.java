/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import com.sun.lwuit.Button;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

/**
 *
 * @author Sithara
 */
public class F2 extends Form {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Player p;

    public F2() {
        super("F2");
        initComponents();
    }

    private void initComponents() {

        btn1 = new Button("Play");
        addComponent(btn1);


        try {
            Thread t = new Thread(new Runnable() {
                public void run() {

                    try {
                        InputStream is = getClass().getResourceAsStream("/audio/aa.mp3");
                        p = Manager.createPlayer(is, "audio/mpeg");
                        p.realize();
                        p.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });


            t.start();
        } catch (Exception e) {
            e.printStackTrace();
        }




        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Thread t = new Thread(new Runnable() {
                        public void run() {

                            try {

                                p.realize();
                                p.start();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });


                    t.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn2 = new Button("Pause");
        addComponent(btn2);

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    p.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        btn3 = new Button("Stop");
        addComponent(btn3);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    p.stop();

                    InputStream is = getClass().getResourceAsStream("/audio/aa.mp3");
                    p = Manager.createPlayer(is, "audio/mpeg");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
      


    }
}
