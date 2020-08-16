package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleItemOrcamento {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarItemOrcamento = "SELECT * FROM PAGAMENTO WHERE NOME LIKE ?";
    String cadastrarItemOrcamento = "INSERT INTO PAGAMENTO (NOTA,PRODUTO,QUANTIDADE,VALOR,SUB) VALUES(?,?,?,?,?)";
    String alterarItemOrcamento = "UPDATE PAGAMENTO SET NOTA= ?,PRODUTO= ?,QUANTIDADE= ?,VALOR= ?,SUB= ? WHERE ID = ?";
    String deletarItemOrcamento = "DELETE FROM PAGAMENTO WHERE ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarItemOrcamentos(BasicItemOrcamento item) {
        try {

            pstm = bd.conectar().prepareStatement(alterarItemOrcamento);
            pstm.setInt(1, item.getOrcamento());
            pstm.setInt(2, item.getProduto());
            pstm.setInt(3, item.getQuantidade());
            pstm.setDouble(4, item.getValorUni());
            pstm.setDouble(5, item.getSubTotal());
            pstm.setInt(6, item.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarItemOrcamentos(BasicItemOrcamento item) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarItemOrcamento);

            pstm.setInt(1, item.getOrcamento());
            pstm.setInt(2, item.getProduto());
            pstm.setInt(3, item.getQuantidade());
            pstm.setDouble(4, item.getValorUni());
            pstm.setDouble(5, item.getSubTotal());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicItemOrcamento> listarItemOrcamentos(int item) {
        List<BasicItemOrcamento> itensOrcamentos = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarItemOrcamento);
            pstm.setInt(1, item);
            rs = pstm.executeQuery();

            BasicItemOrcamento orcamento;

            while (rs.next()) {
                orcamento = new BasicItemOrcamento();
                orcamento.setId(rs.getInt("id"));
                orcamento.setOrcamento(rs.getInt("orcamento"));//// orcamento ou item// 

                itensOrcamentos.add(orcamento);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return itensOrcamentos;

    }

    public void excluirItemOrcamento(int idItemOrcamento) {
        try {

            pstm = bd.conectar().prepareStatement(deletarItemOrcamento);
            pstm.setInt(1, idItemOrcamento);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
