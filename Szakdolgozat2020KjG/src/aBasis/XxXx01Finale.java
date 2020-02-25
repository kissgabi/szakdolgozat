/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aBasis;

import aControl.XxXx00Control;
import static aGlobal.XxXx00Global.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b6dmin
 */
public class XxXx01Finale extends Thread {

    private static XxXx00Control c;

    public static void setControl(XxXx00Control c) {
        XxXx01Finale.c = c;
    }

    private final long sleepTime = FINALE_SLEEPTIME;

    public XxXx01Finale() {
        super(String.format("Finale"));
    }

    @Override
    public void run() {
        sleepThread(sleepTime * FINALE_STEPS / 4);
        while (c.nextStep() < FINALE_STEPS) {
            sleepThread(sleepTime);
        }
        System.out.println("Thread:> " + this.getName() + " finished,");
        sleepThread(sleepTime * FINALE_STEPS / 8);
        c.finishFinale();
    }

    private void sleepThread(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(XxXx01Finale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
