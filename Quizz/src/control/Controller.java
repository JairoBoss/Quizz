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
    private Integer correctas;
    private Scanner sc;


    public Controller() throws ArchivoInvalidoExeption, CargarArchivoExption {
        cargar();
        sc = new Scanner(System.in);

        this.correctas = 0;
    }

    public void addPregunta(Pregunta x) {
        this.quiz.add(x);
    }

    public Integer getCorrectas() {
        return correctas;
    }

    public void inciso(int noPregunta, Respuesta respuesta) {
        Pregunta x = quiz.get(noPregunta);
        x.setRespuesta(respuesta);
        this.quiz.set(noPregunta, x);
    }

    public int noPreguntas() {        
        return quiz.size();
    }


    public void contestar() {
        for (int i = 0; i < quiz.size(); i++) {
            Pregunta a = this.quiz.get(i);
            System.out.println(a.toString());

            System.out.println("Selecciona el inciso correcto");
            int x = sc.nextInt();
            if (a.valor(x)) {
                System.out.println("nais");
                this.correctas++;
            } else {
                System.out.println("bad");
            }

        }
    }

    public Integer correctas() {
        return this.correctas;
    }

    public Integer numeroDePreguntas() {
        return this.quiz.size();
    }

    public ArrayList<Pregunta> getPreguntas() {

        return quiz;
    }
    
    /*public String getPregunta(int inx){
        return quiz.get(inx).getPregunta();
    }*/

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
        return quiz.get(inx);
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

    public void filtrar(String Materia) {

        //   a
    }

    public String eliminarPregunta(String noPregunta) {
        String x;
        int pregunta = Integer.parseInt(noPregunta)-1 ;
        if ( pregunta <= quiz.size()){
            x = String.format("Vas a eliminar la siguiente pregunta %s" , quiz.get(pregunta ).getPregunta());
            quiz.remove(pregunta);
        }else{
            x = "Esa pregunta no existe :(";
        }

        return x;
    }
    private Boolean validar(String numero){
        Boolean resultado;

        try {
            Integer.parseInt(numero);
            resultado = true;
        }catch (NumberFormatException ex){
            resultado = false;
        }
        return resultado;
    }
}
