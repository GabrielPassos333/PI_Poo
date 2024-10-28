package piteste;

import java.sql.SQLException;

import banco.BD;

public class Horario {
  private int id_horario;
  private String horario;
  private String dia;

  public Horario() {
  }

  /**
   * @param id_horario
   * @param horario
   * @param dia
   */
  public Horario(int id_horario, String horario, String dia) {
    this.id_horario = id_horario;
    this.horario = horario;
    this.dia = dia;
  }

  public int getId_horario() {
    return id_horario;
  }

  public void setId_horario(int id_horario) {
    this.id_horario = id_horario;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }

  public String getDia() {
    return dia;
  }

  public void setDia(String dia) {
    this.dia = dia;
  }

  @Override
  public String toString() {
    return "Horario [dia=" + dia + ", horario=" + horario + ", id_horario=" + id_horario + "]";
  }

  public void listarHorarios() {
    BD bd = new BD();
  
    if(bd.getConnection()) {
			String sql = "select * from horario";
			
      try {
        bd.st = bd.con.prepareStatement(sql);
        bd.rs = bd.st.executeQuery();
        
        while(bd.rs.next()) {
          System.out.println("ID: " + bd.rs.getInt("id_horario") + 
          " - Dia: " + bd.rs.getString("dia") + 
          " - Horário: " + bd.rs.getString("horario"));
        }
      } 
      catch (SQLException erro) {
        System.out.println(erro);
      } 
      finally {
        bd.close(); //fecha a conexão
      }
    }
  }
}
