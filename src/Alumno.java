import java.util.ArrayList;


public class Alumno {
 private String nombre;

 public ArrayList<Materia> getMateriasCursadas() {
  return materiasCursadas;
 }

 public void setMateriasCursadas(ArrayList<Materia> materiasCursadas) {
  this.materiasCursadas = materiasCursadas;
 }

 public Alumno(String nombre) {
  this.nombre = nombre;
 }

 private ArrayList<Materia> materiasCursadas;
 public boolean correlativasAprobadas(Materia materia){
  boolean aprobadas;
  if(materia.getCorrelativas()!=null) {
      aprobadas = materia.getCorrelativas().stream().allMatch(correlativa -> {

          Materia filtered = materiasCursadas.stream().filter(matAux -> matAux.getNombre()==correlativa.getNombre()).
                  findFirst().
                  orElse(null);
          return filtered != null && filtered.estaAprobada();
      });
  } else{
   aprobadas=true;
  }
  return aprobadas;
}
}