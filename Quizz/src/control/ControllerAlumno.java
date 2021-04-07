package control;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;

public class ControllerAlumno extends Controller{

    private Integer respuestasCorrectas;
    private Double calificacion;
    private Integer contador;


    public ControllerAlumno() throws ArchivoInvalidoExeption, CargarArchivoExption {
        this.respuestasCorrectas = 0;
        this.contador = 0;
        this.calificacion = 0.0;
    }


    private void setCalificacion(){
        this.calificacion = Double.valueOf(this.respuestasCorrectas/10);
    }

    public Pregunta obtenerPregunta(){
        //Pregunta aux = new Pregunta("Cuanto es 2 + 2","Geo");
        Pregunta aux  = this.getPregunta(contador);
        //aux = this.getPregunta(contador);
        this.contador++;
        return aux;
    }
    //size noPreguntas
}
