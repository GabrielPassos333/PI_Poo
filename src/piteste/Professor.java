package piteste;

//import java.sql.PreparedStatement;
import java.sql.SQLException;
import banco.BD;

public class Professor {

	/**
	 * Lista os professores do banco de dados
	 */
  public void listarProfessores() {
		BD bd = new BD();
		
		if(bd.getConnection()) {
			String sql = "select * from prof";
			try {
				bd.st = bd.con.prepareStatement(sql);//Toda vez que for usar instrução SQL usa isso
				bd.rs = bd.st.executeQuery(); //mas o ponteiro está a uma posição anterior ao primeiro registro
				while(bd.rs.next()){//ele avança um NEXT RETORNA VERDADEIRO OU FALSO
					System.out.println(bd.rs.getInt("id_prof")+","+
							bd.rs.getString("nome"));
				}
				
			} 
			catch (SQLException erro) {
				System.out.println(erro);
			} 
			finally {
				bd.close(); //fecha a conexão
			}
		}
		else {
			System.out.println("Falha ao conectar");
		}
	}

	/**
	 * Adiciona um professor no banco de dados
	 * @param nome do professor
	 */
	public void adicionarProfessor(String nome) {
		BD bd = new BD();
		
		if(bd.getConnection()) {
			String sql = "insert into prof (nome) values (?)";
			try {
				bd.st = bd.con.prepareStatement(sql);//Toda vez que for usar instrução SQL usa isso
				bd.st.setString(1, nome);
				bd.st.executeUpdate();
				System.out.println("Professor adicionado com sucesso");
			} 
			catch (SQLException erro) {
				System.out.println(erro);
				System.out.println("Falha ao adicionar professor");
			} 
			finally {
				bd.close(); //fecha a conexão
			}
		}
		else {
			System.out.println("Falha ao conectar");
		}
	}

	/**
	 * Deleta um professor do banco de dados
	 * @param id do professor
	 */
		public void deletarProfessor(int id) {
			BD bd = new BD();

			if(bd.getConnection()) {
				String sql = "delete from prof where id_prof = ?";

				//listarProfessores();

				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setInt(1, id); // Set the id parameter
					int rowsAffected = bd.st.executeUpdate();
					if (rowsAffected > 0) {
							System.out.println("Professor deletado com sucesso");
					} else {
							System.out.println("Nenhum professor encontrado com o id fornecido");
					}
			} 
			catch (SQLException erro) {
					System.out.println(erro);
					System.out.println("Falha ao deletar professor");
			} 
			finally {
					bd.close();
			}
			} else {
				System.out.println("Falha ao conectar");
			}
  	}

		/**
		 * Atualiza o nome de um professor no banco de dados
		 * @param id do professor
		 * @param nome do professor
		 */
		public void atualizarProfessor(int id, String nome) {
			BD bd = new BD();

			if(bd.getConnection()) {
				String sql = "update prof set nome = ? where id_prof = ?";

				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, nome);
					bd.st.setInt(2, id);
					int rowsAffected = bd.st.executeUpdate();
					if (rowsAffected > 0) {
							System.out.println("Professor atualizado com sucesso");
					} else {
							System.out.println("Nenhum professor encontrado com o id fornecido");
					}
			} 
			catch (SQLException erro) {
					System.out.println(erro);
					System.out.println("Falha ao atualizar professor");
			} 
			finally {
					bd.close();
			}
			} else {
				System.out.println("Falha ao conectar");
			}
		}

		/**
		 * Atualiza o id de um professor no banco de dados
		 * @param id do professor
		 * @param novoId do professor
		 */
		public void atualizarIdProfessor(int id, int novoId) {
			BD bd = new BD();

			if(bd.getConnection()) {
				String sql = "update prof set id_prof = ? where id_prof = ?";

				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setInt(1, novoId);
					bd.st.setInt(2, id);
					int rowsAffected = bd.st.executeUpdate();
					if (rowsAffected > 0) {
							System.out.println("Id do professor atualizado com sucesso");
					} else {
							System.out.println("Nenhum professor encontrado com o id fornecido");
					}
			} 
			catch (SQLException erro) {
					System.out.println(erro);
					System.out.println("Falha ao atualizar id do professor");
			} 
			finally {
					bd.close(); // Close the connection
			}
			} else {
				System.out.println("Falha ao conectar");
			}
		}
}
