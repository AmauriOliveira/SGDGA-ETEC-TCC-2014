package br.com.etec.sgdga.database;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlaConexao {

    public static Connection getControlaConexao() throws SQLException, ClassNotFoundException {

        Class.forName(
                "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/sgdga?user=root&password=amauri32");

    }

    public static void fecharResultado(ResultSet resultado) throws SQLException {
        if (resultado != null) {
            resultado.close();
        }
    }

    public static void fecharInstrucao(PreparedStatement instrucao) {
        if (instrucao != null) {
            try {
                instrucao.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void fecharConexao(Connection conexao) throws SQLException {
        try {
            conexao.close();

        } catch (SQLException e) {
        }
    }
}
