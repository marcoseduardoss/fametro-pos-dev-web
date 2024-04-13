package br.fametro.xpto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe depreciada: Não precisamos mais desta classe
 * A conexão agora é feita pelo Spring Boot.
 */
@Deprecated
public class ConexaoJdbcUtil {

	//Informações de conexão com o banco de dados:
	private static final String URL_BD = "jdbc:sqlite:test.db";
	private static final String USUARIO_BD = "admin";
	private static final String SENHA_BD = "123456";
	
	public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL_BD);
    }
	
    public static Connection obterConexao(String url) throws SQLException {
        return DriverManager.getConnection(url, USUARIO_BD, SENHA_BD);
    }
    
    /*
     * Fechar a conexão com o banco de dados
     * 
     * Método depreciado.
     * motivo: Uso do recurso "try-with-resources" 
     * do Java para fechar a conexão após o uso.
     * */
    @Deprecated
    public void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
