/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EPedido;
import java.sql.SQLException;
import persistencia.PPedido;

/**
 *
 * @author HeuberLima
 */
public class NPedido {
    
    
    public void salvar(EPedido pedido) throws SQLException{
        
        PPedido persistencia = new PPedido();
        if(pedido.getCodigo() == 0){
            persistencia.incluir(pedido);
        }else{
            persistencia.alterar(pedido);
        }
    }
    
}
