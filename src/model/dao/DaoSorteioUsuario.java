package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.entidade.UsuarioSorteio;
import model.sgbd.MySql;

public class DaoSorteioUsuario {
	

	
	public boolean cadastra(UsuarioSorteio usuSor) {
		
		boolean retorno = false;
		
		

		String sql = "INSERT INTO USUARIO_SORTEIO (ID_USER, ID_SORTEIO) VALUES (" + usuSor.getIdUser() + "," + usuSor.getIdSorteio() + ");";
		
		
		
		try {
			Connection conn = MySql.getConexaoMySQL();
			
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
			ps.executeUpdate();
			retorno = true;
			
			MySql.pararConexao(conn);
			
			
		}catch(SQLException e) {
			
		}
		
		
		return retorno;
		
	}
	
	public int sorteia(String emailUser, int idSorteio) {
		
		return 1;
	}
}
