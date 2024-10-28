package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	
	public Connection con = null;//é uma interface
	public PreparedStatement st = null; //aqui onde iremos inserir o comando SQL
	public ResultSet rs = null; //Resultado do retorno do comando SQL
	
	//caminho do pacote, mais a classe que será conectada
	//public final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//Aponta para a classe do JAVA, que é o driver em si, ver REFERENCED LIVRARIES
	public final String DRIVER = "org.postgresql.Driver";
	public final String DATABASE = "pi_teste"; //poo
	//public final String URL = "jdbc:sqlserver://localhost:1433;databasename="+DATABASE;
	public final String URL = "jdbc:postgresql://localhost:5432/"+DATABASE;
	public final String LOGIN = "postgres";
	public final String SENHA = "postgres";
	
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			//System.out.println("Driver carregado");
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			//System.out.println("Conectou...");
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver não encontrado!!!");
			return false;
		}
		catch (SQLException erro) {
			System.out.println("Falha na conexão(Verificar URL SENHA LOGIN)!!! "+erro);
			return false;
		}
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
		}
		catch(SQLException e) {}
		try {
			if(st!=null) st.close();
		}
		catch(SQLException e) {}
		try {
			if(con!=null) {
				//System.out.println("Desconectou...");
				con.close();
			}
		}
		catch(SQLException e) {}
	}
	
	public static void main(String[] args) { //só para facilitar
		BD bd = new BD();
		bd.getConnection();
		bd.close();
	}
}
