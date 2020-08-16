/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class ControleCheque {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarCheque = "SELECT * FROM casd_cheque WHERE chq_Num_cheque like ?";
    String cadastrarCheque = "INSERT INTO casd_cheque (chq_Banco,chq_Num_cheque,chq_Agencia,chq_Conta,chq_Prazo,chq_Vencimento,chq_Cnpj,chq_Valor) VALUES(?,?,?,?,?,?,?,?)";
    String alterarCheque = "UPDATE casd_cheque SET chq_Banco = ?,chq_Num_cheque = ?,chq_Agencia = ?,chq_Conta = ?,chq_Prazo = ?,chq_Vencimento = ?,chq_Cnpj = ?,chq_Valor= ? WHERE chq_Id = ?";
    String deletarCheque = "DELETE FROM casd_cheque WHERE chq_Id = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarCheques(BasicCheque cheque) {
        try {

            pstm = bd.conectar().prepareStatement(alterarCheque);
            pstm.setString(1, cheque.getBanco());
            pstm.setString(2, cheque.getNumeroCheque());
            pstm.setString(3, cheque.getAgencia());
            pstm.setString(4, cheque.getConta());
            pstm.setString(5, cheque.getPrazo());
            pstm.setDate(6, cheque.getVencimento());
            pstm.setString(7, cheque.getCnpj());
            pstm.setDouble(8, cheque.getValor());
            pstm.setInt(9, cheque.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarCheques(BasicCheque cheque) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarCheque);

            pstm.setString(1, cheque.getBanco());
            pstm.setString(2, cheque.getNumeroCheque());
            pstm.setString(3, cheque.getAgencia());
            pstm.setString(4, cheque.getConta());
            pstm.setString(5, cheque.getPrazo());
            pstm.setDate(6, cheque.getVencimento());
            pstm.setString(7, cheque.getCnpj());
            pstm.setDouble(8, cheque.getValor());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicCheque> listarCheques(String nome) {
        List<BasicCheque> cheques = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarCheque);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasicCheque cheq;

            while (rs.next()) {
                cheq = new BasicCheque();
                cheq.setId(rs.getInt("chq_id"));
                cheq.setBanco(rs.getString("chq_Banco"));
                cheq.setNumeroCheque(rs.getString("chq_Num_cheque"));
                cheq.setAgencia(rs.getString("chq_Agencia"));
                cheq.setConta(rs.getString("chq_Conta"));
                cheq.setPrazo(rs.getString("chq_Prazo"));
                cheq.setVencimento(rs.getDate("chq_Vencimento"));
                cheq.setCnpj(rs.getString("chq_Cnpj"));
                cheq.setValor(rs.getDouble("chq_Valor"));

                cheques.add(cheq);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return cheques;

    }

    public void excluirCheques(int idConta) {
        try {

            pstm = bd.conectar().prepareStatement(deletarCheque);
            pstm.setInt(1, idConta);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
