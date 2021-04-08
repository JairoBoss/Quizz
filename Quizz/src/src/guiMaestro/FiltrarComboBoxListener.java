package guiMaestro;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

public interface FiltrarComboBoxListener {
    public void btnBuscarButtonClick(String materia) throws ArchivoInvalidoExeption, CargarArchivoExption;
}
