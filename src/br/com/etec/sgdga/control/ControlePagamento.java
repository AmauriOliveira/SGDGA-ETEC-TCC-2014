package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlePagamento {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarPagamento = "SELECT * FROM PAGAMENTO WHERE NOME LIKE ?";
    String cadastrarPagamento = "INSERT INTO PAGAMENTO (NOME) VALUES(?)";
    String alterarPagamento = "UPDATE PAGAMENTO SET NOME = ? WHERE ID = ?";
    String deletarPagamento = "DELETE FROM PAGAMENTO WHERE ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarPagamentos(BasicPagamento pagamento) {
        try {

            pstm = bd.conectar().prepareStatement(alterarPagamento);
            pstm.setString(1, pagamento.getNome());
            pstm.setInt(2, pagamento.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarPagamentos(BasicPagamento pagamento) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarPagamento);
            pstm.setString(1, pagamento.getNome());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicPagamento> listarPagamentos(String nome) {
        List<BasicPagamento> pagamentos = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarPagamento);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasicPagamento pagam;

            while (rs.next()) {
                pagam = new BasicPagamento();
                pagam.setId(rs.getInt("id"));
                pagam.setNome(rs.getString("nome"));

                pagamentos.add(pagam);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return pagamentos;

    }

    public void excluirPagamentos(int idPagamento) {
        try {

            pstm = bd.conectar().prepareStatement(deletarPagamento);
            pstm.setInt(1, idPagamento);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
