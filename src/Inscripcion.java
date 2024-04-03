import java.util.ArrayList;

public class Inscripcion {
 private ArrayList<Materia> materias;

 private Alumno alumno;

 public Inscripcion(ArrayList<Materia> materias, Alumno alumno) {
  this.materias = materias;
  this.alumno = alumno;
 }

 public  boolean aprobada(){
  return materias.stream().allMatch(materia ->alumno.correlativasAprobadas(materia));

 }
}
