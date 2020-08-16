package br.com.etec.sgdga.access;

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

    String consultarLogin = "SELECT * FROM control WHERE login = ?";
    String cadastrarLogin = "INSERT INTO control(LOGIN,SENHA,ACCESS) VALUES(?,?,?)";

    public List<BasicConfirmacao> listarLogin(String login) {
        List<BasicConfirmacao> logins = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarLogin);
            pstm.setString(1, login);
            rs = pstm.executeQuery();

            BasicConfirmacao log;

            while (rs.next()) {
                log = new BasicConfirmacao();
                log.setId(rs.getInt("id"));
                log.setLogin(rs.getString("login"));
                log.setPassword(rs.getString("senha"));
                log.setNivel(rs.getInt("access"));

                logins.add(log);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Erro", 0);
        }
        return logins;

    }

}