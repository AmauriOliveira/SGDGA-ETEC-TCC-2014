/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.sgdga.tela;

import br.com.etec.sgdga.control.BasicConfirmacao;
import br.com.etec.sgdga.control.ControleConfirmacao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows
 */
public class TelaCadastro extends javax.swing.JFrame {

    DefaultTableModel tmUsers = new DefaultTableModel(null, new String[]{"Login", "Senha"}) {
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    List<BasicConfirmacao> cadastros;
    String tipoCadastro;
    ListSelectionModel lsmUser;
    List<BasicConfirmacao> loginos;

    public TelaCadastro() {
        initComponents();
        atualizarUser();
    }

    protected void tbUserLinhaSelecionada(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            txtLogin.setText(cadastros.get(tb.getSelectedRow()).getLogin());
            txtSenha.setText(cadastros.get(tb.getSelectedRow()).getPassword());

        } else {
            txtLogin.setText("");
            txtSenha.setText("");
        }
    }

    protected boolean verificarCampos() {
        ControleConfirmacao log = new ControleConfirmacao();
        int a = txtLogin.getText().length();
        int b = txtSenha.getText().length();

        loginos = log.listarLogin(txtLogin.getText().trim());
        if (loginos.isEmpty() || "alteracao".equals(tipoCadastro)) {
            if (a > 3 && a < 11) {
                if (b > 5 && a < 16) {

                    return true;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Preenchimento incorreto\nEste campo deve conter de 6 a 15 caracteres", "Aviso", 0);
                    txtSenha.requestFocus();
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Preenchimento incorreto\nEste campo deve conter de 4 a 10 caracteres", "Aviso", 0);
                txtLogin.requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Este login já foi cadastrado,\nfavor escolher outro!!", "Aviso", 0);
            txtLogin.requestFocus();
            return false;

        }
    }

    protected void cadastraUser() {

        if (verificarCampos()) {
            BasicConfirmacao user = new BasicConfirmacao();
            user.setLogin(txtLogin.getText().trim());
            user.setPassword(txtSenha.getText().trim());
            user.setNivel(1);

            ControleConfirmacao c = new ControleConfirmacao();
            c.cadastrarLogins(user);
            JOptionPane.showMessageDialog(this, "Registro feito com sucesso\n" + user.getLogin(), "Registro", 1);
            desabilitarCampos();
        }

    }

    protected void habilitarCampos() {
        txtLogin.setEditable(true);
        txtSenha.setEditable(true);
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnNovo.setEnabled(false);
        btnDeletar.setEnabled(false);
        tbUser.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    protected void desabilitarCampos() {
        txtLogin.setEditable(false);
        txtSenha.setEditable(false);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnDeletar.setEnabled(true);
        tbUser.setEnabled(true);
        btnCancelar.setEnabled(false);

    }

    private void limpaCampos() {
        txtLogin.setText("");
        txtSenha.setText("");

    }

    protected void alteraUser() {
        if (tbUser.getSelectedRow() != -1) {
            habilitarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Registro Selecionado na Tabela", "Erro", 0);
        }
    }

    protected void alterarUser() {
        if (verificarCampos()) {
            BasicConfirmacao user = new BasicConfirmacao();
            user.setId(cadastros.get(tbUser.getSelectedRow()).getId());
            user.setLogin(txtLogin.getText().trim());
            user.setPassword(txtSenha.getText().trim());

            ControleConfirmacao c = new ControleConfirmacao();
            c.alterarLogin(user);
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso\n" + user.getLogin(), "Registro", 1);
            desabilitarCampos();
        }
    }

    private void novoCheque() {
        habilitarCampos();
        limpaCampos();
    }

    protected void excluirUser() {
        if (tbUser.getSelectedRow() != -1) {
            int res = JOptionPane.showConfirmDialog(this, "Deseja apagar este registro?", "Confirmação", JOptionPane.YES_NO_OPTION, 2);
            if (res == JOptionPane.YES_OPTION) {
                ControleConfirmacao pc = new ControleConfirmacao();
                pc.excluirLogin(cadastros.get(tbUser.getSelectedRow()).getId());
                JOptionPane.showMessageDialog(this, "Registro apagado com sucesso", "Registro", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Registro Selecionado na Tabela", "Erro", 0);
        }
    }
//

    protected void atualizarUser() {
        ControleConfirmacao cid = new ControleConfirmacao();
        cadastros = cid.listarLogin("%%");
        ExibeUser(cadastros);
    }

    protected void ExibeUser(List<BasicConfirmacao> grup) {

        while (tmUsers.getRowCount() > 0) {
            tmUsers.removeRow(0);
        }

        if (!grup.isEmpty()) {

            String[] campos = new String[]{null, null};
            for (int i = 0; i < grup.size(); i++) {
                tmUsers.addRow(campos);

                tmUsers.setValueAt(grup.get(i).getLogin(), i, 0);
                tmUsers.setValueAt(grup.get(i).getPassword(), i, 1);
            }
        }
    }
    //

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        tbUsuario = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Novos Usuarios");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
        jPanel1Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Cadastrar  de Usuarios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel3, gridBagConstraints);

        txtSenha.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(txtSenha, gridBagConstraints);

        txtLogin.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(txtLogin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jPanel1, gridBagConstraints);

        tbUser.setModel(tmUsers);
        tbUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmUser = tbUser.getSelectionModel();
        lsmUser.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                tbUserLinhaSelecionada(tbUser);
            }
        });
        tbUsuario.setViewportView(tbUser);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(tbUsuario, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/key_add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(btnNovo, gridBagConstraints);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/pencil.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(btnAlterar, gridBagConstraints);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/disk.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(btnSalvar, gridBagConstraints);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(btnCancelar, gridBagConstraints);

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/key_delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(btnDeletar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoCheque();
        tipoCadastro = "novo";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        tipoCadastro = "alteracao";
        alteraUser();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        switch (tipoCadastro) {
            case "novo":
                cadastraUser();
                break;
            case "alteracao":
                alterarUser();
                break;
        }
        atualizarUser();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        excluirUser();
        atualizarUser();
    }//GEN-LAST:event_btnDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tbUser;
    private javax.swing.JScrollPane tbUsuario;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
