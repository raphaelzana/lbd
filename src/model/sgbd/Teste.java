package model.sgbd;

import java.sql.Connection;


public class Teste {

	public static void main(String[] args) {
		Connection con = MySql.getConexaoMySQL();
		if(con!=null) {
			System.out.println("deu");
			MySql.pararConexao(con);
		}
		else {
			System.out.println("fail");
		}
	}
	
}