package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleFuncionario {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarFuncionario = "SELECT * FROM FUNCIONARIO WHERE func_NOME LIKE ?";
    String cadastrarFuncionario = "INSERT INTO FUNCIONARIO (func_NOME,func_CPF,func_endereco,func_data_admi,func_telefone_fixo,func_CELULAR,func_FUNCAO) VALUES(?,?,?,?,?,?,?)";
    String alterarFuncionario = "UPDATE FUNCIONARIO SET func_NOME = ?,func_CPF= ?,func_endereco= ?,func_data_admi= ?,func_telefone_fixo= ?,func_CELULAR= ?,func_FUNCAO= ? WHERE func_ID = ?";
    String deletarFuncionario = "DELETE FROM FUNCIONARIO WHERE func_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarFuncionarios(BasicFuncionario funcionario) {
        try {

            pstm = bd.conectar().prepareStatement(alterarFuncionario);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getEndereco());
            pstm.setDate(4, funcionario.getAdmim());
            pstm.setString(5, funcionario.getFixo());
            pstm.setString(6, funcionario.getCelular());
            pstm.setString(7, funcionario.getFuncao());
            pstm.setInt(8, funcionario.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }


    public void cadastrarFuncionarios(BasicFuncionario funcionario) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarFuncionario);

            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getEndereco());
            pstm.setDate(4, funcionario.getAdmim());
            pstm.setString(5, funcionario.getFixo());
            pstm.setString(6, funcionario.getCelular());
            pstm.setString(7, funcionario.getFuncao());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicFuncionario> listarFuncionarios(String nome) {
        List<BasicFuncionario> funcionarios = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarFuncionario);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            BasicFuncionario funci;

            while (rs.next()) {
                funci = new BasicFuncionario();
                funci.setId(rs.getInt("func_id"));
                funci.setNome(rs.getString("func_nome"));
                funci.setCpf(rs.getString("func_CPF"));
                funci.setEndereco(rs.getString("func_endereco"));
                funci.setAdmim(rs.getDate("func_data_admi"));
                funci.setFixo(rs.getString("func_telefone_fixo"));
                funci.setCelular(rs.getString("func_CELULAR"));
                funci.setFuncao(rs.getString("func_FUNCAO"));

                funcionarios.add(funci);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return funcionarios;

    }

    public void excluirFuncionarios(int idFuncionario) {
        try {

            pstm = bd.conectar().prepareStatement(deletarFuncionario);
            pstm.setInt(1, idFuncionario);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
