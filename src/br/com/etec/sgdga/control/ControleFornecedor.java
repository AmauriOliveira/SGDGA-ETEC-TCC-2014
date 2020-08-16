package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleFornecedor {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarFornecedor = "SELECT * FROM FORNECEDOR WHERE FOR_NOME LIKE ?";
    String cadastrarFornecedor = "INSERT INTO FORNECEDOR (FOR_NOME,FOR_DESCRICAO,FOR_cnpj,FOR_endereco,FOR_cidade,FOR_cep, FOR_email,FOR_telefone,FOR_site) VALUES(?,?,?,?,?,?,?,?,?)";
    String alterarFornecedor = "UPDATE FORNECEDOR SET FOR_NOME = ?,FOR_DESCRICAO= ?,FOR_cnpj= ?,FOR_endereco= ?,FOR_cidade= ?,FOR_cep= ?,FOR_email= ?,FOR_telefone= ?,FOR_site= ? WHERE FOR_ID = ?";
    String deletarFornecedor = "DELETE FROM FORNECEDOR WHERE FOR_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarFornecedores(BasicFornecedor fornecedor) {
        try {

            pstm = bd.conectar().prepareStatement(alterarFornecedor);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getDisc());
            pstm.setString(3, fornecedor.getCnpj());
            pstm.setString(4, fornecedor.getEndereco());
            pstm.setInt(5, fornecedor.getCidade());
            pstm.setString(6, fornecedor.getCep());
            pstm.setString(7, fornecedor.getEmail());
            pstm.setString(8, fornecedor.getTelefone());
            pstm.setString(9, fornecedor.getSite());
            pstm.setInt(10, fornecedor.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarFornecedores(BasicFornecedor fornecedor) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarFornecedor);

            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getDisc());
            pstm.setString(3, fornecedor.getCnpj());
            pstm.setString(4, fornecedor.getEndereco());
            pstm.setInt(5, fornecedor.getCidade());
            pstm.setString(6, fornecedor.getCep());
            pstm.setString(7, fornecedor.getEmail());
            pstm.setString(8, fornecedor.getTelefone());
            pstm.setString(9, fornecedor.getSite());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicFornecedor> listarFornecedores(String nome) {
        List<BasicFornecedor> fornecedores = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarFornecedor);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasicFornecedor fornec;

            while (rs.next()) {

                fornec = new BasicFornecedor();
                fornec.setId(rs.getInt("for_id"));
                fornec.setNome(rs.getString("for_nome"));
                fornec.setDisc(rs.getString("FOR_DESCRICAO"));
                fornec.setCnpj(rs.getString("FOR_cnpj"));
                fornec.setEndereco(rs.getString("FOR_endereco"));
                fornec.setCidade(rs.getInt("fOR_cidade"));
                fornec.setCep(rs.getString("FOR_cep"));
                fornec.setEmail(rs.getString("FOR_email"));
                fornec.setTelefone(rs.getString("FOR_telefone"));
                fornec.setSite(rs.getString("FOR_site"));

                fornecedores.add(fornec);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return fornecedores;

    }

    public void excluirFornecedores(int idFornecedor) {
        try {

            pstm = bd.conectar().prepareStatement(deletarFornecedor);
            pstm.setInt(1, idFornecedor);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
