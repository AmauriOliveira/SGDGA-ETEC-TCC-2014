package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleProduto {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarProduto = "SELECT * FROM PRODUTOS WHERE PRO_NOME LIKE ?";
    String cadastrarProduto = "INSERT INTO PRODUTOS (PRO_NOME,PRO_FORNECEDOR,PRO_PR_CUSTO,PRO_PR_FINAL,PRO_ESTOQUE) VALUES(?,?,?,?,?)";
    String alterarProduto = "UPDATE PRODUTOS SET PRO_NOME = ?,PRO_FORNECEDOR = ?,PRO_PR_CUSTO =?,PRO_PR_FINAL= ?,PRO_ESTOQUE = ? WHERE PRO_ID = ?";
    String deletarProduto = "DELETE FROM PRODUTOS WHERE PRO_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarProdutos(BasicProduto produto) {
        try {

            pstm = bd.conectar().prepareStatement(alterarProduto);
            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getFornecedor());
            pstm.setDouble(3, produto.getValor_custo());
            pstm.setDouble(4, produto.getValor_final());
            pstm.setInt(5, produto.getEstoque());
            pstm.setInt(6, produto.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarProdutos(BasicProduto produto) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarProduto);

            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getFornecedor());
            pstm.setDouble(3, produto.getValor_custo());
            pstm.setDouble(4, produto.getValor_final());
            pstm.setInt(5, produto.getEstoque());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicProduto> listarProdutos(String produto) {
        List<BasicProduto> produtos = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarProduto);
            pstm.setString(1, produto);
            rs = pstm.executeQuery();

            BasicProduto produ;

            while (rs.next()) {
                produ = new BasicProduto();
                produ.setId(rs.getInt("pro_id"));
                produ.setNome(rs.getString("pro_nome"));//// orcamento ou item// 
                produ.setFornecedor(rs.getInt("PRO_FORNECEDOR"));
                produ.setValor_custo(rs.getDouble("PRO_PR_CUSTO"));
                produ.setValor_final(rs.getDouble("PRO_PR_FINAL"));
                produ.setEstoque(rs.getInt("PRO_ESTOQUE"));

                produtos.add(produ);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return produtos;

    }

    public void excluirProduto(int idProduto) {
        try {

            pstm = bd.conectar().prepareStatement(deletarProduto);
            pstm.setInt(1, idProduto);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
