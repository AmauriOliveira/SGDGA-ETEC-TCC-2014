package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControleNota {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarNota = "SELECT * FROM NOTA WHERE NOTA_DATA between ? and ?";
    String cadastrarNota = "INSERT INTO NOTA (NOTA_HORA,NOTA_DATA,NOTA_CLIENTE,NOTA_TIPO_PAG,NOTA_VLR_TOTAL,NOTA_Desconto,NOTA_FINAL) VALUES(?,?,?,?,?,?,?)";
    String alterarNota = "UPDATE NOTA SET NOTA_HORA = ?,NOTA_DATA = ?,NOTA_CLIENTE = ?,NOTA_TIPO_PAG = ?,NOTA_VLR_total = ?,NOTA_Desconto =?, NOTA_FINAL = ? WHERE NOTA_ID = ?";
    String deletarNota = "DELETE FROM NOTA WHERE NOTA_ID = ?";
    String buscaUltimoId = "SELECT MAX(Nota_ID) AS Nota_ID FROM Nota";

    AcessoMySql bd = new AcessoMySql();

    public int buscarIdUltimaVenda() {
        try {
            pstm = bd.conectar().prepareStatement(buscaUltimoId);
            rs = pstm.executeQuery();
            if (rs.last()) {
                return rs.getInt("Nota_ID");
            }

            bd.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;
    }

    public void alterarNotas(BasicNota nota) {
        try {

            pstm = bd.conectar().prepareStatement(alterarNota);
            pstm.setTime(1, nota.getHora());
            pstm.setDate(2, nota.getData());
            pstm.setInt(3, nota.getCliente());
            pstm.setInt(4, nota.getPagamento());
            pstm.setDouble(5, nota.getValor());
            pstm.setDouble(6, nota.getDesconto());
            pstm.setDouble(7, nota.getValorFinal());
            pstm.setInt(8, nota.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarNotas(BasicNota nota) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarNota);

            pstm.setTime(1, nota.getHora());
            pstm.setDate(2, nota.getData());
            pstm.setInt(3, nota.getCliente());
            pstm.setInt(4, nota.getPagamento());
            pstm.setDouble(5, nota.getValor());
            pstm.setDouble(6, nota.getDesconto());
            pstm.setDouble(7, nota.getValorFinal());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicNota> listarVenda(Date dataInicial, Date dataFinal) {
        try {
            pstm = bd.conectar().prepareStatement(consultarNota);
            pstm.setDate(1, dataInicial);
            pstm.setDate(2, dataFinal);
            rs = pstm.executeQuery();
            List<BasicNota> nota = new ArrayList<>();

            while (rs.next()) {
                BasicNota not = new BasicNota();
                not.setId(rs.getInt("NOTA_id"));
                not.setHora(rs.getTime("NOTA_HORA"));
                not.setData(rs.getDate("NOTA_DATA"));
                not.setCliente(rs.getInt("NOTA_CLIENTE"));
                not.setPagamento(rs.getInt("NOTA_TIPO_PAG"));
                not.setValor(rs.getInt("NOTA_VLR_Total"));
                not.setDesconto(rs.getDouble("NOTA_DESconto"));
                not.setValorFinal(rs.getDouble("NOTA_FINAL"));

                nota.add(not);

            }
            bd.desconectar();

            return nota;

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + ex, "Erro", 0);
        }

        return null;
    }

    public void excluirNota(int idNota) {
        try {

            pstm = bd.conectar().prepareStatement(deletarNota);
            pstm.setInt(1, idNota);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
