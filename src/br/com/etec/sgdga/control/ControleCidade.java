package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleCidade {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarCidade = "SELECT * FROM cad_CIDADE WHERE CID_NOME LIKE ?";
    String cadastrarCidade = "INSERT INTO cad_CIDADE (cid_nome,cid_uf) VALUES(?,?)";
    String alterarCidade = "UPDATE cad_CIDADE SET cid_NOME = ?,cid_uf = ? WHERE cid_ID = ?";
    String deletarCidade = "DELETE FROM cad_CIDADE WHERE cid_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarCidades(BasicCidade cidade) {
        try {

            pstm = bd.conectar().prepareStatement(alterarCidade);
            pstm.setString(1, cidade.getNome());
            pstm.setString(2, cidade.getEstado());
            pstm.setInt(3, cidade.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarCidades(BasicCidade cidade) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarCidade);
            pstm.setString(1, cidade.getNome());
            pstm.setString(2, cidade.getEstado());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicCidade> listarCidades(String nome) {
        List<BasicCidade> cidades = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarCidade);
            pstm.setString(1, nome);
            
            rs = pstm.executeQuery();

            BasicCidade cidad;

            while (rs.next()) {
                cidad = new BasicCidade();
                cidad.setId(rs.getInt("cid_id"));
                cidad.setNome(rs.getString("cid_Nome"));
                cidad.setEstado(rs.getString("cid_uf"));

                cidades.add(cidad);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return cidades;

    }

    public void excluirCidades(int idCidade) {
        try {

            pstm = bd.conectar().prepareStatement(deletarCidade);
            pstm.setInt(1, idCidade);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
