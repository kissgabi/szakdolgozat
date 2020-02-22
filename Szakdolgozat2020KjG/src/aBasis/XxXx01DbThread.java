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
public class XxXx01DbThread extends Thread {

    private static XxXx00Control c;

    public static void setControl(XxXx00Control c) {
        XxXx01DbThread.c = c;
    }

    private final String URL;
    private final String User;
    private final String Secret;

    public XxXx01DbThread(String url, String user, String secret) {
        super(String.format(user));
        this.URL = url;
        this.User = user;
        this.Secret = secret;
    }

    @Override
    public void run() {
        XxXx01SqlAdmin dbTest = new XxXx01SqlAdmin(this.URL, this.User, this.Secret);
        if (dbTest.isDbClosed()) {
            System.out.println("Thread:> " + this.getName() + " finished,");
        }
        if (dbTest.isDbReady()) {
            c.statusDbFound();
            sleepThread(MYSQL_TEST_SLEEPTIME);
            c.finishProlog(this.getName(), dbTest.isDbReady());
        } else {
            c.statusDbNotFound();
            sleepThread(MYSQL_TEST_SLEEPTIME);
            c.dbConnection();
        }
    }

    private void sleepThread(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(XxXx01Finale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
