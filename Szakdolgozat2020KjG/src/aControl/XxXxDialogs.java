/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import aGlobal.XxXx00Global;
import static aGlobal.XxXx00Global.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author b6dmin
 */
public class XxXxDialogs {

    public XxXxDialogs() {
    }

    public static void showInfo(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                DIALOG_INFO_TXT,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                DIALOG_ERROR_TXT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void dialogNotFound() {
        showError(DIALOG_NOTFOUND_TXT);
    }

    public static void dialogServerNotFound() {
        showError(DIALOG_SERVER_ERROR_TXT);
    }

    public static void dialogHost() {
        if (state == XxXx00Global.PROCESS_STATE.PROLOG) {
            dialogHostAddress();
        } else {
            String s = HTML_START_TXT + HTML_CENTER_TXT
                    + dbAddress + HTML_LINEBREAK_TXT
                    + executorName + HTML_LINEBREAK_TXT
                    + DIALOG_MYIP_TXT + HTML_LINEBREAK_TXT
                    + hostAddress + HTML_LINEBREAK_TXT
                    + HTML_CENTER_END + HTML_END_TXT;
            showInfo(s);
        }
    }

    public static void dialogInfo() {
        String s = HTML_START_TXT + HTML_CENTER_TXT
                + DIALOG_NAME_TXT + HTML_LINEBREAK_TXT
                + DIALOG_VERSION_TXT + HTML_LINEBREAK_TXT
                + DIALOG_COPYRIGHT_TXT
                + HTML_CENTER_END + HTML_END_TXT;
        showInfo(s);
    }

    public static void dialogHostAddress() {
        JTextField dbase_url = new JTextField();
        Object[] message = {
            "Database (IP) címe:", dbase_url,};
        dbase_url.setText(localNetworkAddress);

        int option = JOptionPane.showConfirmDialog(
                null,
                message,
                "Adatbázis kapcsolat",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            dbAddress = dbase_url.getText();
        }
    }
}
