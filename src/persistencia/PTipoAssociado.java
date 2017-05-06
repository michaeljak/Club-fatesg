package persistencia;

import entidade.ETipoAssociado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PTipoAssociado {
    
    public void incluir(ETipoAssociado parametro) throws SQLException{

        //Cria a string do SQL a ser executado
        String sql = "INSERT INTO tipo_associado (descricao, valor_mensalidade)"
                + " VALUES (?,?)";
        
        //Cria o objeto cnn com base na fábrica de conexões
        Connection cnn = util.Conexao.getConexao();
        //Cria o objeto prd, a partir do SQL e em cima 
        //da conexão criada anteriormente
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        //Seta os valores do prepared (?) com base no parametro recebido
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        
        //Executa o SQL contra o banco de dados;
        prd.execute();
        
        //Cria o sql para recuperar o codigo gerado
        String sql2 = "SELECT currval('tipo_associado_codigo_seq') as codigo";
        
        //Crio o statement a partir da conexao
        Statement st = cnn.createStatement();
        
        //Crio o resultset a partir do sql
        ResultSet rs = st.executeQuery(sql2);
        
        if(rs.next()){
            parametro.setCodigo(rs.getInt("codigo"));
        }
        
        rs.close();
        cnn.close();
    }
    
    public void alterar(ETipoAssociado parametro) throws SQLException{
    
        String sql = "UPDATE tipo_associado SET descricao = ?, "
                + "valor_mensalidade = ? "
                + "WHERE codigo = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
         //Seta os valores do prepared (?) com base no parametro recebido
        prd.setString(1, parametro.getDescricao());
        prd.setDouble(2, parametro.getValorMensalidade());
        prd.setInt(3, parametro.getCodigo());
    
        prd.execute();
        
        cnn.close();
    
    }
    
    public void excluir(int codigo) throws SQLException{
        
        String sql = "DELETE FROM tipo_associado WHERE codigo = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, codigo);
        
        prd.execute();
        
        cnn.close();
    
    }
    
    public ETipoAssociado consultar(int codigo) throws SQLException{
    
        String sql = "SELECT * FROM tipo_associado WHERE codigo = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);
        
        ResultSet  rs = prd.executeQuery();
        
        ETipoAssociado objeto = new ETipoAssociado();
        if(rs.next()){
            objeto.setCodigo(rs.getInt("codigo"));
            objeto.setDescricao(rs.getString("descricao"));
            objeto.setValorMensalidade(rs.getDouble("valor_mensalidade"));
        }
        
        rs.close();
        cnn.close();
        return objeto;
    }
    
    public List<ETipoAssociado> listar() throws SQLException{
    
        String sql = "SELECT * FROM tipo_associado"
                + " ORDER BY descricao";
        Connection cnn = util.Conexao.getConexao();
        
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        List<ETipoAssociado> lista = new ArrayList<>();
        while(rs.next()){
            ETipoAssociado tipo = new ETipoAssociado();
            tipo.setCodigo(rs.getInt("codigo"));
            tipo.setDescricao(rs.getString("descricao"));
            tipo.setValorMensalidade(rs.getDouble("valor_mensalidade"));

            lista.add(tipo);
        }
        return lista;
    }
    
}
