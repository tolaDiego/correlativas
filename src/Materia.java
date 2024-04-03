import java.util.ArrayList;

public class Materia {
    public String getNombre() {
        return nombre;
    }

    public Materia(String nombre) {
        this.nombre = nombre;
        aprobada=false;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public ArrayList<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    private  ArrayList <Materia> correlativas;

    public boolean estaAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    private boolean aprobada;
}
