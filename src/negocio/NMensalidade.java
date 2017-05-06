/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import persistencia.PMensalidade;

/**
 *
 * @author HeuberLima
 */
public class NMensalidade {
    
    public boolean existeMensalidadeEmAberto(int codigo_associado) throws SQLException{
    
        return new PMensalidade().existeMensalidadeAberto(codigo_associado);
    }
    
}
