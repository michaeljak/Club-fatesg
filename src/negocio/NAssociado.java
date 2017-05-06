/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.EAssociado;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAssociado;

/**
 *
 * @author HeuberLima
 */
public class NAssociado {

    PAssociado persistencia;
    
    public NAssociado() {
        persistencia = new PAssociado();
    }
    
    public void salvar(EAssociado parametro) throws SQLException{
        if(parametro.getCodigo() == 0 ){
            persistencia.incluir(parametro);
        }else{
            persistencia.alterar(parametro);
        }
    }
    
    public void excluir(int parametro) throws SQLException, Exception{
        persistencia.excluir(parametro);
    }
    
    public EAssociado consultar(int parametro) throws SQLException{
      return persistencia.consultar(parametro);
    }
    
    public List<EAssociado> listar(String nome) throws SQLException{
        return persistencia.listar(nome);
    }
    
}
