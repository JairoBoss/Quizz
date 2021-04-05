package guiMaestro;

import model.Pregunta;
import model.Respuesta;

public interface DialogoPreguntasListener {
    public void aceptarButtonClick(Pregunta pregunta, Respuesta uno, Respuesta dos, Respuesta tres, Respuesta cuatro);
    public void cancelarButtonClick();
}
