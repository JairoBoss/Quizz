package control;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;

public class ControllerAlumno extends Controller{

    private Integer respuestasCorrectas;
    private Double calificacion;
    private Integer contador;
    private Integer aux;

    public ControllerAlumno() throws ArchivoInvalidoExeption, CargarArchivoExption {
        this.respuestasCorrectas = 0;
        this.contador = 0;
        this.calificacion = 0.0;
        this.aux = 0;
    }


    private void setCalificacion(){
        this.calificacion = Double.valueOf(this.respuestasCorrectas/10);
    }

    public Pregunta obtenerPregunta(){
        Pregunta aux  = this.getPregunta(contador);
        avanzar();
        return contador<=noPreguntas() ? aux : null ;

    }

    private void avanzar(){
        System.out.println("Pidiendo pregunta no "+contador);
        if (aux <= 0){
            aux ++;
            //contador++;
        }else{
            contador++;
        }

    }

    public void Calificacion(int x){
        if (this.getPregunta(contador).valor(x)){
            System.out.println("Good");
        }else{
            System.out.println("Bad");
        }
    }



    public void checar(){

    }




    //size noPreguntas
}
