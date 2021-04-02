package exepciones;

public class ArchivoInvalidoExeption extends Exception {

    /**
     * Creates a new instance of <code>ArchivoInvalidoExeption</code> without
     * detail message.
     */
    public ArchivoInvalidoExeption() {
    }

    /**
     * Constructs an instance of <code>ArchivoInvalidoExeption</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArchivoInvalidoExeption(String msg) throws ArchivoInvalidoExeption, CargarArchivoExption {
        super(msg);

    }
}