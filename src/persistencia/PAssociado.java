/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.EAssociado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heuber
 */
public class PAssociado {

    public PAssociado() {
    }

    public void incluir(EAssociado parametro) throws SQLException {

        //Cria a string com o sql para ser executado
        String sql = "INSERT INTO associado ( nome,"
                + "endereco, telefone, "
                + "codigo_tipo_associado) VALUES (?, ?, ?, ?)";

        //Cria o objeto de conexão com o banco
        Connection cnn = util.Conexao.getConexao();

        //Cria o objeto para executar os comandos "contra" o banco
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Seta os valores recebidos como parametro para a string SQL
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());
        prd.setInt(4, parametro.getTipoAssociado().getCodigo());

        //Executa o SQL no banco de dados
        prd.execute();

        //Cria o sql para recuperar o codigo gerado
        String sql2 = "SELECT currval('associado_codigo_seq') as codigo";

        //Crio o statement a partir da conexao
        Statement st = cnn.createStatement();

        //Crio o resultset a partir do sql
        ResultSet rs = st.executeQuery(sql2);

        if (rs.next()) {
            parametro.setCodigo(rs.getInt("codigo"));
        }

        rs.close();
        cnn.close();

    }

    public void alterar(EAssociado parametro) throws SQLException {

        //Cria o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        String sql = "UPDATE associado "
                + "SET nome = ?, "
                + "endereco = ?, "
                + "telefone = ?, "
                + "codigo_tipo_associado = ?  "
                + " WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getNome());
        prd.setString(2, parametro.getEndereco());
        prd.setString(3, parametro.getTelefone());
        prd.setInt(4, parametro.getTipoAssociado().getCodigo());
        prd.setInt(5, parametro.getCodigo());

        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {

        //Cria o objeto para a conexao
        Connection cnn = util.Conexao.getConexao();

        String sql = "DELETE FROM associado WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        prd.execute();
        cnn.close();
    }

    public EAssociado consultar(int parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();
        String sql = "SELECT codigo, nome, endereco, "
                + "telefone, codigo_tipo_associado "
                + "FROM associado WHERE codigo = ?";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        EAssociado retorno = new EAssociado();
        if (rs.next()) {
            retorno.setCodigo(rs.getInt("codigo"));
            retorno.setNome(rs.getString("nome"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setTipoAssociado(
                    new PTipoAssociado().consultar(rs.getInt("codigo_tipo_associado"))
            );
        }
        rs.close();
        cnn.close();

        return retorno;
    }

    public List<EAssociado> listar(String nome) throws SQLException {
        List<EAssociado> lista = new ArrayList<>(); //<<<<<<<<<<<<<<<<<<<<<<

        Connection cnn = util.Conexao.getConexao();

        String sql = "SELECT * "
                + "FROM associado "
                + "WHERE 1=1 ";

        if (nome != null) {
            if (!nome.isEmpty()) {
                sql += " and nome like ? ";
            }
        }

        sql += "ORDER BY nome";

        PreparedStatement prd = cnn.prepareStatement(sql);
        
        
        if (nome != null) {
            if (!nome.isEmpty()) {
                prd.setString(1, "%" + nome + "%");
            }
        }

        ResultSet rs = prd.executeQuery();

        while (rs.next()) {
            EAssociado associado = new EAssociado();
            associado.setCodigo(rs.getInt("codigo"));
            associado.setNome(rs.getString("nome"));
            associado.setEndereco(rs.getString("endereco"));
            associado.setTelefone(rs.getString("telefone"));
            lista.add(associado);
        }
        rs.close();
        cnn.close();

        return lista;
    }

}
