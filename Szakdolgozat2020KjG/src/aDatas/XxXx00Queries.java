/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aDatas;

import aBasis.XxXx01MySqlResult;
import aBasis.XxXx01SqlAdmin;
import static aGlobal.XxXx00Global.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author b6dmin
 */
public class XxXx00Queries {

    private final Map<String, String> ListQueries;

    public XxXx00Queries() {
        ListQueries = XxXxReadQueries.inputFromFile(LIST00_QUERIES);
    }

    public String[] list_all_usernames() {
        String query = ListQueries.get("list_all_usernames");
        List arguments = new ArrayList();
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        XxXx01MySqlResult result
                = (XxXx01MySqlResult) mySqlAdmin.executeQuery(query, arguments);
        System.out.println("result> " + result.toString());
        List<Object[]> myresult = result.getRsTable();
        int index = myresult.size();
        String[] toReturn = new String[index];
        for (int ii = 0; ii < index; ii++) {
            Object[] row = myresult.get(ii);
            toReturn[ii] = row[0].toString();
        }
        return toReturn;
    }
}
