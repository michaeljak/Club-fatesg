/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EProduto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Heuber
 */
public class NProduto {

    public EProduto consultar(int parametro) throws SQLException{
        return new persistencia.PProduto().consultar(parametro);
    }

    public List<EProduto> listar(EProduto parametro) throws Exception{
        return new persistencia.PProduto().listar(parametro);
    }
    
}
