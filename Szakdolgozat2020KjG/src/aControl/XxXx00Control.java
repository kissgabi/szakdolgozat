/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import aBasis.XxXx01DataObject;
import aBasis.XxXx01DbThread;
import aBasis.XxXx01Finale;
import aBasis.XxXx01Sprite;
import aBasis.XxXx01SqlAdmin;
import aBasis.XxXx01UserGroup;
import aDatas.XxXx00Queries;
import aDatas.XxXxReadDatas;
import aDatas.XxXxReadList;
import static aGlobal.XxXx00Global.*;
import aSurfaces.XxXx00ControlPanel;
import aSurfaces.XxXx00GraphityPanel;
import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author b6dmin
 */
public class XxXx00Control {

    private final XxXx01Control CONTROL01;
    private final XxXx02Control CONTROL02;

    private final XxXx00Queries executeQueries0;

    private final XxXx00MainFrame MAINFRAME;
    private final XxXx00GraphityPanel GRAPHITYPANEL;
    private final XxXx00ControlPanel CONTROLPANEL;

    private List<XxXx01UserGroup> listDatas;
    private List<XxXx01DataObject> objectList;
    private int epilog = 0;
    //private int thread = 0;

    private ExecutorService executorService;

    public XxXx00Control(XxXx00MainFrame mf,
            XxXx00ControlPanel cp,
            XxXx00GraphityPanel gp) {
        this.MAINFRAME = mf;
        this.CONTROLPANEL = cp;
        this.GRAPHITYPANEL = gp;
        this.CONTROL01 = new XxXx01Control(this, MAINFRAME, CONTROLPANEL);
        this.CONTROL02 = new XxXx02Control(this, MAINFRAME, CONTROLPANEL);
        this.executeQueries0 = new XxXx00Queries();
        networkNames();
    }

    public void statusDbFound() {
        showStatus(STATUS_CONNECTED_TXT);
    }

    public void statusDbNotFound() {
        showStatus(STATUS_DB_NOT_FOUND_TXT);
    }

    private void XxXx00setup() {
        MAINFRAME.setControl(this);
        CONTROLPANEL.setControl(this);
        MAINFRAME.setup();
        CONTROLPANEL.setup();
        XxXx01Sprite.setControl(this);
        XxXx01Finale.setControl(this);
        XxXx01SqlAdmin.setControl(this);
        XxXx01DbThread.setControl(this);
        listDatas = XxXxReadList.inputFromFile();
        objectList = XxXxReadDatas.inputFromFile();
        executorService = Executors.newFixedThreadPool(MAX_THREAD_NUMBER);
    }

    public void setup() {
        System.out.println("Control.setup()");
        //System.out.println("> " + XxXx01Global.kkv_db());
        XxXx00setup();
    }

    public void showStatus(String s) {
        MAINFRAME.statusBarSetText(s);
    }

    public void dbConnection() {
        System.out.println("Control.dbConnection()");
        String kkv_db = kkv_db();
        //System.out.println(kkv_db);
        showStatus(kkv_db);
        XxXx01DbThread dbTest
                = new XxXx01DbThread(kkv_db, dbUsername, dbPassword);
        executorService.submit(dbTest);
    }

    public void dbConnection(String url, String name, String secret) {
        XxXx01DbThread dbTest = new XxXx01DbThread(url, name, secret);
        executorService.submit(dbTest);
    }

    public void testDbConnection() {
        String kkv_db = URL1 + DB_KKV_SAMPLE + URL2;
        dbConnection(kkv_db, dbUsername, dbPassword);
    }

    public void startProlog() {
        System.out.println("Control.startProlog()");
        dbUsername = listDatas.get(0).getUserName();
        dbPassword = listDatas.get(0).getSecret();
        testDbConnection();
    }

    public void finishProlog(String name, boolean isOk) {
        System.out.println("Control.finishProlog()");
        state = PROCESS_STATE.MAIN;
        MAINFRAME.dbConnected();
        MAINFRAME.graphityPanelOff();
        MAINFRAME.controlPanelOn();
        CONTROL01.start();
        //System.out.println("> " + MSGTAB_BROADCAST_USERNAME);
    }

    public void startMainProcess(String s) {
        System.out.println("Control.startMainProcess()");
        MAINFRAME.logOutOn();
        showStatus(s);
        executorName = s;
    }

    public void restartMainProcess() {
        MAINFRAME.statusBarSetText("");
        MAINFRAME.logOff();
        executorName = "";
        executorPswd = "";
        executorLevel = USERGROUP.TEST;
        CONTROL01.restart();
    }

    public String[] userNamesList() {
        return executeQueries0.list_all_usernames();
    }

    public void loginMainProcess(String p) {
        System.out.println("Control.loginMainProcess()");
        showStatus(executorName + STATUS_LOGGED_IN_TXT);
        executorPswd = p;
        CONTROL02.start();
    }

    public void mainProcess() {
        System.out.println("Control.mainProcess()");
    }

    public void finishMainProcess() {
        System.out.println("Control.finishMainProcess()");
    }

    public void startFinale() {
        System.out.println("Control.startFinale()");
        MAINFRAME.startFinale();
        state = PROCESS_STATE.EPILOG;
        refreshGraphity();
        XxXx01Finale finale = new XxXx01Finale();
        executorService.submit(finale);
    }

    public void finishFinale() {
        System.out.println("Control.finishFinale()." + state);
        state = PROCESS_STATE.EXIT;
        refreshGraphity();
        exitProgram();
    }

    public void exitProgram() {
        System.out.println("Control.exitPrgram()");
        System.exit(0);
    }

    public void drawGraphity(Graphics g) {
        switch (state) {
            case PROLOG: {

                break;
            }
            case MAIN: {

                break;
            }
            case EPILOG: {

                break;
            }
            default:

        }
        refreshGraphity();
    }

    public void clickOnGraphity(int x, int y, int button) {
        System.out.println("Control.clickOnGraphity() > " + state);
        switch (state) {
            case PROLOG: {

                break;
            }
            case MAIN: {

                break;
            }
            case EPILOG: {
                finishFinale();
                break;
            }
            default:
                exitProgram();
        }
        refreshGraphity();
    }

    public void refreshGraphity() {
        GRAPHITYPANEL.repaint();
    }

    public int nextStep() {
        MAINFRAME.resize(epilog++);
        refreshGraphity();
        MAINFRAME.revalidate();
        return epilog;
    }

    public void dialogInfo() {
        XxXxDialogs.dialogInfo();
    }

    public void dialogHost() {
        XxXxDialogs.dialogHost();
    }
}
