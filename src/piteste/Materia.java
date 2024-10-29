package piteste;

import java.sql.SQLException;

import banco.BD;

public class Materia {

  /**
   * Lista as matérias do banco de dados
   */
  public void listarMaterias() {
    BD bd = new BD();

    if(bd.getConnection()) {
      //String sql = "select * from materia";
      String sql = "SELECT materia.id_materia, materia.nome AS materia_nome, " +
             "prof.nome AS professor_nome, curso.nome AS curso_nome " +
             "FROM materia " +
             "JOIN prof ON materia.id_prof = prof.id_prof " +
             "JOIN curso ON materia.id_curso = curso.id_curso";

      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.rs = bd.st.executeQuery(); //mas o ponteiro está a uma posição anterior ao primeiro registro
        while(bd.rs.next()){
          System.out.println("ID: "+bd.rs.getInt("id_materia")+" - "+
              bd.rs.getString("materia_nome")+" - "+
              bd.rs.getString("professor_nome")+" - "+
              bd.rs.getString("curso_nome"));
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
   * Adiciona uma matéria no banco de dados
   * @param nome da matéria
   * @param id do professor
   * @param id do curso
   */
  public void adicionarMateria(String nome, int id_prof, int id_curso) {
    BD bd = new BD();
    
    if(bd.getConnection()) {
      String sql = "insert into materia (nome, id_prof, id_curso) values (?, ?, ?)";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, id_prof);
        bd.st.setInt(3, id_curso);
        bd.st.executeUpdate();
        System.out.println("Matéria adicionada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao adicionar matéria");
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
   * Atualiza uma matéria no banco de dados
   * @param id da matéria
   * @param nome da matéria
   * @param id do professor
   * @param id do curso
   */
  public void atualizarMateria(int id, String nome, int id_prof, int id_curso) {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "update materia set nome = ?, id_prof = ?, id_curso = ? where id_materia = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, id_prof);
        bd.st.setInt(3, id_curso);
        bd.st.setInt(4, id);
        bd.st.executeUpdate();
        System.out.println("Matéria atualizada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao atualizar matéria");
      } 
      finally {
        bd.close(); //fecha a conexão
      }
    }
    else {
      System.out.println("Falha ao conectar");
    }
  }

  
  public void atualizarMateria(int id, String nome, int id_prof, int id_curso, String diaSemana, int semestre) {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "update materia set nome = ?, id_prof = ?, id_curso = ?, dia_semana = ?, semestre = ? where id_materia = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, nome);
        bd.st.setInt(2, id_prof);
        bd.st.setInt(3, id_curso);
        bd.st.setString(4, diaSemana);
        bd.st.setInt(5, semestre);
        bd.st.setInt(6, id);
        bd.st.executeUpdate();
        System.out.println("Matéria atualizada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao atualizar matéria");
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
   * Deleta uma matéria do banco de dados
   * @param id da matéria
   */
  public void deletarMateria(int id) {
    BD bd = new BD();

    if(bd.getConnection()) {
      String sql = "delete from materia where id_materia = ?";
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setInt(1, id);
        bd.st.executeUpdate();
        System.out.println("Matéria deletada com sucesso");
      } 
      catch (SQLException erro) {
        System.out.println(erro);
        System.out.println("Falha ao deletar matéria");
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
