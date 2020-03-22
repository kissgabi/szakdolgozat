/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import static aControl.XxXxDialogs.dialogServerNotFound;
import static aGlobal.XxXx00Global.*;
import static aGlobal.XxXx02Global.*;
import aSurfaces.XxXx00ControlPanel;
import aSurfaces.XxXx02MsgPushPanel;
import aSurfaces.XxXx02MsgViewPanel;

/**
 *
 * @author b6dmin
 */
public class XxXx02Control {

    private final XxXx00Control MAINCONTROL;
    private final XxXx00MainFrame MAINFRAME;
    private final XxXx00ControlPanel CONTROLPANEL;
    private final XxXx02MsgPushPanel MSGPUSHPANEL;
    private final XxXx02MsgViewPanel MSGVIEWPANEL;
    private final XxXx02MsgViewPanel MSGVIEWALLPANEL;

    private final XxXx02Queries executeQueries2;

    public XxXx02Control(XxXx00Control c, XxXx00MainFrame mf,
            XxXx00ControlPanel cp) {
        this.MAINCONTROL = c;
        this.MAINFRAME = mf;
        this.CONTROLPANEL = cp;
        this.MSGPUSHPANEL = new XxXx02MsgPushPanel();
        this.MSGVIEWPANEL = new XxXx02MsgViewPanel();
        this.MSGVIEWALLPANEL = new XxXx02MsgViewPanel();
        MSGVIEWPANEL.setName(TAB_MESSAGE_OWN);
        MSGVIEWALLPANEL.setName(TAB_MESSAGE_ALL);
        executeQueries2 = new XxXx02Queries();
    }

    private void setup() {
        MSGPUSHPANEL.setControl(this);
        MSGVIEWPANEL.setControl(this);
        MSGVIEWALLPANEL.setControl(this);
        MSGPUSHPANEL.setup();
        MSGVIEWPANEL.setup();
        MSGVIEWALLPANEL.setup();
    }

    public void start() {
        setup();
        MSGTAB_BROADCAST_USERNAME = executeQueries2.broadcast_username();
        MSGVIEWPANEL.resetRadioButtons();
        switch (executorLevel) {
            case SU:

            case DIRECTOR:
                MSGVIEWALLPANEL.fillUserList(MAINCONTROL.userNamesList());
                CONTROLPANEL.addPanel(TAB_MESSAGE_ALL, MSGVIEWALLPANEL);
                MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                        list_all_messages());
            case EMPLOYEE:
                MSGVIEWPANEL.fillUserList(MAINCONTROL.userNamesList());
                MSGPUSHPANEL.fillTargetList(MAINCONTROL.userNamesList());
                CONTROLPANEL.addPanel(TAB_MESSAGE_OWN, MSGVIEWPANEL);
                CONTROLPANEL.addPanel(TAB_MESSAGE_WRITE, MSGPUSHPANEL);
                MSGVIEWPANEL.fillMsgList(executeQueries2.
                        list_employee_all_messages());
            default:
        }
    }

    public void XxXx02SelectMessages(String who, String name) {
        //System.out.println("Control.mainProcessSelectMessages() from " + who);
        switch (name) {
            case TAB_MESSAGE_OWN:
                if (who.equals(STAR)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_all_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_partner_messages(who));
                }
                break;
            case TAB_MESSAGE_ALL:
                if (who.equals(STAR)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_all_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_partner_messages(who));
                }
                break;
            default:
        }
    }

    public void XxXx02SelectMessagesIn(String who, String name) {
        //System.out.println("Control.mainProcessSelectMessages() from " + who);
        switch (name) {
            case TAB_MESSAGE_OWN:
                if (who.equals(STAR)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_all_in_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_partner_in_messages(who));
                }
                break;
            case TAB_MESSAGE_ALL:
                if (who.equals(STAR)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_all_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_partner_in_messages(who));
                }
                break;
            default:
        }
    }

    public void XxXx02MessagesOut(String who, String name) {
        //System.out.println("Control.mainProcessSelectMessages() from " + who);
        switch (name) {
            case TAB_MESSAGE_OWN:
                if (who.equals(STAR)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_all_out_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWPANEL.fillMsgList(executeQueries2.
                            list_employee_partner_out_messages(who));
                }
                break;
            case TAB_MESSAGE_ALL:
                if (who.equals(STAR)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_all_messages());
                } else if (who.equals(executorName)) {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_memo_messages());
                } else {
                    MSGVIEWALLPANEL.fillMsgList(executeQueries2.
                            list_partner_out_messages(who));
                }
                break;
            default:
        }
    }

    public void XxXx02PushMessages(String who, String msg) {
        if (who.equals(MSGTAB_BROADCAST_TXT)) {
            who = MSGTAB_BROADCAST_USERNAME;
        }
        System.out.println("Control.mainProcessPushMessages() to " + who);
        switch (executorLevel) {
            case EMPLOYEE:
            case DIRECTOR:
            case SU:
                int index = executeQueries2.push_message(who, msg);
                if (who.equals(MSGTAB_BROADCAST_USERNAME)) {
                    who = MSGTAB_BROADCAST_TXT;
                }
                if (index >= 0) {
                    MAINFRAME.statusBarSetText(MSGTAB_SEND_OK_TXT
                            + MSGTAB_LABEL_ADDRESSEE_TXT + who);
                    MSGPUSHPANEL.enablePush();
                    MSGPUSHPANEL.clearTextfield();
                    MSGVIEWPANEL.resetRadioButtons();
                    MSGVIEWPANEL.resetUserList();
                    XxXx02SelectMessages(STAR, TAB_MESSAGE_OWN);
                    XxXx02SelectMessages(STAR, TAB_MESSAGE_ALL);
                    CONTROLPANEL.selectPanel(MSGVIEWPANEL);
                } else {
                    MAINFRAME.statusBarSetText(MSGTAB_SEND_NOT_OK_TXT
                            + MSGTAB_LABEL_ADDRESSEE_TXT + who);
                    dialogServerNotFound();
                }
            default:
        }
    }

    public void showMessageInDialog(Object[] m) {
        String s = "";
        s += m[0] + System.lineSeparator() + System.lineSeparator();
        s += m[1] + System.lineSeparator() + System.lineSeparator();
        s += MSGTAB_LABEL_SENDER_TXT + System.lineSeparator()
                + TAB + m[2] + System.lineSeparator();
        s += MSGTAB_LABEL_ADDRESSEE_TXT + System.lineSeparator();
        if (m[3].equals(MSGTAB_BROADCAST_USERNAME)) {
            s += TAB + MSGTAB_BROADCAST_TXT;
        } else {
            s += TAB + m[3];
        }
        XxXxDialogs.showInfo(s);
    }

    public void messageEnable() {
        MSGPUSHPANEL.enablePush();
    }
}
