package br.com.etec.sgdga.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AcessoMySql {

    Connection con;


    public AcessoMySql() {
    }



    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AcessoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao encontrar o driver", "Erro", 0);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sgdga?user=root&password=amauri32");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados", "Erro", 0);
        }
        
        return con;

    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoMySql.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha ao desconectar do banco de dados", "Erro", 0);
        }
    }

}
