/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Heuber
 */
public class ComboItem
{
    private String descricao;
    private String codigo;

    public ComboItem(String descricao, String codigo)
    {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    @Override
    public String toString()
    {
        return descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public String getCodigo()
    {
        return codigo;
    }
}
