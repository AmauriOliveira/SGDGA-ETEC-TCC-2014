package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleClienteGrupo {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarGrupo = "SELECT * FROM  GRUPO WHERE GRUP_NOME LIKE ?";
    String cadastrarGrupo = "INSERT INTO GRUPO (GRUP_NOME,GRUP_DESC) VALUES(?,?)";
    String alterarGrupo = "UPDATE GRUPO SET GRUP_NOME = ?,GRUP_DESC = ? WHERE GRUP_ID = ?";
    String deletarGrupo = "DELETE FROM GRUPO WHERE GRUP_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarGrupos(BasicClienteGrupo grupo) {
        try {

            pstm = bd.conectar().prepareStatement(alterarGrupo);
            pstm.setString(1, grupo.getNome());
            pstm.setString(2, grupo.getDiscr());
            pstm.setInt(3, grupo.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarGrupos(BasicClienteGrupo grupo) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarGrupo);
            pstm.setString(1, grupo.getNome());
            pstm.setString(2, grupo.getDiscr());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicClienteGrupo> listarGrupos(String nome) {
        List<BasicClienteGrupo> grupos = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarGrupo);
            pstm.setString(1, nome);

            rs = pstm.executeQuery();

            BasicClienteGrupo grup;

            while (rs.next()) {
                grup = new BasicClienteGrupo();
                grup.setId(rs.getInt("grup_id"));
                grup.setNome(rs.getString("grup_nome"));
                grup.setDiscr(rs.getString("grup_desc"));

                grupos.add(grup);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return grupos;

    }

    public void excluirGrupos(int idGrupo) {
        try {

            pstm = bd.conectar().prepareStatement(deletarGrupo);
            pstm.setInt(1, idGrupo);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
