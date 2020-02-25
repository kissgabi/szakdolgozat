/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

//import static aGlobal.XxXx00Global.*;
import aGlobal.XxXx00Global;
import static aGlobal.XxXx01Global.*;
import static aGlobal.XxXx00Global.dbPassword;
import static aGlobal.XxXx00Global.dbUsername;
import static aGlobal.XxXx00Global.executorLevel;
import static aGlobal.XxXx00Global.executorName;
import aSurfaces.XxXx00ControlPanel;
import aSurfaces.XxXx01GetUserPanel;
import aSurfaces.XxXx01LoginPanel;

/**
 *
 * @author b6dmin
 */
public class XxXx01Control {

    private final XxXx00Control MAINCONTROL;
    private final XxXx00MainFrame MAINFRAME;
    private final XxXx00ControlPanel CONTROLPANEL;
    private final XxXx01GetUserPanel USERPANEL;
    private final XxXx01LoginPanel LOGINPANEL;

    private final XxXx01Queries executeQueries1;

    public XxXx01Control(XxXx00Control c, XxXx00MainFrame mf,
            XxXx00ControlPanel cp) {
        this.MAINCONTROL = c;
        this.MAINFRAME = mf;
        this.CONTROLPANEL = cp;
        USERPANEL = new XxXx01GetUserPanel();
        LOGINPANEL = new XxXx01LoginPanel();
        USERPANEL.setName(TAB_USER_TXT);
        LOGINPANEL.setName(TAB_LOGIN_TXT);
        this.executeQueries1 = new XxXx01Queries();
    }

    public void setup() {
        USERPANEL.setControl(this);
        LOGINPANEL.setControl(this);
        USERPANEL.setup();
        LOGINPANEL.setup();
    }

    public void start() {
        setup();
        restart();
    }

    public void restart() {
        CONTROLPANEL.removePanels();
        addUserPanel();
    }

    public void addUserPanel() {
        CONTROLPANEL.addPanel(TAB_USER_TXT, USERPANEL);
        USERPANEL.txtUserRequestFocus();
    }

    public void addLoginPanel() {
        CONTROLPANEL.addPanel(TAB_LOGIN_TXT, LOGINPANEL);
        LOGINPANEL.txtPswdRequestFocus();
    }

    public void userName(String s) {
        int index = executeQueries1.valid_username_usegroup(s);
        if (index == 0) {
            MAINCONTROL.showStatus(executorName + STATUS_USER_NOT_VALID_TXT);
            return;
        }
        switch (index) {
            case 2: {//superuser
                System.out.println("> superuser");
                dbUsername = "superuser";
                dbPassword = "superusermysql";
                break;
            }
            case 3: {//employee
                System.out.println("> employee");
                dbUsername = "employee";
                dbPassword = "employeemysql";
                break;
            }
            case 4: {//director
                System.out.println("> director");
                dbUsername = "director";
                dbPassword = "directormysql";
                break;
            }
            default:
            //System.out.println("> default: " + index);
        }
        CONTROLPANEL.removePanels();
        MAINCONTROL.startMainProcess(s);
        addLoginPanel();
    }

    public void userPassword(String p) {
        int index = executeQueries1.valid_password_usergroup(executorName, p);
        if (index == 0) {
            MAINCONTROL.showStatus(executorName + STATUS_PWD_NOT_VALID_TXT);
            return;
        }
        switch (index) {
            case 2: {//superuser
                System.out.println("> superuser");
                executorLevel = XxXx00Global.USERGROUP.SU;
                break;
            }
            case 3: {//employee
                System.out.println("> employee");
                executorLevel = XxXx00Global.USERGROUP.EMPLOYEE;
                break;
            }
            case 4: {//director
                System.out.println("> director");
                executorLevel = XxXx00Global.USERGROUP.DIRECTOR;
                break;
            }
            default:
                System.out.println("> default");
        }
        CONTROLPANEL.removePanels();
        MAINCONTROL.loginMainProcess(p);
    }
}
