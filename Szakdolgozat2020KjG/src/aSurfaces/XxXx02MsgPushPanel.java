/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aSurfaces;

import aControl.XxXx02Control;
import static aGlobal.XxXx02Global.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author b6dmin
 */
public class XxXx02MsgPushPanel extends javax.swing.JPanel {

    private XxXx02Control c;

    public void setControl(XxXx02Control c) {
        this.c = c;
    }

    public void setup() {
        System.out.println("XxXxMsgWritePanel: "
                + this.getWidth() + "x" + this.getHeight());
        lblTarget.setText(MSGTAB_LABEL_ADDRESSEE_TXT);
        lblMessage.setText(MSGTAB_WRITE_MESSAGES_TXT);
        btnSendMessage.setText(MSGTAB_SEND_MESSAGES_TXT);
    }

    private final DefaultComboBoxModel<String> targetComboListModel;

    /**
     * Creates new form XxXxMsgWritePanel
     */
    public XxXx02MsgPushPanel() {
        System.out.println("<XxXxMsgWritePanel>");
        initComponents();
        targetComboListModel = new DefaultComboBoxModel<>();
        comboTargetList.setModel(targetComboListModel);
    }

    public void fillTargetList(String[] list) {
        comboTargetList.removeAllItems();
        comboTargetList.addItem(MSGTAB_NOBODY_TXT);
        for (String s : list) {
            if (!s.equals(MSGTAB_BROADCAST_USERNAME)) {
                comboTargetList.addItem(s);
            }
        }
        comboTargetList.addItem(MSGTAB_BROADCAST_TXT);
    }

    public void clearTextfield() {
        textMessage.setText("");
    }

    public void enablePush(boolean b) {
        btnSendMessage.setEnabled(b);
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

        jPanel4 = new javax.swing.JPanel();
        lblTarget = new javax.swing.JLabel();
        comboTargetList = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textMessage = new javax.swing.JTextArea();
        btnSendMessage = new javax.swing.JButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblTarget.setText("lblTarget");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(lblTarget, gridBagConstraints);

        comboTargetList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.weightx = 5.0;
        jPanel4.add(comboTargetList, gridBagConstraints);

        add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        lblMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("lblMessage");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel6.add(lblMessage, gridBagConstraints);

        jPanel5.add(jPanel6, java.awt.BorderLayout.NORTH);

        textMessage.setColumns(20);
        textMessage.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textMessage.setRows(5);
        textMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMessageKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(textMessage);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        btnSendMessage.setText("btnSendMessage");
        btnSendMessage.setEnabled(false);
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });
        jPanel5.add(btnSendMessage, java.awt.BorderLayout.PAGE_END);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        //System.out.println("target> " + comboTargetList.getSelectedItem().toString());
        //System.out.println("message> " + textMessage.getText());
        c.XxXx02PushMessages(comboTargetList.getSelectedItem().toString(),
                textMessage.getText());
    }//GEN-LAST:event_btnSendMessageActionPerformed

    private void textMessageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMessageKeyTyped
        if (textMessage.getText().length() >= MSGTAB_MESSAGES_MIN_LENGTH) {
            c.messageEnable();
        }
    }//GEN-LAST:event_textMessageKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JComboBox<String> comboTargetList;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTarget;
    private javax.swing.JTextArea textMessage;
    // End of variables declaration//GEN-END:variables
}
