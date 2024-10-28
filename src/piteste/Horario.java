package piteste;

import java.sql.SQLException;
import banco.BD;

public class Horario {
  private int id_horario;
  private String dia_semana;
  private int semestre;
  private int id_sala;
  private int id_materia;
  private int id_prof;

  public Horario() {
  }

  public Horario(int id_horario, String dia_semana, int semestre, int id_sala, int id_materia, int id_prof) {
    this.id_horario = id_horario;
    this.dia_semana = dia_semana;
    this.semestre = semestre;
    this.id_sala = id_sala;
    this.id_materia = id_materia;
    this.id_prof = id_prof;
  }

  public int getId_horario() {
    return id_horario;
  }

  public void setId_horario(int id_horario) {
    this.id_horario = id_horario;
  }

  public String getDia_semana() {
    return dia_semana;
  }

  public void setDia_semana(String dia_semana) {
    this.dia_semana = dia_semana;
  }

  public int getSemestre() {
    return semestre;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }

  public int getId_sala() {
    return id_sala;
  }

  public void setId_sala(int id_sala) {
    this.id_sala = id_sala;
  }

  public int getId_materia() {
    return id_materia;
  }

  public void setId_materia(int id_materia) {
    this.id_materia = id_materia;
  }

  public int getId_prof() {
    return id_prof;
  }

  public void setId_prof(int id_prof) {
    this.id_prof = id_prof;
  }

  @Override
  public String toString() {
    return "Horario [id_horario=" + id_horario + ", dia_semana=" + dia_semana + ", semestre=" + semestre + 
           ", id_sala=" + id_sala + ", id_materia=" + id_materia + ", id_prof=" + id_prof + "]";
  }

  public void listarHorarios() {
    BD bd = new BD();

    if (bd.getConnection()) {
      String sql = "select * from horario";

      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.rs = bd.st.executeQuery();

        while (bd.rs.next()) {
          System.out.println("ID: " + bd.rs.getInt("id_horario") + 
                             " - Dia: " + bd.rs.getString("dia_semana") + 
                             " - Semestre: " + bd.rs.getInt("semestre") + 
                             " - Sala ID: " + bd.rs.getInt("id_sala") + 
                             " - Materia ID: " + bd.rs.getInt("id_materia") + 
                             " - Professor ID: " + bd.rs.getInt("id_prof"));
        }
      } catch (SQLException erro) {
        System.out.println(erro);
      } finally {
        bd.close(); // fecha a conexão
      }
    }
  }

  public void adicionarHorario(String dia_semana, int semestre, int id_sala, int id_materia, int id_prof) {
    BD bd = new BD();

    if (bd.getConnection()) {
      String sql = "insert into horario (dia_semana, semestre, id_sala, id_materia, id_prof) values (?, ?, ?, ?, ?)";

      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.st.setString(1, dia_semana);
        bd.st.setInt(2, semestre);
        bd.st.setInt(3, id_sala);
        bd.st.setInt(4, id_materia);
        bd.st.setInt(5, id_prof);
        bd.st.executeUpdate();
        System.out.println("Horario adicionado com sucesso!");
      } catch (SQLException erro) {
        System.out.println(erro);
      } finally {
        bd.close(); // fecha a conexão
      }
    }
  }
}
