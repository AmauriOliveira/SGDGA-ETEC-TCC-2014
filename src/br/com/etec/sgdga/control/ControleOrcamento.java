package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleOrcamento {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarOrcamento = "SELECT * FROM PAGAMENTO WHERE NOME LIKE ?";
    String cadastrarOrcamento = "INSERT INTO PAGAMENTO (NOTA,PRODUTO,QUANTIDADE,VALOR,SUB) VALUES(?,?,?,?,?)";
    String alterarOrcamento = "UPDATE PAGAMENTO SET NOTA= ?,PRODUTO= ?,QUANTIDADE= ?,VALOR= ?,SUB= ? WHERE ID = ?";
    String deletarOrcamento = "DELETE FROM PAGAMENTO WHERE ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarOrcamentos(BasicOrcamento orcamento) {
        try {

            pstm = bd.conectar().prepareStatement(alterarOrcamento);
            pstm.setTime(1, orcamento.getHora());
            pstm.setDate(2, orcamento.getData());
            pstm.setInt(3, orcamento.getCliente());
            pstm.setInt(4, orcamento.getPagamento());
            pstm.setDouble(5, orcamento.getValor());
            pstm.setDouble(6, orcamento.getDesconto());
            pstm.setDouble(7, orcamento.getValorFinal());
            pstm.setInt(8, orcamento.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarOrcamentos(BasicOrcamento orcamento) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarOrcamento);

            pstm.setTime(1, orcamento.getHora());
            pstm.setDate(2, orcamento.getData());
            pstm.setInt(3, orcamento.getCliente());
            pstm.setInt(4, orcamento.getPagamento());
            pstm.setDouble(5, orcamento.getValor());
            pstm.setDouble(6, orcamento.getDesconto());
            pstm.setDouble(7, orcamento.getValorFinal());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicOrcamento> listarOrcamentos(int orcamento) {
        List<BasicOrcamento> orcamentos = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarOrcamento);
            pstm.setInt(1, orcamento);
            rs = pstm.executeQuery();

            BasicOrcamento orcamen;

            while (rs.next()) {
                orcamen = new BasicOrcamento();
                orcamen.setId(rs.getInt("id"));
                orcamen.setData(rs.getDate("orcamento"));//// orcamento ou item// 

                orcamentos.add(orcamen);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return orcamentos;

    }

    public void excluirOrcamento(int idOrcamento) {
        try {

            pstm = bd.conectar().prepareStatement(deletarOrcamento);
            pstm.setInt(1, idOrcamento);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
