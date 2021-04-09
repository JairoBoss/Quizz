/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.*;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;
import model.Pregunta;

import java.util.ArrayList;
import java.util.Scanner;

import model.Respuesta;

/**
 * @author jairo
 */
public class Controller implements Serializable {

    private ArrayList<Pregunta> quiz;

    public Controller() throws ArchivoInvalidoExeption, CargarArchivoExption {
        cargar();
    }

    public void addPregunta(Pregunta x) {
        this.quiz.add(x);
    }

    public void inciso(int noPregunta, Respuesta respuesta) {
        Pregunta x = quiz.get(noPregunta);
        x.setRespuesta(respuesta);
        this.quiz.set(noPregunta, x);
    }

    public int noPreguntas() {        
        return quiz.size();
    }

    public ArrayList<Pregunta> getPreguntas() {

        return quiz;
    }

    public String respuesta(int noPregunta, int respuesta) {
        return quiz.get(noPregunta).respuesta(respuesta);
    }


    public String[] respuestasString(int indice) {

        String[] respuestas = new String[quiz.get(indice).answers().length];

        for (int i = 0; i < respuestas.length; i++) {

            respuestas[i] = String.valueOf(quiz.get(indice).answers()[i].getRespuesta());
            //System.out.println(respuestas[i]);
        }

        return respuestas;
    }



    public Pregunta getPregunta(int inx) {
        //System.out.println("Pregunta no "+inx);
        Pregunta aux = new Pregunta("","");

        if (inx < noPreguntas()){
            aux = quiz.get(inx);
        }else{
            System.out.println("Fin del examen");
            aux = null;
        }

        //return inx<=noPreguntas() ? quiz.get(inx) : null ;

        return aux;

    }

    public void guardar() throws CargarArchivoExption, ArchivoInvalidoExeption {
        try {
            File file = new File("Guardar.dat");
            FileOutputStream ouput = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(ouput);

            writer.writeObject(quiz);

            writer.close();
            ouput.close();
        } catch (IOException e) {
            throw new ArchivoInvalidoExeption("Hubo un error en disco duro");
        }


    }

    public void cargar() throws CargarArchivoExption, ArchivoInvalidoExeption {
        File file = new File("Guardar.dat");
        if (file.exists()){
            try{
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                quiz = (ArrayList<Pregunta>) reader.readObject();
                //this.quiz = (ArrayList<Pregunta>()) reader.readObject();

                reader.close();
                input.close();
            } catch (IOException e){
                throw new CargarArchivoExption("Error al cargar el archivo");
            } catch (ClassNotFoundException e){
                throw new ArchivoInvalidoExeption("El archivo ah sido corrompido");
                //            alumnos = new ArrayList<>();
            }
        }else{
            quiz = new ArrayList<>();
        }

    }
    
    public String eliminarPregunta(String noPregunta) {
        String x;
        int pregunta = Integer.parseInt(noPregunta)-1 ;
        if ( pregunta >= quiz.size() || pregunta <= 0){
            x = "Esa pregunta no existe :(";
        }else{
            x = String.format("Acabas de eliminar la siguiente pregunta %s" , quiz.get(pregunta ).getPregunta());
            quiz.remove(pregunta);
        }

        return x;
    }

    public ArrayList<Pregunta> filtrar(String materia){
        ArrayList<Pregunta> filtrados = new ArrayList<>();

        for (Pregunta aux : quiz) {
            if (aux.getMateria().equals(materia)){
                filtrados.add(aux);
            }
        }

        for (int i = 0; i < filtrados.size(); i++) {
            System.out.println(filtrados.get(i).getPregunta());
        }

        return filtrados;
    }

    public void cast(ArrayList a){
        this.quiz = a;

    }
}
