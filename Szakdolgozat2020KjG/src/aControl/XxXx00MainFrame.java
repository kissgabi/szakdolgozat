/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import static aGlobal.XxXx00Global.*;
import java.awt.Dimension;
import javax.swing.Box;

/**
 *
 * @author b6dmin
 */
public class XxXx00MainFrame extends javax.swing.JFrame {

    private XxXx00Control c;

    public void setControl(XxXx00Control c) {
        xxXxGraphityPanel1.setControl(c);
        xxXxControlPanel1.setControl(c);
    }

    void setup() {
        System.out.println("mainFrame: "
                + this.getWidth() + "x" + this.getHeight());
        statusBarSetText("");
        btnConnect.setText(BUTTON_CONNECT_TXT);
        xxXxGraphityPanel1.setup();
        xxXxControlPanel1.setup();
    }

    private double stepX = 0.0, stepY = 0.0;

    public void startFinale() {
        setJMenuBar(null);
        getContentPane().remove(mainToolBar);
        getContentPane().remove(mainStatusBar);
        this.dispose();
        this.setUndecorated(true);
        this.pack();
        graphityPanelOn();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        stepX = (double) (this.getWidth() - FINAL_WIDTH) / FINALE_STEPS;
        stepY = (double) (this.getHeight() - FINAL_HEIGHT) / FINALE_STEPS;
        System.out.println("> " + stepX + " : " + stepY);
    }

    public void resize(int xy) {
        this.setSize(
                new Dimension((int) (stepX * (FINALE_STEPS - xy) + FINAL_WIDTH),
                        (int) (stepY * (FINALE_STEPS - xy) + FINAL_HEIGHT)));
        this.setLocationRelativeTo(null);
    }

    public void graphityPanelOn() {
        panelsOff();
        if (!xxXxGraphityPanel1.isDisplayable()) {
            xxXxGraphityPanel1.setVisible(true);
            getContentPane().add(xxXxGraphityPanel1);
            this.pack();
        }
    }

    public void graphityPanelOff() {
        if (xxXxGraphityPanel1.isDisplayable()) {
            xxXxGraphityPanel1.setVisible(false);
            getContentPane().remove(xxXxGraphityPanel1);
            this.pack();
        }
    }

    public void controlPanelOn() {
        if (!xxXxControlPanel1.isDisplayable()) {
            xxXxControlPanel1.setVisible(true);
            getContentPane().add(xxXxControlPanel1);
            this.pack();
        }
    }

    public void controlPanelOff() {
        if (xxXxControlPanel1.isDisplayable()) {
            xxXxControlPanel1.setVisible(false);
            getContentPane().remove(xxXxControlPanel1);
            this.pack();
        }
    }

    public void logOutOn() {
        menuMain.add(itemLogout, 1);
        menuMain.add(jSeparator1, 2);
        menuMain.add(itemExit);
        mainToolBar.add(btnLogOut, 1);
        mainToolBar.repaint();
    }

    public void logOff() {
        menuMain.remove(itemLogout);
        menuMain.remove(jSeparator1);
        mainToolBar.remove(btnLogOut);
        mainToolBar.repaint();
    }

    public void statusBarSetText(String s) {
        s = STATUS_DB_TXT + s;
        lblDbStatus.setText(s);
    }

    public void dbConnected() {
        statusBarSetText(STATUS_CONNECTED_TXT);
        btnConnect.setText(BUTTON_CONNECTED_TXT);
        btnConnect.setIcon(ICON_CONNECTED);
        btnDbase.setIcon(ICON_CLOUD2);
    }

    private void panelsOff() {
        controlPanelOff();
    }

    /**
     * Creates new form XxXxMainFrame
     */
    public XxXx00MainFrame() {
        System.out.println("<MainFrame>");
        initComponents();
        super.setTitle(MAINFRAME_TITLE);
        super.setResizable(false);
        mainMenuBar.remove(menuAbout);
        mainMenuBar.add(Box.createHorizontalGlue());
        mainMenuBar.add(menuAbout);
        mainToolBar.remove(btnDbase);
        mainToolBar.remove(btnConnect);
        mainToolBar.add(Box.createHorizontalGlue());
        mainToolBar.add(btnConnect);
        mainToolBar.add(Box.createHorizontalGlue());
        mainToolBar.add(btnDbase);
    }

    private void start() {
        panelsOff();
        logOff();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.c = new XxXx00Control(this,
                xxXxControlPanel1,
                xxXxGraphityPanel1);
        setControl(c);
        c.setup();
        System.out.println("</MainFrame>");
        c.startProlog();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainToolBar = new javax.swing.JToolBar();
        btnExit = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();
        btnDbase = new javax.swing.JButton();
        xxXxControlPanel1 = new aSurfaces.XxXx00ControlPanel();
        xxXxGraphityPanel1 = new aSurfaces.XxXx00GraphityPanel();
        mainStatusBar = new javax.swing.JPanel();
        lblDbStatus = new javax.swing.JLabel();
        mainMenuBar = new javax.swing.JMenuBar();
        menuMain = new javax.swing.JMenu();
        itemLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemExit = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        itemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainToolBar.setRollover(true);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/tool_exit.png"))); // NOI18N
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        mainToolBar.add(btnExit);

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/tool_logout.png"))); // NOI18N
        btnLogOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogOut.setFocusable(false);
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        mainToolBar.add(btnLogOut);

        btnConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/tool_connect.gif"))); // NOI18N
        btnConnect.setText("Auto connect");
        btnConnect.setFocusable(false);
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        mainToolBar.add(btnConnect);

        btnDbase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/db_connect.gif"))); // NOI18N
        btnDbase.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDbase.setFocusable(false);
        btnDbase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDbase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDbase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDbaseActionPerformed(evt);
            }
        });
        mainToolBar.add(btnDbase);

        getContentPane().add(mainToolBar, java.awt.BorderLayout.NORTH);
        getContentPane().add(xxXxControlPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(xxXxGraphityPanel1, java.awt.BorderLayout.CENTER);

        mainStatusBar.setLayout(new java.awt.BorderLayout());

        lblDbStatus.setText("DB connect > ");
        mainStatusBar.add(lblDbStatus, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainStatusBar, java.awt.BorderLayout.PAGE_END);

        menuMain.setMnemonic('M');
        menuMain.setText("Menü");
        menuMain.setActionCommand("Menu");

        itemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        itemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/menu_logout.png"))); // NOI18N
        itemLogout.setText("Kijelentkezés");
        itemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogoutActionPerformed(evt);
            }
        });
        menuMain.add(itemLogout);
        menuMain.add(jSeparator1);

        itemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/menu_exit.png"))); // NOI18N
        itemExit.setText("Kilépés");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        menuMain.add(itemExit);

        mainMenuBar.add(menuMain);
        menuMain.getAccessibleContext().setAccessibleName("Menu");

        menuAbout.setMnemonic('I');
        menuAbout.setText("                                            i! ");

        itemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_HOME, java.awt.event.InputEvent.ALT_MASK));
        itemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aSources/menu_info.png"))); // NOI18N
        itemAbout.setMnemonic('I');
        itemAbout.setText("Info");
        itemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAboutActionPerformed(evt);
            }
        });
        menuAbout.add(itemAbout);

        mainMenuBar.add(menuAbout);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        c.startFinale();
    }//GEN-LAST:event_btnExitActionPerformed

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        c.startFinale();
    }//GEN-LAST:event_itemExitActionPerformed

    private void itemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAboutActionPerformed
        c.dialogInfo();
    }//GEN-LAST:event_itemAboutActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed

    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDbaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDbaseActionPerformed
        c.dialogHost();
    }//GEN-LAST:event_btnDbaseActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        c.restartMainProcess();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
        c.restartMainProcess();
    }//GEN-LAST:event_itemLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XxXx00MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XxXx00MainFrame().start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDbase;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JMenuItem itemAbout;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblDbStatus;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainStatusBar;
    private javax.swing.JToolBar mainToolBar;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuMain;
    private aSurfaces.XxXx00ControlPanel xxXxControlPanel1;
    private aSurfaces.XxXx00GraphityPanel xxXxGraphityPanel1;
    // End of variables declaration//GEN-END:variables
}
