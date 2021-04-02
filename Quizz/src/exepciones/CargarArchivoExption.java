package exepciones;

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