package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

import model.entidade.Sorteio;
import model.entidade.UsuarioSorteio;
import model.sgbd.MySql;

public class DaoSorteioUsuario {
	
	ResultSet rs;
	
	public int sorteia(String emailUser, int idSorteio) {

		int retorno = 0;
				
				Sorteio sor = new Sorteio();
				
				//String sql = "SELECT * FROM SORTEIO WHERE ID = ?"; 	
				
				Connection conn = MySql.getConexaoMySQL();
				
				try {
					
					PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM SORTEIO WHERE ID = " + String.valueOf(idSorteio));
					
					//ps.setString(1, String.valueOf(idSorteio));
					
					this.rs = ps.executeQuery();
					
					while(this.rs.next()) {
					
						sor.setEmail(this.rs.getString("EMAIL"));
					}
					
					System.out.println(sor.getEmail());
					System.out.println(emailUser);
					
					if(sor.getEmail().equals(emailUser)) {
						
						UsuarioSorteio usuSor = new UsuarioSorteio();
						
						//sql = "SELECT * FROM USUARIO_SORTEIO WHERE ID_SORTEIO = ?";
						
						ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM USUARIO_SORTEIO WHERE ID_SORTEIO = " + String.valueOf(idSorteio));
						
						//ps.setString(1, String.valueOf(idSorteio));
						
						this.rs = ps.executeQuery();
						
						List<Integer> lus = new ArrayList<Integer>();
						int i = 0;
						while(this.rs.next()) {
							System.out.println(this.rs.getInt("ID_USER"));
							usuSor.setIdUser(this.rs.getInt("ID_USER"));
							System.out.println(this.rs.getInt("ID_SORTEIO"));
							usuSor.setIdSorteio(this.rs.getInt("ID_SORTEIO"));
							lus.add(usuSor.getIdUser());
					}
						
					Random gerador = new Random();
					
					int tam = lus.size();
				
					int sorteado = gerador.nextInt(tam);
				
					System.out.println(lus.get(sorteado) + " ganhador");
					
					retorno = lus.get(sorteado);
						
					}
					} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					MySql.pararConexao(conn);
				}			
				
				return retorno;
			}

	
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
	
}
