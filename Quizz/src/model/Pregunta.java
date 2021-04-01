/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Pregunta {
    private String pregunta;
    private ArrayList<Respuesta> respuestas;
    private Integer contador;

    private String materia;



    public Pregunta(String pregunta, String materia) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<Respuesta>();
        this.contador = 0;
        this.materia = materia;
    }

    public String getMateria(){
        return this.materia;
    }

    public void setRespuesta(Respuesta x){
        if (contador < 4) {
            this.respuestas.add(x);
        }
        this.contador++;
    }

    public String getPregunta() {
        return pregunta;
    }
    
    public Boolean valor(int x){
        return this.respuestas.get(x).getCalificacion();        
    }

    @Override
    public String toString() {
        return String.format("%s      "
                + " [0]%s, [1] %s, [2] %s, [3]%s",getPregunta(),this.respuestas.get(0).getRespuesta(),this.respuestas.get(1).getRespuesta(),this.respuestas.get(2).getRespuesta(),this.respuestas.get(3).getRespuesta());
    }

    
    public String respuesta(int x){
        return respuestas.get(x).getRespuesta();
    }

    /*public String[] getRespuestas(){
        String respuestas[] = new String[3];

        return respuestas;
    }*/

    public ArrayList<Respuesta> answers(){
        return this.respuestas;
    }

    public String getCorrecta(){

        String correcta = "";
        for (int i = 0; i < respuestas.size(); i++) {

            if (respuestas.get(i).getCalificacion() == true){
                correcta = respuestas.get(i).getRespuesta();
            }

        }
        return correcta;
    }
    
    
    
    
    
}
