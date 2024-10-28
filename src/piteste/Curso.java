package piteste;

import java.sql.SQLException;

import banco.BD;

public class Curso {

  /**
   * Lista os cursos do banco de dados
   */
  public void listarCursos() {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "select * from curso";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.rs = bd.st.executeQuery(); //mas o ponteiro está a uma posição anterior ao primeiro registro
        while(bd.rs.next()){
          System.out.println("ID: "+bd.rs.getInt("id_curso")+" - "+
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
   * Adiciona um curso no banco de dados
   * @param nome do curso
   */
  public void adicionarCurso(String nome) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "insert into curso (nome) values (?)";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.executeUpdate();
        System.out.println("Curso adicionado com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao adicionar curso");
      } 
      finally {
        bd.close(); //fecha a conexão
      }
    }
  }

  /**
   * Deleta um curso do banco de dados
   * @param id do curso
   */
  public void deletarCurso(int id) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "delete from curso where id_curso = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setInt(1, id);
        bd.st.executeUpdate();
        System.out.println("Curso deletado com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao deletar curso");
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
   * Atualiza um curso do banco de dados
   * @param id do curso
   * @param nome do curso
   */
  public void atualizarCurso(int id, String nome) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "update curso set nome = ? where id_curso = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, id);
        bd.st.executeUpdate();
        System.out.println("Curso atualizado com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao atualizar curso");
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
   * Atualiza um curso do banco de dados
   * @param id do curso
   * @param id_curso novo id do curso
   */
  public void atualizarIdCurso(int id, int id_curso) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "update curso set id_curso = ? where id_curso = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setInt(1, id_curso);
        bd.st.setInt(2, id);
        bd.st.executeUpdate();
        System.out.println("Curso atualizado com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao atualizar curso");
      } 
      finally {
        bd.close(); //fecha a conexão
      }
    }
    else {
      System.out.println("Falha ao conectar");
    }
  }
}
