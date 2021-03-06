/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.sgdga.tela;

import br.com.etec.sgdga.control.BasicClienteGrupo;
import br.com.etec.sgdga.control.ControleClienteGrupo;
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
public class TelaGrupoCliente extends javax.swing.JFrame {

    DefaultTableModel tmGrupos = new DefaultTableModel(null, new String[]{"Nome", "Discrição"}) {
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    ListSelectionModel lsmGrupo;
    List<BasicClienteGrupo> grupos;
    String tipoCadastro;

    public TelaGrupoCliente() {
        initComponents();
        atualizarGrupo();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiscricao = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrupo = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupo de Cliente");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Discrição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel3, gridBagConstraints);

        txtNome.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(txtNome, gridBagConstraints);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Grupo de Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jLabel4, gridBagConstraints);

        txtDiscricao.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(txtDiscricao, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/group_add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(btnNovo, gridBagConstraints);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/group_edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(btnAlterar, gridBagConstraints);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(btnSalvar, gridBagConstraints);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(btnCancelar, gridBagConstraints);

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/group_delete.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel3.add(btnApagar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jPanel3, gridBagConstraints);

        tbGrupo.setModel(tmGrupos);
        tbGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmGrupo = tbGrupo.getSelectionModel();
        lsmGrupo.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                tbGrupoLinhaSelecionada(tbGrupo);
            }
        });
        jScrollPane1.setViewportView(tbGrupo);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/32/magnifier.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar por nome");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPesquisar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    protected void tbGrupoLinhaSelecionada(JTable tb) {
        if (tb.getSelectedRow() != -1) {

            txtNome.setText(grupos.get(tb.getSelectedRow()).getNome());
            txtDiscricao.setText(grupos.get(tb.getSelectedRow()).getDiscr());

        } else {
            limpaCampos();
        }
    }

    protected void listarGrupo() {
        ControleClienteGrupo gru = new ControleClienteGrupo();
        grupos = gru.listarGrupos("%" + txtPesquisar.getText().trim() + "%");
        mostrarGrupo(grupos);
    }
//

    protected void atualizarGrupo() {
        ControleClienteGrupo gru = new ControleClienteGrupo();
        grupos = gru.listarGrupos("%%");
        ExibeGrupo(grupos);
    }

    protected void ExibeGrupo(List<BasicClienteGrupo> grup) {

        while (tmGrupos.getRowCount() > 0) {
            tmGrupos.removeRow(0);
        }

        if (!grup.isEmpty()) {

            String[] campos = new String[]{null, null};
            for (int i = 0; i < grup.size(); i++) {
                tmGrupos.addRow(campos);
                tmGrupos.setValueAt(grup.get(i).getNome(), i, 0);
                tmGrupos.setValueAt(grup.get(i).getDiscr(), i, 1);

            }
        }

    }

    //
    @SuppressWarnings("empty-statement")
    protected void mostrarGrupo(List<BasicClienteGrupo> grup) {

        while (tmGrupos.getRowCount() > 0) {
            tmGrupos.removeRow(0);
        }

        if (grup.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Registro Encontrado", "Erro", 0);
        } else {

            String[] campos = new String[]{null, null};
            for (int i = 0; i < grup.size(); i++) {
                tmGrupos.addRow(campos);
                tmGrupos.setValueAt(grup.get(i).getNome(), i, 0);
                tmGrupos.setValueAt(grup.get(i).getDiscr(), i, 1);

            }
        }

    }

    protected boolean verificarCampos() {
        int a = txtNome.getText().length();
        int b = txtDiscricao.getText().length();

        if (a > -1 && a < 16) {
            if (b > 2 && b < 31) {

                return true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Preenchimento incorreto\nEste campo deve conter de 3 a 30 caracteres", "Aviso", 0);
                txtDiscricao.requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Preenchimento incorreto\nEste campo deve conter no maximo 15 caracteres", "Aviso", 0);
            txtNome.requestFocus();
            return false;
        }

    }

    protected void cadastraGrupo() {

        if (verificarCampos()) {
            BasicClienteGrupo grupo = new BasicClienteGrupo();
            grupo.setNome(txtNome.getText().trim());
            grupo.setDiscr(txtDiscricao.getText().trim());

            ControleClienteGrupo gr = new ControleClienteGrupo();
            gr.cadastrarGrupos(grupo);
            JOptionPane.showMessageDialog(this, "Registro feito com sucesso\n" + grupo.getNome(), "Registro", 1);
            desabilitarCampos();
        }

    }

    protected void habilitarCampos() {
        txtNome.setEditable(true);
        txtDiscricao.setEditable(true);
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnNovo.setEnabled(false);
        btnApagar.setEnabled(false);
        tbGrupo.setEnabled(false);
        btnPesquisar.setEnabled(false);
        txtPesquisar.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    protected void desabilitarCampos() {
        txtNome.setEditable(false);
        txtDiscricao.setEditable(false);
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnNovo.setEnabled(true);
        btnApagar.setEnabled(true);
        tbGrupo.setEnabled(true);
        btnPesquisar.setEnabled(true);
        txtPesquisar.setEnabled(true);
         btnCancelar.setEnabled(false);
    }

    private void limpaCampos() {
        txtNome.setText("");
        txtDiscricao.setText("");
    }

    protected void alteraGrupo() {
        if (tbGrupo.getSelectedRow() != -1) {
            habilitarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Registro Selecionado na Tabela", "Erro", 0);
        }
    }

    protected void alterarGrupo() {
        if (verificarCampos()) {
            BasicClienteGrupo grupo = new BasicClienteGrupo();
            grupo.setId(grupos.get(tbGrupo.getSelectedRow()).getId());

            grupo.setNome(txtNome.getText().trim());
            grupo.setDiscr(txtDiscricao.getText().trim());

            ControleClienteGrupo gr = new ControleClienteGrupo();
            gr.alterarGrupos(grupo);
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso\n" + grupo.getNome(), "Registro", 1);
            desabilitarCampos();
        }
    }

    private void novoGrupo() {
        habilitarCampos();
        limpaCampos();
    }

    protected void excluirGrupo() {
        if (tbGrupo.getSelectedRow() != -1) {
            int res = JOptionPane.showConfirmDialog(this, "Deseja apagar este registro?", "Confirmação", JOptionPane.YES_NO_OPTION, 2);
            if (res == JOptionPane.YES_OPTION) {
                ControleClienteGrupo pc = new ControleClienteGrupo();
                pc.excluirGrupos(grupos.get(tbGrupo.getSelectedRow()).getId());
                JOptionPane.showMessageDialog(this, "Registro apagado com sucesso", "Registro", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Registro Selecionado na Tabela", "Erro", 0);
        }
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoGrupo();
        tipoCadastro = "novo";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        tipoCadastro = "alteracao";

        alteraGrupo();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        switch (tipoCadastro) {
            case "novo":
                cadastraGrupo();
                break;
            case "alteracao":
                alterarGrupo();
                break;
        }

        atualizarGrupo();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        excluirGrupo();
        atualizarGrupo();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        listarGrupo();
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGrupoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaGrupoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGrupo;
    private javax.swing.JTextField txtDiscricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
