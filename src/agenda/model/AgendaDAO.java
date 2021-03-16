package agenda.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Conexão efetuada com sucesso! " + con);
			return con;
		} catch (Exception e) {
			System.err.println("Erro de conexão: " + e);
			return null;
		}
	}
	
	public void inserirContato(AgendaBean contato) {
		String create = "INSERT INTO contatos(nome, fone, email) VALUES(?, ?, ?)";
		
		try {
			Connection con = conectar();
			PreparedStatement statement = con.prepareStatement(create);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setString(3, contato.getEmail());
			statement.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<AgendaBean> listarContatos() {
		List<AgendaBean> contatos = new ArrayList<>();
		String read = "SELECT * FROM contatos ORDER BY nome";
		
		try {
			Connection con = conectar();
			PreparedStatement statement = con.prepareStatement(read);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				AgendaBean contato = new AgendaBean();
				contato.setIdcon(rs.getString("idcon"));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setEmail(rs.getString("email"));
				
				contatos.add(contato);
			}
			con.close();			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return contatos;
	}
	
	public void selecionarContato(AgendaBean contato) {
		String read2 = "SELECT * FROM contatos WHERE idcon = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement statement = con.prepareStatement(read2);
			statement.setString(1, contato.getIdcon());
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				contato.setIdcon(rs.getString("idcon"));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setEmail(rs.getString("email"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
