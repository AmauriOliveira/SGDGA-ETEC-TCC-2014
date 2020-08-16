package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleCliente {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarCliente = "SELECT * FROM CLIENTE WHERE CLI_NOME LIKE ?";
    String cadastrarCliente = "INSERT INTO CLIENTE (CLI_NOME,CLI_SOBRENOME,CLI_CPF_CNPJ,CLI_RUA,CLI_NUMERO,CLI_BAIRRO,CLI_CIDADE,CLI_CEP,CLI_GRUPOS,CLI_TELEFONE_FIXO,CLI_CEL) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    String alterarCliente = "UPDATE CLIENTE SET CLI_NOME = ?,CLI_sOBRENOME= ?,CLI_CPF_cnpj= ?,CLI_RUA= ?,CLI_NUMERO= ?,CLI_BAIRRO= ?,CLI_CIDADE= ?,CLI_CEP= ?,CLI_GRUPOS= ?,CLI_TELEFONE_FIXO= ?,CLI_CEL= ? WHERE CLI_ID = ?";
    String deletarCliente = "DELETE FROM CLIENTE WHERE CLI_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarClientes(BasicCliente cliente) {
        try {

            pstm = bd.conectar().prepareStatement(alterarCliente);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getCpf());
            pstm.setString(4, cliente.getRua());
            pstm.setString(5, cliente.getNumero());
            pstm.setString(6, cliente.getBairro());
            pstm.setInt(7, cliente.getCidade());
            pstm.setString(8, cliente.getCep());
            pstm.setInt(9, cliente.getGrupo());
            pstm.setString(10, cliente.getFixo());
            pstm.setString(11, cliente.getCelular());
            pstm.setInt(12, cliente.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarClientes(BasicCliente cliente) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarCliente);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getCpf());
            pstm.setString(4, cliente.getRua());
            pstm.setString(5, cliente.getNumero());
            pstm.setString(6, cliente.getBairro());
          pstm.setInt(7, cliente.getCidade());
            pstm.setString(8, cliente.getCep());
           pstm.setInt(9, cliente.getGrupo());
            pstm.setString(10, cliente.getFixo());
            pstm.setString(11, cliente.getCelular());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado 01\n" + e, "Erro", 0);
        }

    }

    public List<BasicCliente> listarClientes(String nome) {
        List<BasicCliente> clientes = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarCliente);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasicCliente client;

            while (rs.next()) {
                client = new BasicCliente();
                client.setId(rs.getInt("cli_id"));
                client.setNome(rs.getString("cli_nome"));
                client.setSobrenome(rs.getString("cli_sobrenome"));
                client.setCpf(rs.getString("cli_cpf_cnpj"));
                client.setRua(rs.getString("cli_rua"));
                client.setNumero(rs.getString("cli_numero"));
                client.setBairro(rs.getString("cli_bairro"));
                client.setCidade(rs.getInt("cli_cidade"));
                client.setCep(rs.getString("cli_cep"));
                client.setGrupo(rs.getInt("cli_grupos"));
                client.setFixo(rs.getString("cli_telefone_fixo"));
                client.setCelular(rs.getString("cli_cel"));

                clientes.add(client);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return clientes;

    }

    public void excluirClientes(int idConta) {
        try {

            pstm = bd.conectar().prepareStatement(deletarCliente);
            pstm.setInt(1, idConta);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
