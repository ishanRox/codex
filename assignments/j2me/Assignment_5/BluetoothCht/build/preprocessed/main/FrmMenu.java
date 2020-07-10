/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

/**
 *
 * @author VSD
 */
public class FrmMenu extends Form {

    public FrmMenu() {
        super("Menu");
        initCOmponents();
    }
    private ChoiceGroup cgMenu;
    private Command comGOTo;

    private void initCOmponents() {
        String options[] = {"Server", "Client Area"};
        cgMenu = new ChoiceGroup("SElect ", ChoiceGroup.POPUP, options, null);
        append(cgMenu);

        comGOTo = new Command("GO TO ", Command.OK, 1);
        addCommand(comGOTo);

        setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c == comGOTo) {
                    if (cgMenu.getSelectedIndex() == 0) {
                        //gotoserver
                        Main.d.setCurrent(Main.frmsever);
                    } else {
                        //
                        Main.d.setCurrent(Main.frmclient);

                    }
                }
            }
        });
    }
}
