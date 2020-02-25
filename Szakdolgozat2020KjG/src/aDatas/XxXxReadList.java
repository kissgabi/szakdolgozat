/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aDatas;

import aBasis.XxXx01UserGroup;
import static aGlobal.XxXx00Global.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author b6dmin
 */
public class XxXxReadList {

    public static List<XxXx01UserGroup> inputFromFile() {
        List<XxXx01UserGroup> toReturn = new ArrayList<>();
        Scanner SC = new Scanner(
                XxXxReadDatas.class.getResourceAsStream(LIST_USERS), CODE_PAGE);
        String line;
        String[] data;
        try {
            while (SC.hasNext()) {
                line = SC.nextLine();
                data = line.split(SPLIT_REGEX);
                if (data.length == 3) {
                    XxXx01UserGroup usergroup
                            = new XxXx01UserGroup(data[0], data[1], data[2]);
                    toReturn.add(usergroup);
                    System.out.println("> " + usergroup.toString());
                } else {
                    throw MyException(EX_DATAERROR);
                }
            }
        } catch (java.lang.Exception ex) {
            System.out.println("> " + ex.getMessage());
        }
        return toReturn;
    }

    private static Exception MyException(String str) {
        return new Exception(str);
    }
}
