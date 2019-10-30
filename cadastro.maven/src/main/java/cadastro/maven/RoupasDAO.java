package cadastro.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoupasDAO {
	private Connection connection;
	private String url = "jdbc:mysql://localhost/loja?user=root&password=12345&useTimezone=true&serverTimezone=UTC";
	
		public RoupasDAO() {
		try {
			connection = DriverManager.getConnection(url);
			//System.out.println("Conectado");
		}
		catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		}
		}

		public void adiciona(Roupas roupas) {
			String sql = "INSERT INTO roupas(tipo, tam, preco) values (?,?,?)";
			try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, roupas.getTipo());
			stmt.setString(2, roupas.getTam());
			stmt.setString(3, roupas.getPreco());
			stmt.execute();
			stmt.close();
			}
			catch(SQLException u){
				throw new RuntimeException(u);
			}
		}
		public List<Roupas> recupera () {
			String sql = "select * from roupas";
			List<Roupas> roupas = new ArrayList<Roupas>();
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Roupas roupa = new Roupas(rs.getString("tipo"),rs.getString("tam"),rs.getString("preco"));
					roupas.add(roupa);
				}
				stmt.close();
			}
			catch (SQLException u) {
				throw new RuntimeException(u);
			}
			return roupas;
		}
		
		public void atualiza (Roupas roupa) {
			String sql = "update roupas set tipo=?, tam=? where preco=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, roupa.getTipo());
				stmt.setString(2, roupa.getTam());
				stmt.setString(3, roupa.getPreco());
				stmt.execute();
				stmt.close();
				}
			catch(SQLException u){
				throw new RuntimeException(u);
			}
		}
		
		/*public void openConnection () throws SQLException {
			connection = DriverManager.getConnection(url);
		}
		public void closeConnection () throws SQLException {
			connection.close();
		}*/
}

