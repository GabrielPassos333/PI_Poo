package piteste;

public class TestandoTrens {
  public static void main(String[] args) {

  Professor p = new Professor();
  Sala s = new piteste.Sala();
  Curso c = new piteste.Curso();
  Materia m = new piteste.Materia();
  Horario h = new piteste.Horario();

  //s.adicionarSala("Lab 13", 50);
  //s.deletarSala(5);
  //s.atualizarSala(4, "Sala 103", 666);
  //s.listarSalas();
  
  System.out.println("-----------------------------------------------");
  //p.adicionarProfessor("Daniele Canhedos");
  //p.deletarProfessor(10);
  //p.atualizarProfessor(4, "Claus");
  //p.atualizarIdProfessor(11,5 );
  p.listarProfessores();

  System.out.println("-----------------------------------------------");
  //c.adicionarCurso("-");
  //c.atualizarCurso(1, "ADS");
  //c.deletarCurso(3);
  //c.atualizarIdCurso(4, 3);
  c.listarCursos();

  System.out.println("-----------------------------------------------");
  //m.adicionarMateria("POO", 1, 3);
  //m.atualizarMateria(1,"Matematica Discreta", 1, 1);
  //m.deletarMateria(5);
  m.listarMaterias();

  System.out.println("-----------------------------------------------");
  
  h.listarHorarios();

  }

}
