package br.com.etec.sgdga.tela;

import br.com.etec.sgdga.control.BasicConfirmacao;
import br.com.etec.sgdga.control.ControleConfirmacao;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceConfirmacao extends javax.swing.JFrame {

    List<BasicConfirmacao> logins;
    public int acc;
    Principal tela = null;
    AdminPrincipal admin = null;

    public InterfaceConfirmacao() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de acesso");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Para entrar no sistema deve efetuar o login.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(jLabel1, gridBagConstraints);

        tfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLoginKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 207;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(tfLogin, gridBagConstraints);

        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPasswordKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 207;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(tfPassword, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/lock_open.png"))); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/cross.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jButton2, gridBagConstraints);

        jLabel2.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 24, 6, 24);
        getContentPane().add(jLabel4, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private void listarCliente() {
        ControleConfirmacao log = new ControleConfirmacao();
        logins = log.listarLogin(tfLogin.getText().trim());

        if (!logins.isEmpty()) {
            acc = logins.get(0).getNivel();
            if (tfLogin.getText().trim().equals(logins.get(0).getLogin()) && tfPassword.getText().trim().equals(logins.get(0).getPassword())) {
                JOptionPane.showMessageDialog(this, "Seja bem vindo", "Certo", 1);
                loginCorreto();
            } else {
                JOptionPane.showMessageDialog(this, "Senha ou Login errado 07", "Erro", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Senha ou Login errado 08", "Erro", 0);
        }
    }

    private void vereificarCampos() {
        if (tfLogin.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Login vazio", "Erro 09", 2);
            tfLogin.requestFocus();
        } else {
            if (tfPassword.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Senha vazio", "Erro 10", 2);
                tfPassword.requestFocus();
            } else {
                listarCliente();
            }
        }

    }

    private void Clicar() {
        if (acc == 1) {
            if (tela == null) {
                tela = new Principal();
                tela.setVisible(true);
            } else {
                tela.setVisible(true);
                tela.setState(JFrame.NORMAL);

            }
            this.dispose();
        }

        if (acc == 2) {
            if (admin == null) {
                admin = new AdminPrincipal();
                admin.setVisible(true);
            } else {
                admin.setVisible(true);
                admin.setState(JFrame.NORMAL);

            }
            this.dispose();
        }
    }

    private void loginCorreto() {
        Clicar();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vereificarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();
        }
    }//GEN-LAST:event_tfLoginKeyPressed

    private void tfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.focusNextComponent();

    }//GEN-LAST:event_tfPasswordKeyPressed
    }

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER
                && ((JButton) evt.getSource()).hasFocus()) {

            vereificarCampos();

        }

    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * ;
     *
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
            java.util.logging.Logger.getLogger(InterfaceConfirmacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceConfirmacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfPassword;
    // End of variables declaration//GEN-END:variables
}
