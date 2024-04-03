import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;

class TestControl {
    @DisplayName("dado un alumno que y una materia de la cual tiene aprobadas todas las correlativas se espera true")
    @Test
     void correlativasAprobadas() {

        Materia mate2Apta=new Materia("matematica 2" );
        Alumno alum=new Alumno("carlos");

        Materia correlatAMate=new Materia("matematica 1");
        Materia correlatBMate=new Materia("fisica 1");
        mate2Apta.setCorrelativas(new ArrayList<Materia>( Arrays.asList(correlatAMate,correlatBMate)));

     correlatAMate.setAprobada(true);
     correlatBMate.setAprobada(true);
        alum.setMateriasCursadas(new ArrayList<Materia> (Arrays.asList( correlatAMate,correlatBMate)));

        Assertions.assertTrue(alum.correlativasAprobadas(mate2Apta));

    }
    @DisplayName("dado un alumno que tiene una correlativa sin aprobar de una materia se devuelve false")
    @Test
    void  algunaCorrelativaSinAprobar(){
        Materia disenioNoApta=new Materia("disenio 3" );
        Alumno alumNoCumpleCorrelativas=new Alumno("carlos");

        Materia correlatADisenio=new Materia("disenio 2");
        Materia correlatBDisenio=new Materia("disenio 1");

        disenioNoApta.setCorrelativas(new ArrayList<Materia>( Arrays.asList(correlatADisenio,correlatBDisenio)));
        correlatBDisenio.setAprobada(true);
        alumNoCumpleCorrelativas.setMateriasCursadas(new ArrayList<Materia>( Arrays.asList(correlatADisenio,correlatBDisenio)));
        Assertions.assertFalse(alumNoCumpleCorrelativas.correlativasAprobadas(disenioNoApta));
    }
    @DisplayName("para una materia sin correlativas se espera true sin importar las materias aprobadas del alumno")
    @Test
    void sinCorrelativas(){
        Materia moduloB=new Materia("modulo B" );
        Alumno tom=new Alumno("carlos");

        Assertions.assertTrue(tom.correlativasAprobadas(moduloB));
    }


    @DisplayName("una inscripcion es aprobada si todas las materias a inscribirse tienen sus correlativas aprobadas")
    @Test
    void inscripcionAprobada(){
        Materia inscripDisenio3=new Materia("disenio 3" );
        Materia correlADisenio3=new Materia("disenio 2");
        Materia correlBDisenio3=new Materia("disenio 1");
        Materia inscripMate2=new Materia("matematica 2" );
        Materia correlAMate2=new Materia("matematica 1");
        Alumno unAlumno=new Alumno("carlos");



        inscripDisenio3.setCorrelativas(new ArrayList<Materia>(Arrays.asList(correlADisenio3,correlBDisenio3)));
        inscripMate2.setCorrelativas(new ArrayList<Materia>(Arrays.asList(correlAMate2)));

        ArrayList<Materia> listaMaterias=new ArrayList<>(Arrays.asList(inscripDisenio3,inscripMate2));

        correlADisenio3.setAprobada(true);
        correlBDisenio3.setAprobada(true);
        correlAMate2.setAprobada(true);

        unAlumno.setMateriasCursadas(new ArrayList<Materia>(Arrays.asList(correlADisenio3,correlBDisenio3,correlAMate2)));


        Inscripcion inscripcionOk=new Inscripcion(listaMaterias,unAlumno);
        Assertions.assertTrue(inscripcionOk.aprobada());

    }
    @DisplayName("una inscripcion No es aprobada si alguna de las materias tiene una correlativa sin aprobar")
    @Test
    void inscripcionNoAprobada(){
        Materia inscripDisenio3=new Materia("disenio 3" );
        Materia correlADisenio3=new Materia("disenio 2");
        Materia correlBDisenio3=new Materia("disenio 1");
        Materia inscripMate2=new Materia("matematica 2" );
        Materia correlAMate2=new Materia("matematica 1");
        Alumno unAlumno=new Alumno("carlos");



        inscripDisenio3.setCorrelativas(new ArrayList<Materia>(Arrays.asList(correlADisenio3,correlBDisenio3)));
        inscripMate2.setCorrelativas(new ArrayList<Materia>(Arrays.asList(correlAMate2)));

        ArrayList<Materia> listaMaterias=new ArrayList<>(Arrays.asList(inscripDisenio3,inscripMate2));

        correlADisenio3.setAprobada(true);
        correlBDisenio3.setAprobada(true);
        correlAMate2.setAprobada(false);

        unAlumno.setMateriasCursadas(new ArrayList<Materia>(Arrays.asList(correlADisenio3,correlBDisenio3,correlAMate2)));


        Inscripcion inscripcionRechazada=new Inscripcion(listaMaterias,unAlumno);
        Assertions.assertFalse(inscripcionRechazada.aprobada());

    }
}

