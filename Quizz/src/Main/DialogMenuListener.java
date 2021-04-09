package Main;

import exepciones.ArchivoInvalidoExeption;
import exepciones.CargarArchivoExption;

public interface DialogMenuListener {
    public void addPreguntaButtonClick() throws ArchivoInvalidoExeption, CargarArchivoExption;
    public void answerButtonClick();
}
