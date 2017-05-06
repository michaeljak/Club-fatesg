/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAssociado;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HeuberLima
 */
public class PAssociadoTest {
    
    public PAssociadoTest() {
    }

    /**
     * Test of incluir method, of class PAssociado.
     */
    @Test
    public void testarIncluir() throws Exception {
        System.out.println("incluir");
        EAssociado parametro = new EAssociado();
        
        parametro.setNome("Teste");
        parametro.setEndereco("Teste");
        parametro.setTelefone("123456");
        parametro.setTipoAssociado(new PTipoAssociado().consultar(1));
        
        PAssociado instance = new PAssociado();
        instance.incluir(parametro);
        
        Assert.assertEquals(3, parametro.getCodigo());
        
        
    }

    
    
}
