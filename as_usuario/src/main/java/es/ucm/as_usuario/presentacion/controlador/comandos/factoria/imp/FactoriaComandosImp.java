package es.ucm.as_usuario.presentacion.controlador.comandos.factoria.imp;

import es.ucm.as_usuario.presentacion.controlador.ListaComandos;
import es.ucm.as_usuario.presentacion.controlador.comandos.Command;
import es.ucm.as_usuario.presentacion.controlador.comandos.factoria.FactoriaComandos;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.ActualizaPuntuacionComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.CrearUsuarioComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.ResponderRetoComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.VerAyudaComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.VerEventosComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.VerInformeComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.VerRetoComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.ConfiguracionComando;
import es.ucm.as_usuario.presentacion.controlador.comandos.imp.EditarUsuarioComando;

/**
 * Created by Jeffer on 02/03/2016.
 */
public class FactoriaComandosImp extends FactoriaComandos {
    @Override
    public Command getCommand(String comando) {
        Command ret = null;
        switch(comando){
            case ListaComandos.RESPONDER_RETO:
                ret = new ResponderRetoComando();
            break;
            case ListaComandos.VER_RETO:
                ret = new VerRetoComando();
                break;
            case ListaComandos.VER_EVENTOS:
                ret= new VerEventosComando();
            break;
            case ListaComandos.CONFIGURACION:
                ret= new ConfiguracionComando();
            break;
            case ListaComandos.EDITAR_USUARIO:
                ret= new EditarUsuarioComando();
            break;
            case ListaComandos.AYUDA:
                ret = new VerAyudaComando();
                break;
            case ListaComandos.VER_INFORME:
                ret = new VerInformeComando();
                break;
            case ListaComandos.ACTUALIZAR_PUNTUACION:
                ret = new ActualizaPuntuacionComando();
                break;
            case ListaComandos.CREAR_USUARIO:
                ret = new CrearUsuarioComando();
                break;
        }

        return ret;
    }
}
