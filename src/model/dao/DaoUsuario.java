package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.entidade.Usuario;
import model.sgbd.MySql;

public class DaoUsuario {
	
	private ResultSet rs;
	
	public String consultaEmail(int idUser) {
		
		String retorno = "";
		
		String sql = "SELECT * FROM USUARIO WHERE ID = ?";
		
		Connection conn = MySql.getConexaoMySQL();
		
		try {
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(idUser));
			
			Usuario user = new Usuario();
			
			this.rs = ps.executeQuery();
			
			while(this.rs.next()) {
				user.setEmail(this.rs.getString("EMAIL"));
			}
			retorno = user.getEmail();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MySql.pararConexao(conn);
		}		
		
		return retorno;
	}
	
	public Usuario login (Usuario usu) {
		
		Usuario retorno = null;
		
		String sql = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";
		
		Connection conn = MySql.getConexaoMySQL();
		
		try {
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, usu.getEmail());
			ps.setString(2, usu.getSenha());
			
			Usuario user = new Usuario();
			
			this.rs = ps.executeQuery();
			
			while(this.rs.next()) {
				user.setId(this.rs.getInt("ID"));
				user.setEmail(this.rs.getString("EMAIL"));
				user.setSenha(this.rs.getString("SENHA"));
				retorno = user;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MySql.pararConexao(conn);
		}		
		return retorno;
	}
	
	public boolean cadastra (Usuario usu) {
		boolean retorno = false;
		
		String sql = "INSERT INTO USUARIO (EMAIL, SENHA) VALUES (?, ?);";
		
		try {
			Connection conn = MySql.getConexaoMySQL();
			
			
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);

			ps.setString(1, usu.getEmail());
			ps.setString(2, usu.getSenha());
			
			ps.executeUpdate();
			retorno = true;
			
			MySql.pararConexao(conn);
			
			
		}catch(SQLException e) {
			
		}
		
		
		return retorno;
	}
		
}
	
	