/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exepciones;

/**
 *
 * @author megabit
 */
public class CargarArchivoExption extends Exception {

    /**
     * Creates a new instance of <code>CargarArchivoExption</code> without
     * detail message.
     */
    public CargarArchivoExption() {
    }

    /**
     * Constructs an instance of <code>CargarArchivoExption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CargarArchivoExption(String msg) {
        super(msg);
    }
}
