/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author HeuberLima
 */
public class EAssociado {
    
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private ETipoAssociado tipoAssociado;

    public EAssociado() {
        tipoAssociado = new ETipoAssociado();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ETipoAssociado getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(ETipoAssociado tipoAssociado) {
        this.tipoAssociado = tipoAssociado;
    }
    
    
    
}
