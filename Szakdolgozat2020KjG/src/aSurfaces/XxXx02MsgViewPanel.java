/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aSurfaces;

import aBasis.XxXx01MySqlResult;
import aControl.XxXx02Control;
import static aGlobal.XxXx00Global.*;
import static aGlobal.XxXx02Global.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author b6dmin
 */
public class XxXx02MsgViewPanel extends javax.swing.JPanel {

    public static final Color LIGHT_GRAY1 = new Color(224, 224, 224);
    public static final Color LIGHT_GRAY2 = new Color(208, 208, 208);
    public static final Color LIGHT_GRAY3 = new Color(192, 192, 192);

    class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, null,
                    index, isSelected, cellHasFocus);
            String myHtmlText = ((String) value).
                    replaceAll("\n", " ").replaceAll("\r", " ");
            if (index % 3 == 0) {
                this.setBackground(LIGHT_GRAY1);
            } else if ((index + 1) % 3 == 0) {
                this.setBackground(LIGHT_GRAY2);
            } else {
                this.setBackground(LIGHT_GRAY3);
            }
            if (isSelected) {
                this.setForeground(Color.WHITE);
                this.setBackground(Color.DARK_GRAY);
            }
            this.setText(myHtmlText);
            setOpaque(true);
            return this;
        }
    }

    private XxXx02Control c;

    public void setControl(XxXx02Control c) {
        this.c = c;
    }

    public void setup() {
        System.out.println("XxXxMsgViewPanel: "
                + this.getWidth() + "x" + this.getHeight());
        lblUser.setText(MSGTAB_LABEL_PARTNER_TXT);
        lblMessages.setText(MSGTAB_LABEL_MESSAGES_TXT);
        rBtnAll.setText(MSGTAB_RADIOBUTTON_ALL);
        rBtnIn.setText(MSGTAB_RADIOBUTTON_IN);
        rbtnOut.setText(MSGTAB_RADIOBUTTON_OUT);
    }

    private final DefaultListModel<String> msgListModel;
    private final DefaultComboBoxModel<String> userComboListModel;

    private String comboSelectedString;
    private int listSelectedSIndex;

    private XxXx01MySqlResult actualResult;

    public void resetRadioButtons() {
        rBtnAll.setSelected(true);
    }

    public void resetUserList() {
        comboUserList.setSelectedIndex(0);
    }

    /**
     * Creates new form XxXxMsgViewPanel
     */
    public XxXx02MsgViewPanel() {
        System.out.println("<XxXxMsgViewPanel>");
        initComponents();
        msgListModel = new DefaultListModel<>();
        listMessages.setModel(msgListModel);
        listMessages.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMessages.setCellRenderer(new XxXx02MsgViewPanel.MyCellRenderer());
        userComboListModel = new DefaultComboBoxModel<>();
        comboUserList.setModel(userComboListModel);
    }

    public void fillMsgList(XxXx01MySqlResult result) {
        actualResult = result;
        int tableSize = result.getRsTable().size();
        msgListModel.clear();
        for (int ii = 0; ii < tableSize; ii++) {
            msgListModel.addElement(result.viewLine(ii));
        }
    }

    public void fillUserList(String[] list) {
        comboUserList.removeAllItems();
        comboUserList.addItem(STAR);
        for (String s : list) {
            if (!s.equals(MSGTAB_BROADCAST_USERNAME)) {
                comboUserList.addItem(s);
            }
        }
    }

    private void switchMessage(String p) {
        System.out.println("> " + this.getName());
        if (rBtnAll.isSelected()) {
            c.XxXx02SelectMessages(p, this.getName());
        } else if (rBtnIn.isSelected()) {
            c.XxXx02SelectMessagesIn(p, this.getName());
        } else if (rbtnOut.isSelected()) {
            c.XxXx02MessagesOut(p, this.getName());
        } else {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btngroupMessages = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        comboUserList = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblMessages = new javax.swing.JLabel();
        rBtnAll = new javax.swing.JRadioButton();
        rBtnIn = new javax.swing.JRadioButton();
        rbtnOut = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMessages = new javax.swing.JList<>();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblUser.setText("lblUser");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(lblUser, gridBagConstraints);

        comboUserList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUserList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUserListItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 5.0;
        jPanel1.add(comboUserList, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lblMessages.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMessages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessages.setText("lblMessages");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 6.0;
        jPanel3.add(lblMessages, gridBagConstraints);

        btngroupMessages.add(rBtnAll);
        rBtnAll.setSelected(true);
        rBtnAll.setText("rBtnAll");
        rBtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(rBtnAll, gridBagConstraints);

        btngroupMessages.add(rBtnIn);
        rBtnIn.setText("rBtnIn");
        rBtnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnInActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(rBtnIn, gridBagConstraints);

        btngroupMessages.add(rbtnOut);
        rbtnOut.setText("rBtnOut");
        rbtnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(rbtnOut, gridBagConstraints);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        listMessages.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listMessages.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listMessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listMessagesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listMessagesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listMessages);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void comboUserListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUserListItemStateChanged
        String item = (String) evt.getItem();
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            //System.out.println("comboSelected: " + comboSelectedString);
            //System.out.println("item: " + item);
            if (!item.equals(comboSelectedString)) {
                switchMessage(item);
            }
        }
        comboSelectedString = item;
    }//GEN-LAST:event_comboUserListItemStateChanged

    private void rBtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnAllActionPerformed
        switchMessage(comboUserList.getSelectedItem().toString());
    }//GEN-LAST:event_rBtnAllActionPerformed

    private void rBtnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnInActionPerformed
        switchMessage(comboUserList.getSelectedItem().toString());
    }//GEN-LAST:event_rBtnInActionPerformed

    private void rbtnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOutActionPerformed
        switchMessage(comboUserList.getSelectedItem().toString());
    }//GEN-LAST:event_rbtnOutActionPerformed

    private void listMessagesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMessagesMousePressed
        listSelectedSIndex = listMessages.getSelectedIndex();
    }//GEN-LAST:event_listMessagesMousePressed

    private void listMessagesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMessagesMouseReleased
        if (listSelectedSIndex == listMessages.getSelectedIndex()) {
            c.showMessageInDialog(actualResult.
                    getRsTable().get(listSelectedSIndex));
        }
        listMessages.clearSelection();
    }//GEN-LAST:event_listMessagesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngroupMessages;
    private javax.swing.JComboBox<String> comboUserList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessages;
    private javax.swing.JLabel lblUser;
    private javax.swing.JList<String> listMessages;
    private javax.swing.JRadioButton rBtnAll;
    private javax.swing.JRadioButton rBtnIn;
    private javax.swing.JRadioButton rbtnOut;
    // End of variables declaration//GEN-END:variables
}