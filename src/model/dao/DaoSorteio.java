package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.entidade.Sorteio;
import model.sgbd.MySql;

public class DaoSorteio {
	
	private ResultSet rs;
	
	public boolean criar (Sorteio sor) {
		
		boolean retorno = false;
		
		String sql = "INSERT INTO SORTEIO (NOME, EMAIL, DATA_TERMINO, DESCRICAO, PREMIACAO) VALUES (?, ?, ?, ?, ?);";
		
		try {
			Connection conn = MySql.getConexaoMySQL();
			
			
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);

			ps.setString(1, sor.getNome());
			ps.setString(2, sor.getEmail());
			ps.setString(3, sor.getData_termino());
			ps.setString(4, sor.getDescricao());
			ps.setString(5, sor.getPremiacao());
			
			System.out.println(ps.toString());
			
			try {
				/* Validar retorno do comando sql
				   Verificar se foi executado */
				ps.executeUpdate();
				retorno = true;
				
				MySql.pararConexao(conn);
				
			}
			catch(SQLException e){
				System.out.println("bug");
				retorno = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return retorno;
	}
	
	public Sorteio procurar(Integer id) {
		
		Sorteio sor = new Sorteio();
		
		String sql = "SELECT * FROM SORTEIO WHERE id = ?";
		
		Connection conn = MySql.getConexaoMySQL();
		
		try {
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			ps.setString(1, id.toString());
			
			
			this.rs = ps.executeQuery();
			
			while(this.rs.next()) {
				sor.setId(this.rs.getInt("ID"));
				sor.setNome(this.rs.getString("NOME"));
				sor.setEmail(this.rs.getString("EMAIL"));
				sor.setData_termino(this.rs.getString("DATA_TERMINO"));
				sor.setDescricao(this.rs.getString("DESCRICAO"));
				sor.setPremiacao(this.rs.getString("PREMIACAO"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MySql.pararConexao(conn);
		}			
		return sor;
	}
	
	

}