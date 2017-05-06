/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HeuberLima
 */
public class PItemPedido {
    
    public void incluir(EItemPedido item, Connection cnn) throws SQLException{
        
        String sql = "INSERT INTO item_pedido(quantidade, valor, codigo_pedido"
                + ", codigo_produto) VALUES (?,?,?,?)";
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setDouble(1, item.getQuantidade());
        prd.setDouble(2, item.getValor());
        prd.setInt(3, item.getPedido().getCodigo());
        prd.setInt(4, item.getProduto().getCodigo());
        
        prd.execute();
        
    }
    
     public void excluirPorPedido(int codigoPedido, Connection cnn) throws SQLException{
        
        String sql = "DELETE FROM item_pedido WHERE codigo_pedido = ?";
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigoPedido);
        
        prd.execute();
        
    }
    
}
