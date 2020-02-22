/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aSurfaces;

import aControl.XxXx00Control;
import static aGlobal.XxXx00Global.*;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author b6dmin
 */
public class XxXx00ControlPanel extends javax.swing.JPanel {

    private XxXx00Control c;

    public void setControl(XxXx00Control c) {
        this.c = c;
    }

    public void setup() {
        System.out.println("XxXxControlPanel: "
                + this.getWidth() + "x" + this.getHeight());
    }

//        jTabbedPane1.setEnabledAt(0, true);
//        jTabbedPane1.setEnabledAt(1, false);
//        jTabbedPane1.setSelectedIndex(0);
    public void selectPanel(JPanel p) {
        if (p.isDisplayable()) {
            jTabbedPane1.setSelectedComponent(p);
        }
    }

    public void addPanel(String name, JPanel panel) {
        jTabbedPane1.add(name, panel);
    }

    public void removePanel(JPanel panel) {
        jTabbedPane1.remove(panel);
    }

    public void removePanels() {
        int count = jTabbedPane1.getTabCount();
        for (int ii = 0; ii < count; ii++) {
            jTabbedPane1.remove(0);
        }
    }

    /**
     * Creates new form XxXxSuperUserPanel
     */
    public XxXx00ControlPanel() {
        System.out.println("<XxXxControlPanel>");
        initComponents();
        super.setPreferredSize(new Dimension(GRAPHITY_WIDTH, GRAPHITY_HEIGHT));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout(5, 5));
        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}