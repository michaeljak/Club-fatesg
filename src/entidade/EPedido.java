/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HeuberLima
 */
public class EPedido {
    
    private int codigo;
    private Date data;
    private double valorTotal;
    
    private EAssociado associado;
    private List<EItemPedido> listaItens;

    public EPedido() {
        associado = new EAssociado();
        listaItens = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void setValorTotalAcumulando(double valor) {
        this.valorTotal += valor;
    }
    public EAssociado getAssociado() {
        return associado;
    }

    public void setAssociado(EAssociado associado) {
        this.associado = associado;
    }

    public List<EItemPedido> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<EItemPedido> listaItens) {
        this.listaItens = listaItens;
    }
    
    
}
