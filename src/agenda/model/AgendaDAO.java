package agenda.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class AgendaDAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "admin";
		
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.err.println("Erro de conexão: " + e);
			return null;
		}
	}
	
	public void testarConexao() {
		try {
			Connection con = conectar();
			System.out.println("Conexão efetuada com sucesso: " + con);
		} catch (Exception e) {
			System.err.println("Erro de conexão: " + e);
		}
	}
}
