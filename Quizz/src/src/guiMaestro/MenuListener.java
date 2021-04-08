package guiMaestro;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

public interface MenuListener {
    public void nuevaPreguntaButtonClick();
    public void guardarButtonClick() throws ArchivoInvalidoExeption, CargarArchivoExption;
    public void eliminarButtonClick();
    public void salirButtonClick();
    public void acercaDeButtonClick();
}
