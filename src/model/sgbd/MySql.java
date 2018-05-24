package model.sgbd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySql{

	public static Boolean status = false;
	


	public static Boolean getStatus() {
        return status;
    }
	
	public static Connection getConexaoMySQL() {
		Connection connection = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);	
			String server = "localhost";
			String database = "MEUSORTEIOONLINE";
			String url = "jdbc:mysql://" + server + "/" + database;			 
            String username = "root";      
            String password = "4dv@nc3dpwd";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null)
                status = true;
            else {
            	status = false;
            }
			return connection;
        }
		catch (ClassNotFoundException e) {
			status = false;
			return null;
		}
		catch (SQLException e) {
			status = false;
			return null;
		}
	}
	
	public static boolean pararConexao(Connection connection) {
        try {
        	connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

	public static Connection reiniciarConexao(Connection connection) {
        pararConexao(connection);
        return MySql.getConexaoMySQL();
    }
 
}