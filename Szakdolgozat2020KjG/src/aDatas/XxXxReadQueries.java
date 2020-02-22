/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aDatas;

import static aGlobal.XxXx00Global.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author b6dmin
 */
public class XxXxReadQueries {

    public static Map<String, String> inputFromFile(String f) {
        Map<String, String> toReturn = new HashMap<>();
        Scanner SC = new Scanner(
                XxXxReadDatas.class.getResourceAsStream(f), CODE_PAGE);
        String s_key;
        String s_query;
        while (SC.hasNext()) {
            s_key = SC.nextLine();
            if (SC.hasNext()) {
                s_query = SC.nextLine();
                while (SC.hasNext() && !s_query.contains(";")) {
                    s_query += System.lineSeparator();
                    s_query += SC.nextLine();
                }
            } else {
                s_query = "";
            }
            toReturn.put(s_key, s_query);
        }
        //System.out.println("Queries: " + toReturn);
        return toReturn;
    }
}
