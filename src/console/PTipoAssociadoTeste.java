/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import entidade.ETipoAssociado;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;
import persistencia.PTipoAssociado;

/**
 *
 * @author HeuberLima
 */
public class PTipoAssociadoTeste {

    public static void main(String[] args) throws SQLException {
//
//        System.out.println("Testando a inclusao do tipo associado");
//
//        ETipoAssociado tipoAssociado = new ETipoAssociado();
//        tipoAssociado.setDescricao("Sócio Titular");
//        tipoAssociado.setValorMensalidade(100.0);
//
//        PTipoAssociado persistencia = new PTipoAssociado();
//        persistencia.incluir(tipoAssociado);
//
//        if (tipoAssociado.getCodigo() != 0) {
//            System.out.println("Inclusao efetuada com sucesso!");
//        } else {
//            System.out.println("Aconteceu algum boró");
//        }
        
        
//        System.out.println("Testando a alteração");
//        
//        ETipoAssociado tipo = new ETipoAssociado();
//        PTipoAssociado persistencia = new PTipoAssociado();
//        
//        tipo.setCodigo(2);
//        tipo.setDescricao("Sócio Dependente");
//        tipo.setValorMensalidade(75.00);
//        
//        persistencia.alterar(tipo);
//        
//        System.out.println("Tipo alterado com sucesso!");
        
        
//        System.out.println("Testando a exclusão");
//        PTipoAssociado persistencia = new PTipoAssociado();
//        persistencia.excluir(3);
//        System.out.println("Excluido com sucesso");
        
//        System.out.println("Testando o consultar");
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Digite o código: ");
//        int codigo = scanner.nextInt();
//        
//        PTipoAssociado persistencia = new PTipoAssociado();
//        ETipoAssociado tipo = persistencia.consultar(codigo);
//        
//        if(tipo.getCodigo() != 0){
//            System.out.println("Código.............: " + tipo.getCodigo());
//            System.out.println("Descrição..........: " + tipo.getDescricao());
//            System.out.println("Valor Mensalidade..: " + tipo.getValorMensalidade());
//        }else{
//            System.out.println("Tipo Associado não encontrado!");
//        }
        
        System.out.println("Testando o listar");
        
        PTipoAssociado persistencia = new PTipoAssociado();
        List<ETipoAssociado> lista = persistencia.listar();
        
        for (ETipoAssociado tipo : lista) {
            System.out.println("Código.............: " + tipo.getCodigo());
            System.out.println("Descrição..........: " + tipo.getDescricao());
            System.out.println("Valor Mensalidade..: " + tipo.getValorMensalidade());
            System.out.println();
        }    
            
            System.out.println("Listagem finalizada!");
        
    }

}
