package es.ucm.as.presentacion.controlador.comandos.imp;

import es.ucm.as.negocio.factoria.FactoriaSA;
import es.ucm.as.negocio.suceso.SASuceso;
import es.ucm.as.negocio.suceso.TransferTarea;
import es.ucm.as.presentacion.controlador.comandos.Command;
import es.ucm.as.presentacion.controlador.comandos.exceptions.commandException;

/**
 * Created by Jeffer on 05/03/2016.
 */
public class ActualizarNotificacionTareaComando implements Command {
    @Override
    public Object ejecutaComando(Object datos) throws commandException {
        SASuceso saSuceso= FactoriaSA.getInstancia().nuevoSASuceso();
        saSuceso.actualizarNotificacionTarea((TransferTarea) datos);
        return null;
    }
}
