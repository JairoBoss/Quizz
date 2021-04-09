package control;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;

public class ControllerAlumno extends Controller {

    private Integer respuestasCorrectas;
    private Double calificacion;
    private Integer contador;

    public ControllerAlumno() throws ArchivoInvalidoExeption, CargarArchivoExption {
        this.respuestasCorrectas = 0;
        this.contador = 0;
        this.calificacion = 0.0;
    }


    public Pregunta obtenerPregunta() {
        Pregunta aux = this.getPregunta(this.contador);
        this.contador++;
        //return aux;

        return contador <= noPreguntas() ? aux : null;
    }

    public Integer getRespuestasCorrectas(){
        return this.respuestasCorrectas;
    }


    public Double getCalificacion() {

        this.calificacion = ((double) this.respuestasCorrectas / noPreguntas()) * 100;
        return this.calificacion;

    }


    private Integer preguntasContador = 0;

    public void checar(int x) {
        if (x != -1) {
            if (getPregunta(preguntasContador).valor(x)) {
                this.respuestasCorrectas++;
            }
        }


        preguntasContador++;
    }

    public void Calificacion(int x) {
        System.out.println(this.getPregunta(contador).valor(x));
    }


    public void checar() {

    }


    //size noPreguntas
}
