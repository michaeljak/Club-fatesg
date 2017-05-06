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
public class EItemPedido {
    
    private int codigo;
    private double quantidade;
    private double valor;
    
    private EPedido pedido;
    private EProduto produto;

    public EItemPedido() {
        pedido = new EPedido();
        produto = new EProduto();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EPedido getPedido() {
        return pedido;
    }

    public void setPedido(EPedido pedido) {
        this.pedido = pedido;
    }

    public EProduto getProduto() {
        return produto;
    }

    public void setProduto(EProduto produto) {
        this.produto = produto;
    }
    
    
}
