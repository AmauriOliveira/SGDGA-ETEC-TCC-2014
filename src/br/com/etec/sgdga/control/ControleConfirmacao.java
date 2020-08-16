package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleConfirmacao {

    PreparedStatement pstm;
    ResultSet rs;
    AcessoMySql bd = new AcessoMySql();

    String consultarLogin = "SELECT * FROM ACESSO WHERE ACE_LOGIN like ?  ";
    String cadastrarLogin = "INSERT INTO ACESSO(ACE_LOGIN,ACE_SENHA,ACE_NIVEL) VALUES(?,?,?)";
    String alterarLogin = "UPDATE ACESSO SET ACE_LOGIN = ?,ACE_SENHA = ? WHERE ace_ID = ?";
    String deletarLogin = "DELETE FROM ACESSO WHERE ace_ID = ?";

    public List<BasicConfirmacao> listarLogin(String login) {
        List<BasicConfirmacao> logins = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarLogin);
            pstm.setString(1, login);
            rs = pstm.executeQuery();

            BasicConfirmacao log;

            while (rs.next()) {
                log = new BasicConfirmacao();
                log.setId(rs.getInt("ace_id"));
                log.setLogin(rs.getString("ace_login"));
                log.setPassword(rs.getString("ace_senha"));
                log.setNivel(rs.getInt("ace_nivel"));

                logins.add(log);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", 0);
        }
        return logins;

    }

    public void cadastrarLogins(BasicConfirmacao logs) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarLogin);
            pstm.setString(1, logs.getLogin());
            pstm.setString(2, logs.getPassword());
            pstm.setInt(3, logs.getNivel());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
        }

    }

    public void excluirLogin(int idlogin) {
        try {

            pstm = bd.conectar().prepareStatement(deletarLogin);
            pstm.setInt(1, idlogin);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void alterarLogin(BasicConfirmacao login) {
        try {

            pstm = bd.conectar().prepareStatement(alterarLogin);
            pstm.setString(1, login.getLogin());
            pstm.setString(2, login.getPassword());
            pstm.setInt(3, login.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }
}
