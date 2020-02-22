/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aGlobal;

import java.awt.Image;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author b6dmin
 */
public class XxXx00Global {

    public static final boolean TEST_MODE = true;
    public static final String TEST_USERNAME = "Super User";
    public static final String TEST_USERPSWD = "superuserpassword";

    /**
     * log fájlok helye
     */
    public static final String LOG_TEST = "XxXxTestLog.txt";
    public static final String LOG_WORK = "XxXxLog.txt";

    public static String hostAddress;
    public static String localNetworkAddress;
    public static String dbAddress = "localhost";
    public static String executorName = "";
    public static String executorPswd = "";
    public static String dbUsername = "root";
    public static String dbPassword = "";

    public XxXx00Global() {
    }

    public static void networkNames() {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    System.out.println(i.getHostAddress());
                }
            }

            try (final DatagramSocket socket = new DatagramSocket()) {
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                hostAddress = socket.getLocalAddress().getHostAddress();
                localNetworkAddress
                        = hostAddress.substring(0, hostAddress.lastIndexOf('.') + 1);
            } catch (UnknownHostException ex) {
                Logger.getLogger(XxXx00Global.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SocketException ex) {
            Logger.getLogger(XxXx00Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String kkv_db() {
        return URL1A + dbAddress + ":3306/" + DB_KKV_SAMPLE + URL2;
    }

    // mysql connection
    public static final String URL1 = "jdbc:mysql://localhost:3306/";
    public static final String URL1A = "jdbc:mysql://";
    public static final String DB_KKV_SAMPLE = "kkv_sample";
    public static final String URL2 = "?useUnicode=true&characterEncoding=UTF-8";

    public static final String USER = "root";
    public static final String PSWD = "";
    public static final String CHARSET = " DEFAULT CHARACTER SET utf8mb4 ";
    public static final String COLLATION = " COLLATE utf8mb4_hungarian_ci";

    public static final long MYSQL_TEST_SLEEPTIME = 1000;

    // SHOW DATABASES
    public static final String SHOW_DBASES_QUERY = "Show databases";

    public static final String SPLIT_REGEX = ";";
    public static final String DOT = ".";
    public static final String STAR = "*";
    public static final String CELL_DELIMITER = " ; ";
    public static final String TO = "->";
    public static final String TAB = "    ";
    public static final String ELLIPSIS = "..."; //"\u2026";

    /**
     * query map lista
     */
    public static final String LIST00_QUERIES = "/aDatas/XxXx00Queries.txt";

    /**
     * felhasználói szintek listája
     */
    public static final String LIST_USERS = "/aDatas/XxXx01List.txt";

    /**
     * induló adattábla feltöltések
     */
    public static final String LIST_DATAS = "/aDatas/XxXx00Datas.txt";

    public static final String SOURCES_URL = "/aSources/";

    public static final String CODE_PAGE = "UTF-8";
    public static final String MODE_R = "r";
    public static final String MODE_RW = "rw";

    public static final String EX_NODATA = "Nincs adat...";
    public static final String EX_DATAERROR = "Hibás adat...";
    public static final String EX_ERROR = "Hiba...";

    public static final int MAX_THREAD_NUMBER = 6;

    public static enum USERGROUP {
        TEST, SU, DIRECTOR, ACCOUNTNT, SHOPPER, EMPLOYEE
    }

    public static USERGROUP executorLevel = USERGROUP.TEST;

    public static enum PROCESS_STATE {
        PROLOG, MAIN, EPILOG, EXIT
    }

    public static boolean isPrologFinished = false;
    public static boolean isMainFinished = false;
    public static boolean isEpilogFinished = false;

    public static PROCESS_STATE state = PROCESS_STATE.PROLOG;

    // feliratok
    public static final String GRAPHITY_PROLOG_TXT = "B6 KKV 2020";
    public static final String MAINFRAME_TITLE = "KKV irányítási szoftver"
            + " | információs modul programozása"
            + " \"MVP\" megközelítésben";

    public static final String DIALOG_ERROR_TXT = "Hiba";
    public static final String DIALOG_INFO_TXT = "Informació";
    public static final String DIALOG_NAME_TXT = "KKV információs adatbázis";
    public static final String DIALOG_COPYRIGHT_TXT = "A.D. 2020 by EmI";
    public static final String DIALOG_VERSION_TXT = "V. 1.0.0 (Üzi)";
    public static final String DIALOG_NOTFOUND_TXT = "Nincs ilyen!";
    public static final String DIALOG_MYIP_TXT = "A hálózati IP cím";

    // html
    public static final String HTML_START_TXT = "<html>";
    public static final String HTML_CENTER_TXT = "<center>";
    public static final String HTML_CENTER_END = "</center>";
    public static final String HTML_END_TXT = "</html>";
    public static final String HTML_LINEBREAK_TXT = "<br />";

    public static final String STATUS_DB_TXT = " DB csatlakozás > ";
    public static final String STATUS_DB_NOT_FOUND_TXT = " Az adatbázis nem elérhető!";
    public static final String STATUS_CONNECTED_TXT = " Adatbázis rendben";
    public static final String STATUS_LOGGED_IN_TXT = " bejelentkezett";

    public static final String BUTTON_CONNECT_TXT = "Csatlakozás...";
    public static final String BUTTON_CONNECTED_TXT = "Csatlakoztatva";

    public static final String LABEL_USER_TXT = "Név:";
    public static final String TEXTFIELD_TXT = "";
    public static final String BUTTON_LOGIN_TXT = "Tovább...";
    public static final String LABEL_PSWD_TXT = "Jelszó:";
    public static final String PASSWORD_TXT = "";
    public static final String BUTTON_SUBMIT_TXT = "Belépés";

    public static final String ICON_CONNECTED_SOURCE
            = SOURCES_URL + "tool_connected.png";
    public static final ImageIcon ICON_CONNECTED = new ImageIcon(
            XxXx00Global.class.getResource(ICON_CONNECTED_SOURCE));

    public static final String ICON_CLOUD1_SOURCE
            = SOURCES_URL + "db_connect.gif";
    public static final ImageIcon ICON_CLOUD1 = new ImageIcon(
            XxXx00Global.class.getResource(ICON_CLOUD1_SOURCE));
    public static final String ICON_CLOUD2_SOURCE
            = SOURCES_URL + "db_connected.gif";
    public static final ImageIcon ICON_CLOUD2 = new ImageIcon(
            XxXx00Global.class.getResource(ICON_CLOUD2_SOURCE));

    //graphityPanel
    public static final int GRAPHITY_WIDTH = 750;
    public static final int GRAPHITY_HEIGHT = 500;
    public static final String GRAPHITYPROLOG_BG
            = SOURCES_URL + "aGraphity1Prolog.png";
    public static final Image GRAPHITY_PROLOG = new ImageIcon(
            XxXx00Global.class.getResource(GRAPHITYPROLOG_BG)).getImage();
    public static final String GRAPHITYMAIN_BG
            = SOURCES_URL + "aGraphity2Main.png";
    public static final Image GRAPHITY_MAIN = new ImageIcon(
            XxXx00Global.class.getResource(GRAPHITYMAIN_BG)).getImage();
    public static final String GRAPHITYFINALE_BG
            = SOURCES_URL + "aGraphity3Finale.gif";
    public static final Image GRAPHITY_FINALE = new ImageIcon(
            XxXx00Global.class.getResource(GRAPHITYFINALE_BG)).getImage();

    public static final int FINALE_STEPS = 40;
    public static final long FINALE_SLEEPTIME = 40;
    public static final double FINAL_WIDTH = GRAPHITY_WIDTH / 3;
    public static final double FINAL_HEIGHT = 10;

    public static final String SPRITE_SOURCE
            = SOURCES_URL + "sprite.png";
    public static final Image SPRITE = new ImageIcon(
            XxXx00Global.class.getResource(SPRITE_SOURCE)).getImage();
    public static final int SPRITE_WIDTH = GRAPHITY_WIDTH / 8;
    public static final int SPRITE_HEIGHT = GRAPHITY_WIDTH / 4;
    public static final long SPRITE_SLEEPTIME_MAX = 8;
    public static final long SPRITE_SLEEPTIME_MIN = 8;
    public static final long SPRITE_BIRTHTIME_MAX = 1000;
    public static final long SPRITE_BIRTHTIME_MIN = 500;
    public static final int SPRITE_X = GRAPHITY_WIDTH - SPRITE_WIDTH;
    public static final int SPRITE_Y = GRAPHITY_HEIGHT - SPRITE_HEIGHT;
}
