/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.atend;

import client.Login;
import services.AttendantsService;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 *
 * @author whala
 */
public class AttOptions extends JFrame {

    /**
     * Creates new form Login_Atendente
     */
    public AttOptions() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        Border jPanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.gray);
        jPanel_title.setBorder(jPanel_title_border);
        
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_fechar.setBorder(label_border);
        
        
                
        Border jLabel_sair_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray);
        jLabel_Sair.setBorder(jLabel_sair_border);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton_Fila = new javax.swing.JButton();
        jButton_Confirmar_Vacinacao = new javax.swing.JButton();
        jLabel_Sair = new javax.swing.JLabel();
        jLabel_minimize = new javax.swing.JLabel();
        jLabel_fechar = new javax.swing.JLabel();
        jPanel_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(204, 255, 204));

        jPanel2.setBackground(new Color(255, 255, 255));

        jButton_Fila.setBackground(new Color(0, 84, 140));
        jButton_Fila.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jButton_Fila.setForeground(new Color(255, 255, 255));
        jButton_Fila.setText("Fila");
        jButton_Fila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Fila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_FilaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_FilaMouseExited(evt);
            }
        });
        jButton_Fila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton_FilaActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton_Confirmar_Vacinacao.setBackground(new Color(0, 84, 140));
        jButton_Confirmar_Vacinacao.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jButton_Confirmar_Vacinacao.setForeground(new Color(255, 255, 255));
        jButton_Confirmar_Vacinacao.setText("Confirmar Vacinação");
        jButton_Confirmar_Vacinacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Confirmar_Vacinacao.setPreferredSize(new java.awt.Dimension(111, 29));
        jButton_Confirmar_Vacinacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_Confirmar_VacinacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_Confirmar_VacinacaoMouseExited(evt);
            }
        });
        jButton_Confirmar_Vacinacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton_Confirmar_VacinacaoActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jLabel_Sair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Sair.setText("Sair");
        jLabel_Sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_SairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_SairMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Fila, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Confirmar_Vacinacao, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel_Sair)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButton_Fila, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Confirmar_Vacinacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jLabel_Sair)
                .addContainerGap())
        );

        jLabel_minimize.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_minimize.setText(" -");
        jLabel_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMouseExited(evt);
            }
        });

        jLabel_fechar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_fechar.setText(" x");
        jLabel_fechar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_fecharMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_fecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_fecharMouseExited(evt);
            }
        });

        jPanel_title.setBackground(new Color(204, 255, 204));

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Atendente");

        javax.swing.GroupLayout jPanel_titleLayout = new javax.swing.GroupLayout(jPanel_title);
        jPanel_title.setLayout(jPanel_titleLayout);
        jPanel_titleLayout.setHorizontalGroup(
            jPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_titleLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel_titleLayout.setVerticalGroup(
            jPanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_titleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jLabel_minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_minimize)
                        .addComponent(jLabel_fechar)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/img_covid2.jpg")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FilaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_FilaMouseEntered

        jButton_Fila.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_FilaMouseEntered

    private void jButton_FilaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_FilaMouseExited

        jButton_Fila.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_FilaMouseExited

    private void jButton_FilaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, IOException {//GEN-FIRST:event_jButton_FilaActionPerformed
        AttendantsService att = new AttendantsService();
        Object[][] data = att.consultQueue();
        Queue queue = new Queue(data);
        queue.setVisible(true);
    }//GEN-LAST:event_jButton_FilaActionPerformed

    private void jLabel_SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SairMouseClicked
        Login logoff = new Login();
        logoff.setVisible(true);
        logoff.pack();
        logoff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel_SairMouseClicked

    private void jLabel_SairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SairMouseEntered
        Border jLabel_sair_border = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 101, 183));
        jLabel_Sair.setBorder(jLabel_sair_border);
    }//GEN-LAST:event_jLabel_SairMouseEntered

    private void jLabel_SairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SairMouseExited
        Border jLabel_sair_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray);
        jLabel_Sair.setBorder(jLabel_sair_border);
    }//GEN-LAST:event_jLabel_SairMouseExited

    private void jLabel_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMouseClicked

    private void jLabel_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseEntered

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.gray);
    }//GEN-LAST:event_jLabel_minimizeMouseEntered

    private void jLabel_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMouseExited

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_minimize.setBorder(label_border);
        jLabel_minimize.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_minimizeMouseExited

    private void jLabel_fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_fecharMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabel_fecharMouseClicked

    private void jLabel_fecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_fecharMouseEntered

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        jLabel_fechar.setBorder(label_border);
        jLabel_fechar.setForeground(Color.red);
    }//GEN-LAST:event_jLabel_fecharMouseEntered

    private void jLabel_fecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_fecharMouseExited

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_fechar.setBorder(label_border);
        jLabel_fechar.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_fecharMouseExited

    private void jButton_Confirmar_VacinacaoActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, IOException {//GEN-FIRST:event_jButton_Confirmar_VacinacaoActionPerformed
        AttendantsService vacine = new AttendantsService();
        vacine.vaccineConfirm();
    }//GEN-LAST:event_jButton_Confirmar_VacinacaoActionPerformed

    private void jButton_Confirmar_VacinacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Confirmar_VacinacaoMouseExited
        jButton_Confirmar_Vacinacao.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_Confirmar_VacinacaoMouseExited

    private void jButton_Confirmar_VacinacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_Confirmar_VacinacaoMouseEntered
        jButton_Confirmar_Vacinacao.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_Confirmar_VacinacaoMouseEntered

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
            java.util.logging.Logger.getLogger(AttOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttOptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Confirmar_Vacinacao;
    private javax.swing.JButton jButton_Fila;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Sair;
    private javax.swing.JLabel jLabel_fechar;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_minimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_title;
    // End of variables declaration//GEN-END:variables
}