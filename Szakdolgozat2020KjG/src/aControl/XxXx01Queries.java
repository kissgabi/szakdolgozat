/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import aBasis.XxXx01MySqlResult;
import aBasis.XxXx01SqlAdmin;
import aDatas.XxXxReadQueries;
import static aGlobal.XxXx00Global.*;
import static aGlobal.XxXx01Global.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author b6dmin
 */
public class XxXx01Queries {

    private final Map<String, String> ListQueries;

    public XxXx01Queries() {
        ListQueries = XxXxReadQueries.inputFromFile(LIST01_QUERIES);
    }

    public int valid_username_usegroup(String name) {
        String query = ListQueries.get("valid_username_usegroup");
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        List arguments = new ArrayList();
        arguments.add(name);
        XxXx01MySqlResult result
                = (XxXx01MySqlResult) mySqlAdmin.executeQuery(query, arguments);
        //System.out.println("result> " + result.toString());
        if (result.getRsTable().isEmpty()) {
            return 0;
        }
        Object[] row = result.getRsTable().get(0);
        return Integer.valueOf(row[0].toString());
    }

    public int valid_password_usergroup(String name, String password) {
        String query = ListQueries.get("valid_password_usergroup");
        List arguments = new ArrayList();
        arguments.add(name);
        arguments.add(password);
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        XxXx01MySqlResult result
                = (XxXx01MySqlResult) mySqlAdmin.executeQuery(query, arguments);
        //System.out.println("result> " + result.toString());
        if (result.getRsTable().isEmpty()) {
            return 0;
        }
        Object[] row = result.getRsTable().get(0);
        return Integer.valueOf(row[0].toString());
    }
}
