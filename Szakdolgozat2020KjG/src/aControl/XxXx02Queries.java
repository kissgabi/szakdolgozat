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
import static aGlobal.XxXx02Global.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author b6dmin
 */
public class XxXx02Queries {

    private final Map<String, String> ListQueries;

    public XxXx02Queries() {
        ListQueries = XxXxReadQueries.inputFromFile(LIST02_QUERIES);
    }

    public String broadcast_username() {
        String query = ListQueries.get("broadcast_username");
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        List arguments = new ArrayList();
        XxXx01MySqlResult result
                = (XxXx01MySqlResult) mySqlAdmin.executeQuery(query, arguments);
        Object[] row = result.getRsTable().get(0);
        return row[0].toString();
    }

    private XxXx01MySqlResult resultTable(String query, List arguments) {
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        XxXx01MySqlResult result
                = (XxXx01MySqlResult) mySqlAdmin.executeQuery(query, arguments);
        // System.out.println("result> " + result.toString());
        return result;
    }

    public XxXx01MySqlResult list_all_messages() {
        String query = ListQueries.get("list_all_messages");
        List arguments = new ArrayList();
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_partner_messages(String p) {
        String query = ListQueries.get("list_partner_messages");
        List arguments = new ArrayList();
        arguments.add(p);
        arguments.add(p);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_memo_messages() {
        String query = ListQueries.get("list_memo_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(executorName);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_all_messages() {
        String query = ListQueries.get("list_employee_all_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(executorName);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_partner_messages(String p) {
        String query = ListQueries.get("list_employee_partner_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(p);
        arguments.add(p);
        arguments.add(executorName);
        arguments.add(p);
        arguments.add(MSGTAB_BROADCAST_USERNAME);
        arguments.add(executorName);
        arguments.add(MSGTAB_BROADCAST_USERNAME);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_all_in_messages() {
        String query = ListQueries.get("list_employee_all_in_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(executorName);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_partner_in_messages(String p) {
        String query = ListQueries.get("list_employee_partner_in_messages");
        List arguments = new ArrayList();
        arguments.add(p);
        arguments.add(executorName);
        arguments.add(p);
        arguments.add(MSGTAB_BROADCAST_USERNAME);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_partner_in_messages(String p) {
        String query = ListQueries.get("list_partner_in_messages");
        List arguments = new ArrayList();
        arguments.add(p);
        arguments.add(p);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_all_out_messages() {
        String query = ListQueries.get("list_employee_all_out_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_employee_partner_out_messages(String p) {
        String query = ListQueries.get("list_employee_partner_out_messages");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(p);
        arguments.add(executorName);
        arguments.add(MSGTAB_BROADCAST_USERNAME);
        return resultTable(query, arguments);
    }

    public XxXx01MySqlResult list_partner_out_messages(String p) {
        String query = ListQueries.get("list_partner_out_messages");
        List arguments = new ArrayList();
        arguments.add(p);
        return resultTable(query, arguments);
    }

    public int push_message(String t, String m) {
        String query = ListQueries.get("push_message");
        List arguments = new ArrayList();
        arguments.add(executorName);
        arguments.add(t);
        arguments.add(m);
        XxXx01SqlAdmin mySqlAdmin
                = new XxXx01SqlAdmin(kkv_db(), dbUsername, dbPassword);
        return (int) mySqlAdmin.executeQuery(query, arguments);
    }
}
