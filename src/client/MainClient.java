/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import model.Message;
import model.Status;

/**
 *
 * @author Asus
 */
public class MainClient extends javax.swing.JFrame {

    /**
     * Creates new form MainClient
     */
    public int i = 0;
    public String ipAddress;
    public int port;
    private model.Client client;
    private volatile boolean running = true;
    Thread t;
    String tenchat;

    public MainClient() {
        initComponents();
        setTitle("AppChat1Vs1");
        ipAddress = "localhost";
        port = 666;
        jTextArea1.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(Color.yellow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextField1.setBackground(java.awt.Color.cyan);
        jTextField1.setFont(new java.awt.Font("Vinhan", 3, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "T??n c???a b???n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 3, 14))); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "N???i dung chat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 2, 14))); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jTextField2.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nh???p tin nh???n"));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel1.setText("Nh??p T??n");

        jLabel2.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel2.setText("Nh???n Tin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (client != null) {
            try {
                running = false;
                Message send = new Message(null, null, Status.EXIT);
                System.out.println(send);
                client.sendMessage(send);
                client.closeAll();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                if (client == null) {
                    if (!jTextField1.getText().equals("")) {
                        client = new model.Client(new Socket(ipAddress, port), jTextField1.getText());
                        Message welcome = new Message(jTextField1.getText(), null, Status.CONNECT);
                        client.sendMessage(welcome);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nh???p t??n ng?????i chat", "Th??ng b??o",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                } else {
                    Message welcome = new Message(jTextField1.getText(), null, Status.CONNECT);
                    client.sendMessage(welcome);
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (i == 0) {
                t = new Thread(() -> {
                    while (running) {
                        // TODO Auto-generated method stub
                        try {
                            Message receivedMessage = client.receiveMessage();
                            System.out.println(receivedMessage);
                            switch (receivedMessage.getStatus()) {
                                case MATCH:
                                    tenchat=receivedMessage.getName();
                                    int action = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n gh??p ????i v???i  " + receivedMessage.getName() + "?",
                                            "Gh??p ????i thanh c??ng", JOptionPane.YES_NO_OPTION);
                                    if (action == JOptionPane.OK_OPTION) {
                                        Message accept = new Message(client.getName(), null, Status.OK);
                                        client.sendMessage(accept);
                                        client.setMatched(true);
                                    } else {
                                        Message refuse = new Message(client.getName(), null, Status.REFUSE);
                                        client.sendMessage(refuse);
                                    }
                                    break;
                                case CHAT:
                                    jTextArea1.append(
                                            receivedMessage.getName() + " n??i v???i b???n: " + receivedMessage.getData() + "\n");
                                    break;
                                case EXIST:
                                    JOptionPane.showMessageDialog(null, "T??n tr??ng v???i ng?????i kh??c", "Th??ng b??o",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                case UNMATCH:
                                    JOptionPane.showMessageDialog(null,
                                            "Ng?????i kia ???? t??? ch???i gh??p ????i, b???n s??? quay l???i h??ng ch??? !",
                                            "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
                                    client.setMatched(false);
                                    break;
                                case EXIT:
                                    JOptionPane.showMessageDialog(null,
                                            "Ng?????i kia ???? tho??t kh???i ph??ng chat, b???n s??? quay l???i h??ng ch??? !",
                                            "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
                                    client.setMatched(false);
                                    jTextArea1.setText("");
                                    jTextField2.setText("");
                                    break;
                                case CONNECTED:
                                    JOptionPane.showMessageDialog(null, "K???t n???i Th??nh C??ng", "Th??ng b??o",
                                        JOptionPane.INFORMATION_MESSAGE);
                                    jTextField1.setEditable(false);
                                    break;
                                default:

                            }

                        } catch (IOException | ClassNotFoundException e) {

                        }
                    }
                });
                t.start();
                i++;
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                if (client != null) {
                    if (client.isMatched()) {
                        Message send = new Message(client.getName(), jTextField2.getText(), Status.CHAT);
                        client.sendMessage(send);
                        jTextArea1.append("B???n n??i v???i "+tenchat+ " : " + jTextField2.getText() + "\n");
                        jTextField2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "H??y t??m b???n ch???", "Th??ng b??o",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "H??y K???t N???i", "Th??ng b??o",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTextField2KeyReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
