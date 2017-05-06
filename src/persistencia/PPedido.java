/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import entidade.EPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HeuberLima
 */
public class PPedido {

    public void incluir(EPedido pedido) throws SQLException {
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            String sql = "INSERT INTO pedido (datapedido, valortotal, codigo_associado) "
                    + "VALUES (now(),?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDouble(1, pedido.getValorTotal());
            ps.setInt(2, pedido.getAssociado().getCodigo());
            ps.execute();
            String sql2 = "SELECT currval('pedido_codigo_seq') as codigo";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql2);
            if (rs.next()) {
                pedido.setCodigo(rs.getInt("codigo"));
            }
            rs.close();
            PItemPedido pItem = new PItemPedido();
            for (EItemPedido item : pedido.getListaItens()) {
                item.getPedido().setCodigo(pedido.getCodigo());
                pItem.incluir(item, cnn);
            }
            //Efetua a gravação no banco de dados
            cnn.commit();
        } catch (Exception e) {
            //Desfaz as alterações no banco de dados 
            cnn.rollback();
        }
        cnn.close();
    }

    public void alterar(EPedido pedido) throws SQLException {
        Connection cnn = util.Conexao.getConexao();
        cnn.setAutoCommit(false);
        try {
            String sql = "UPDATE pedido "
                    + "SET datapedido = now(), "
                    + "valortotal = ? WHERE codigo = ?";

            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setDouble(1, pedido.getValorTotal());
            ps.setInt(2, pedido.getCodigo());
            ps.execute();

            PItemPedido pItem = new PItemPedido();
            pItem.excluirPorPedido(pedido.getCodigo(), cnn);

            for (EItemPedido item : pedido.getListaItens()) {
                item.getPedido().setCodigo(pedido.getCodigo());
                pItem.incluir(item, cnn);
            }
            //Efetua a gravação no banco de dados
            cnn.commit();
        } catch (Exception e) {
            //Desfaz as alterações no banco de dados 
            cnn.rollback();
        }
        cnn.close();
    }
}
