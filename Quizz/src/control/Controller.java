/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.io.Serializable;
import model.Pregunta;
import java.util.ArrayList;
import java.util.Scanner;
import model.Respuesta;

/**
 *
 * @author jairo
 */
public class Controller implements Serializable{
    
    private ArrayList<Pregunta> quiz;    
    private  Integer correctas;
    private Scanner sc;



    public Controller(){
        sc = new Scanner(System.in);
        this.quiz = new ArrayList<Pregunta>();
        this.correctas = 0;
    }
    
    public void addPregunta(Pregunta x){
        this.quiz.add(x);
    }
    public Integer getCorrectas() {
        return correctas;
    }
    
    public void inciso(int noPregunta, Respuesta respuesta){
        Pregunta x = quiz.get(noPregunta);
        x.setRespuesta(respuesta);
        this.quiz.set(noPregunta, x);
    }
    
    public Integer noPreguntas(){
        return quiz.size();
    }
    
    
    public void contestar(){
        for (int i = 0; i < quiz.size(); i++) {
            Pregunta a = this.quiz.get(i);
            System.out.println(a.toString());
            
            System.out.println("Selecciona el inciso correcto");
            int x = sc.nextInt();
            if (a.valor(x)) {
                System.out.println("nais");
                this.correctas++;
            }else{
                System.out.println("bad");
            }            
            
        }
    }
    
    public Integer correctas(){
        return this.correctas;
    }
    
    public Integer numeroDePreguntas(){
        return this.quiz.size();
    }
    
    public ArrayList<Pregunta> getPreguntas(){

        return quiz;
    }
    
    /*public String getPregunta(int inx){
        return quiz.get(inx).getPregunta();
    }*/
    
    public String respuesta(int noPregunta, int respuesta){
        return quiz.get(noPregunta).respuesta(respuesta);
    }



    public String[] respuestasString(int indice){

        String[] respuestas = new String[quiz.get(indice).answers().size()];

        for (int i = 0; i < respuestas.length; i++) {

            respuestas[i] = String.valueOf(quiz.get(indice).answers().get(i).getRespuesta());
            //System.out.println(respuestas[i]);
        }

        return respuestas;
    }


    public Pregunta getPregunta(int inx){
        return quiz.get(inx);
    }
}
