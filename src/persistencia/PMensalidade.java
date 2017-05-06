/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HeuberLima
 */
public class PMensalidade {

    public boolean existeMensalidadeAberto(int codigoAssociado) throws SQLException {

        boolean retorno = false;

        Connection cnn = util.Conexao.getConexao();
        String sql = "SELECT COUNT(*) AS qtde_vencidas FROM mensalidade"
                + " WHERE datapagamento IS NULL"
                + " AND datavencimento + INTERVAL '15 DAYS' < now()"
                + " AND codigo_associado = ?";
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigoAssociado);

        ResultSet rs = prd.executeQuery();
        if (rs.next()) {
            int valor = rs.getInt("qtde_vencidas");

            if (valor != 0) {
                retorno = true;
            }
        }
        rs.close();
        cnn.close();

        return retorno;

    }

}
