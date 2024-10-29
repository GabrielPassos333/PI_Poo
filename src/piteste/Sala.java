package piteste;

import java.sql.SQLException;
import banco.BD;

public class Sala {

  /**
   * Lista as salas do banco de dados
   */
  public void listarSalas() {
    BD bd = new BD();

    if(bd.getConnection()) {
			String sql = "select * from sala";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery(); //mas o ponteiro está a uma posição anterior ao primeiro registro
				while(bd.rs.next()){
					System.out.println("ID: "+bd.rs.getInt("id_sala")+" - "+
							bd.rs.getString("nome")+" Lugares: "+
              bd.rs.getInt("lugares"));
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
   * Adiciona uma sala no banco de dados
   * @param nome da sala
   * @param lugares da sala
   */
  public void adicionarSala(String nome, int lugares) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "insert into sala (nome, lugares) values (?, ?)";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, lugares);
        bd.st.executeUpdate();
        System.out.println("Sala adicionada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao adicionar sala");
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
   * Deleta uma sala do banco de dados
   * @param id da sala
   */
  public void deletarSala(int id) {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "delete from sala where id_sala = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setInt(1, id);
        bd.st.executeUpdate();
        System.out.println("Sala deletada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao deletar sala");
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
   * Atualiza uma sala no banco de dados
   * @param id da sala
   * @param nome da sala
   * @param lugares da sala
   */
  public void atualizarSala(int id, String nome, int lugares) {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "update sala set nome = ?, lugares = ? where id_sala = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, lugares);
        bd.st.setInt(3, id);
        bd.st.executeUpdate();
        System.out.println("Sala atualizada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao atualizar sala");
      } 
      finally {
        bd.close();
      }
    }
    else {
      System.out.println("Falha ao conectar");
    }
  }
}