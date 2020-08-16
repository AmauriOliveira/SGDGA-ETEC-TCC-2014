package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleConta {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarConta = "SELECT * FROM PAGAMENTO WHERE NOME LIKE ?";
    String cadastrarConta = "INSERT INTO PAGAMENTO (NOME,VALOR,DATA,STATUS,DISCRIC) VALUES(?,?,?,?,?)";
    String alterarConta = "UPDATE PAGAMENTO SET NOME = ?, VALOR =?, DATA =?,STATUS = ?, DISCRIC WHERE ID = ?";
    String deletarConta = "DELETE FROM PAGAMENTO WHERE ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarConta(BasiConta conta) {
        try {

            pstm = bd.conectar().prepareStatement(alterarConta);
            pstm.setString(1, conta.getNome());
            pstm.setDouble(2, conta.getValor());
            pstm.setDate(3, conta.getData());
            pstm.setInt(4, conta.getStatus());
            pstm.setString(5, conta.getDiscr());
            pstm.setInt(6, conta.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarContas(BasiConta conta) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarConta);
            pstm.setString(1, conta.getNome());
            pstm.setDouble(2, conta.getValor());
            pstm.setDate(3, conta.getData());
            pstm.setInt(4, conta.getStatus());
            pstm.setString(5, conta.getDiscr());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasiConta> listarContas(String nome) {
        List<BasiConta> contas = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarConta);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasiConta cont;

            while (rs.next()) {
                cont = new BasiConta();
                cont.setId(rs.getInt("id"));
                cont.setNome(rs.getString("nome"));

                contas.add(cont);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return contas;

    }

    public void excluirContas(int idConta) {
        try {

            pstm = bd.conectar().prepareStatement(deletarConta);
            pstm.setInt(1, idConta);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
