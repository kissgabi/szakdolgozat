/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aBasis;

import static aGlobal.XxXx00Global.*;
import static aGlobal.XxXx02Global.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author b6dmin
 */
public class XxXx01MySqlResult {

    private int rsNumberOfColumns;
    private String[] rsNameOfColumns;
    private int[] rsMaxSizeOfColumns;

    private final List<Object[]> rsTable;

    public int getRsNumberOfColumns() {
        return rsNumberOfColumns;
    }

    public void setRsNumberOfColumns(int rsNumberOfColumns) {
        this.rsNumberOfColumns = rsNumberOfColumns;
    }

    public String[] getRsNameOfColumns() {
        return rsNameOfColumns;
    }

    public void setRsNameOfColumns(String[] rsNameOfColumns) {
        this.rsNameOfColumns = rsNameOfColumns;
    }

    public int[] getRsMaxSizeOfColumns() {
        return rsMaxSizeOfColumns;
    }

    public void setRsMaxSizeOfColumns(int[] rsMaxSizeOfColumns) {
        this.rsMaxSizeOfColumns = rsMaxSizeOfColumns;
    }

    public Object[] getRowFromTable(int i) {
        return rsTable.get(i);
    }

    public void addRowToTable(Object[] rsRow) {
        rsTable.add(rsRow);
    }

    public List<Object[]> getRsTable() {
        return rsTable;
    }

    public XxXx01MySqlResult() {
        rsTable = new ArrayList<>();
    }

    public String viewLine(int ii) {
        String toReturn = "";
        Object[] row = rsTable.get(ii);
        String format;

        toReturn += row[0].toString().substring(0, MSGTAB_MESSAGES_DATE_LENGTH);
        toReturn += CELL_DELIMITER;

        String row1 = row[1].toString();
        format = " %" + (MSGTAB_MESSAGES_HEAD_LENGTH + 3) + "s ";
        if (row1.length() > MSGTAB_MESSAGES_HEAD_LENGTH) {
            int end = row1.lastIndexOf(" ", MSGTAB_MESSAGES_HEAD_LENGTH - 3);
            if (end == -1) {
                end = MSGTAB_MESSAGES_HEAD_LENGTH;
            }
            format = " %" + MSGTAB_MESSAGES_HEAD_LENGTH + "s" + ELLIPSIS + " ";
            row1 = row1.substring(0, end);
        }
        toReturn += String.format(format, row1);
        toReturn += CELL_DELIMITER;

        format = " %" + this.getRsMaxSizeOfColumns()[2] + "s ";
        toReturn += String.format(format, row[2].toString()) + TO;

        format = " %" + this.getRsMaxSizeOfColumns()[3] + "s ";
        String row3 = row[3].toString();
        if (row3.equals(MSGTAB_BROADCAST_USERNAME)) {
            row3 = MSGTAB_BROADCAST_TXT;
        }
        toReturn += String.format(format, row3);
        return toReturn;
    }

    @Override
    public String toString() {
        String rsTableString = "";
        for (Object[] row : rsTable) {
            rsTableString += Arrays.toString(row) + System.lineSeparator();
        }
        return "rsNumberOfColumns=" + rsNumberOfColumns
                + System.lineSeparator()
                + ", rsNameOfColumns=" + Arrays.toString(rsNameOfColumns)
                + System.lineSeparator()
                + ", rsMaxSizeOfColumns=" + Arrays.toString(rsMaxSizeOfColumns)
                + System.lineSeparator()
                + ", rsTable=" + rsTableString;
    }
}
