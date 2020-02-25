/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aDatas;

import aBasis.XxXx01DataObject;
import static aGlobal.XxXx00Global.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author b6dmin
 */
public class XxXxReadDatas {

    public static List<XxXx01DataObject> inputFromFile() {
        List<XxXx01DataObject> toReturn = new ArrayList<>();
        Scanner SC = new Scanner(
                XxXxReadDatas.class.getResourceAsStream(LIST_DATAS), CODE_PAGE);
        String line = "";
        String[] data;
        try {
            while (SC.hasNext()) {
                line = SC.nextLine();
                data = line.split(SPLIT_REGEX);
                if (data.length == 3) {
                    System.out.println("> " + line);
                } else {
                    throw MyException(EX_DATAERROR);
                }
                XxXx01DataObject dataline = new XxXx01DataObject(data[0],
                        Integer.valueOf(data[1]),
                        Integer.valueOf(data[2]));
                toReturn.add(dataline);
            }
        } catch (NumberFormatException e) {
            System.out.println(EX_ERROR + line);
        } catch (java.lang.Exception ex) {
            System.out.println("> " + ex.getMessage());
        }
        return toReturn;
    }

    private static Exception MyException(String str) {
        return new Exception(str);
    }
}
