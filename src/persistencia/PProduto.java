package persistencia;

import entidade.EProduto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Heuber
 */
public class PProduto {

    public EProduto consultar(int parametro) throws SQLException {

        //Cria o objeto para a conexao
        Connection conexao = Conexao.getConexao();

        String sql = "SELECT * FROM produto WHERE codigo = ?";
        PreparedStatement prd = conexao.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        EProduto retorno = new EProduto();

        if (rs.next()) {
            retorno.setCodigo(rs.getInt("codigo"));
            retorno.setNome(rs.getString("nome"));
            retorno.setQuantidade(rs.getInt("quantidade"));
            retorno.setValor(rs.getDouble("valor"));
        }
        rs.close();
        conexao.close();

        return retorno;
    }

    public List<EProduto> listar(EProduto parametro) throws SQLException {
        //Cria o objeto para a conexao
        Connection conexao = Conexao.getConexao();

        String sql = "SELECT * FROM produto WHERE 1=1 ";

        if (parametro.getNome()!= null) {
            if (!parametro.getNome().isEmpty()) {
                sql += " and upper(nome) like ?";
            }
        }

        PreparedStatement prd = conexao.prepareStatement(sql);

        if (parametro.getNome() != null) {
            if (!parametro.getNome().isEmpty()) {
                prd.setString(1, "%" + parametro.getNome().toUpperCase() + "%");
            }
        }

        ResultSet rs = prd.executeQuery();
        List<EProduto> lista = new ArrayList<>();

        while (rs.next()) {
            EProduto produto = new EProduto();
            produto.setCodigo(rs.getInt("codigo"));
            produto.setNome(rs.getString("nome"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setValor(rs.getDouble("valor"));
            lista.add(produto);
        }
        rs.close();
        conexao.close();

        return lista;
    }
}
