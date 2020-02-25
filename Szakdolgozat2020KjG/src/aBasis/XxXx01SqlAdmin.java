/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aBasis;

import aControl.XxXx00Control;
import static aGlobal.XxXx00Global.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author b6dmin
 */
public class XxXx01SqlAdmin {

    private static XxXx00Control c;

    public static void setControl(XxXx00Control c) {
        XxXx01SqlAdmin.c = c;
    }

    /**
     * variables for opening and managing connection
     *
     * boolean connected
     *
     * String dbUrl, String user, String password
     */
    private boolean dbClosed = false;
    private boolean dbReady = false;
    private String dbUrl = URL1 + URL2;
    private String userName = USER;
    private String password = PSWD;

    public boolean isDbReady() {
        return dbReady;
    }

    public boolean isDbClosed() {
        return dbClosed;
    }

    private List<String> mySqlDatabases = new ArrayList<>();

    private void startDb() {
        mySqlDatabases = Arrays.asList(
                "information_schema",
                "mysql",
                "performance_schema",
                "phpmyadmin",
                "test");
        try (Connection conn
                = DriverManager.getConnection(dbUrl, userName, password);
                PreparedStatement stmt
                = conn.prepareStatement(SHOW_DBASES_QUERY);
                ResultSet results
                = stmt.executeQuery()) {
            while (results.next()) {
                String database = results.getString(1);
                if (!mySqlDatabases.contains(database)) {
                    System.out.println(database);
                }
            }
            dbReady = true;
        } catch (SQLException ex) {
            dbReady = false;
            System.out.println(ex.getMessage() + "\n");
            //c.showError(ex.getMessage());
        }
        dbClosed = true;
    }

    /**
     * connect to database as default root user
     *
     * user: root, password: "", url: "jdbc:mysql://localhost:3306/"
     */
    public XxXx01SqlAdmin() {
        startDb();
    }

    /**
     * connect to a far database as default root user
     *
     * user: root, password: ""
     *
     * @param url - dbUrl
     */
    public XxXx01SqlAdmin(String url) {
        this.dbUrl = url;
        startDb();
    }

    /**
     * connect to database as user with password
     *
     * url: "jdbc:mysql://localhost:3306/"
     *
     * @param user - username
     * @param pswd - password
     */
    public XxXx01SqlAdmin(String user, String pswd) {
        this.userName = user;
        this.password = pswd;
        startDb();
    }

    /**
     * connect to database as user with password
     *
     * url: "jdbc:mysql://localhost:3306/"
     *
     * @param url - dbUrl
     * @param user - username
     * @param pswd - password
     */
    public XxXx01SqlAdmin(String url, String user, String pswd) {
        this.dbUrl = url;
        this.userName = user;
        this.password = pswd;
        startDb();
    }

    private void rsMetaData(ResultSet rs) throws SQLException {
        ResultSetMetaData rsMeta = rs.getMetaData();
        rsColumnNumber = rsMeta.getColumnCount();
        rsColumNames = new String[rsColumnNumber];
        rsMaxCellWidth = new int[rsColumnNumber];
        for (int ii = 1; ii <= rsColumnNumber; ii++) {
            rsColumNames[ii - 1] = (rsMeta.getColumnLabel(ii));
            rsMaxCellWidth[ii - 1] = rsColumNames[ii - 1].length();
        }
        while (rs.next()) {
            for (int ii = 0; ii < rsColumnNumber; ii++) {
                String r = rs.getString(ii + 1);
                if (rsMaxCellWidth[ii] < r.length()) {
                    rsMaxCellWidth[ii] = r.length();
                }
            }
        }
        rs.beforeFirst();
    }

    private int rsColumnNumber;
    private String[] rsColumNames;
    private int[] rsMaxCellWidth;

    public Object executeQuery(String s_query, List arguments) {
        Object toReturn;
        try (Connection conn = DriverManager.
                getConnection(this.dbUrl, this.userName, this.password);
                PreparedStatement ps = conn.prepareStatement(s_query)) {

            int index = 0;
            for (Object argument : arguments) {
                index++;
                if (argument instanceof String) {
                    ps.setString(index, (String) argument);
                    System.out.println("String> " + index + ", " + argument);
                } else if (argument instanceof Integer) {
                    ps.setInt(index, (int) argument);
                    System.out.println("Integer> " + index + ", " + argument);
                }
            }
            boolean status = ps.execute();
            if (status) {
                toReturn = new XxXx01MySqlResult();
                try (ResultSet rs = ps.getResultSet()) {
                    rsMetaData(rs);

                    ((XxXx01MySqlResult) toReturn).setRsNumberOfColumns(rsColumnNumber);
                    ((XxXx01MySqlResult) toReturn).setRsNameOfColumns(rsColumNames);
                    ((XxXx01MySqlResult) toReturn).setRsMaxSizeOfColumns(rsMaxCellWidth);

                    Object[] row;
                    while (rs.next()) {
                        row = new Object[rsColumnNumber];
                        for (int ii = 0; ii < rsColumnNumber; ii++) {
                            row[ii] = rs.getString(ii + 1);
                        }
                        ((XxXx01MySqlResult) toReturn).addRowToTable(row);
                    }
                }
            } else {
                toReturn = ps.getUpdateCount();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return toReturn;
    }
}
