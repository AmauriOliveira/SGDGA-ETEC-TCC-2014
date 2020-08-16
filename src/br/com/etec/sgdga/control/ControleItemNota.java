package br.com.etec.sgdga.control;

import br.com.etec.sgdga.database.AcessoMySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleItemNota {

    PreparedStatement pstm;
    ResultSet rs;
    String consultarItemNota = "SELECT * FROM ITEMS_NOTA WHERE ITM_NOTA_FISCAL LIKE ?";
    String cadastrarItemNota = "INSERT INTO ITEMS_NOTA (ITM_NOTA_FISCAL,ITM_PRODUTO,ITM_QTD,ITM_VALOR_UND,ITM_SUBTOTAL) VALUES(?,?,?,?,?)";
    String alterarItemNota = "UPDATE ITEM_NOTAS SET ITM_NOTA_FISCAL = ?,ITM_PRODUTO = ?,ITM_QTD = ?,ITM_VALOR_UND = ?,ITM_SUBTOTAL = ? WHERE ITM_ID = ?";
    String deletarItemNota = "DELETE FROM ITEMS_NOTA WHERE ITM_ID = ?";

    AcessoMySql bd = new AcessoMySql();

    public void alterarItemNotas(BasicItemNota item) {
        try {

            pstm = bd.conectar().prepareStatement(alterarItemNota);
            pstm.setInt(1, item.getNota());
            pstm.setInt(2, item.getProduto());
            pstm.setInt(3, item.getQuantidade());
            pstm.setDouble(4, item.getValorUni());
            pstm.setDouble(5, item.getSubTotal());
            pstm.setInt(6, item.getId());
            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public void cadastrarItemNotas(BasicItemNota item) {
        try {

            pstm = bd.conectar().prepareStatement(cadastrarItemNota);

            pstm.setInt(1, item.getNota());
            pstm.setInt(2, item.getProduto());
            pstm.setInt(3, item.getQuantidade());
            pstm.setDouble(4, item.getValorUni());
            pstm.setDouble(5, item.getSubTotal());

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

    public List<BasicItemNota> listarItemNotas(int item) {
        List<BasicItemNota> itensNotas = new ArrayList();
        try {

            pstm = bd.conectar().prepareStatement(consultarItemNota);
            pstm.setInt(1, item);
            rs = pstm.executeQuery();

            BasicItemNota nota;

            while (rs.next()) {
                nota = new BasicItemNota();
                nota.setId(rs.getInt("itm_id"));
                nota.setNota(rs.getInt("ITM_NOTA_FISCAL"));
                nota.setProduto(rs.getInt("ITM_PRODUTO"));
                nota.setQuantidade(rs.getInt("ITM_QTD"));
                nota.setValorUni(rs.getInt("ITM_VALOR_UND"));
                nota.setSubTotal(rs.getInt("ITM_SUBTOTAL"));

                itensNotas.add(nota);

            }
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }
        return itensNotas;

    }

    public void excluirItemNota(int idItemNota) {
        try {

            pstm = bd.conectar().prepareStatement(deletarItemNota);
            pstm.setInt(1, idItemNota);

            pstm.executeUpdate();
            bd.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Um erro foi encontrado\n" + e, "Erro", 0);
        }

    }

}
