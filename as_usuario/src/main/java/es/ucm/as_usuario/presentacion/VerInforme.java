package es.ucm.as_usuario.presentacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;

import es.ucm.as_usuario.R;
import es.ucm.as_usuario.integracion.DBHelper;
import es.ucm.as_usuario.negocio.suceso.TransferTarea;
import es.ucm.as_usuario.negocio.usuario.TransferUsuario;
import es.ucm.as_usuario.negocio.usuario.Usuario;
import es.ucm.as_usuario.negocio.utils.Frecuencia;
import es.ucm.as_usuario.presentacion.controlador.Controlador;
import es.ucm.as_usuario.presentacion.controlador.ListaComandos;

/**
 * Clase para que se vean los eventos temporales
 *
 * Created by msalitu on 09/03/2015.
 */
public class VerInforme extends Activity{

    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cargarTema();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informe);

        /*TransferUsuario crearUsuario = new TransferUsuario();
        crearUsuario.setNombre("Jiji");
        crearUsuario.setAvatar("");
        crearUsuario.setPuntuacion(6);
        crearUsuario.setPuntuacionAnterior(4);
        crearUsuario.setFrecuenciaRecibirInforme(Frecuencia.DIARIA);
        Controlador.getInstancia().ejecutaComando(ListaComandos.CREAR_USUARIO, crearUsuario);*/

        TextView titulo = (TextView)findViewById(R.id.tituloInforme);
        titulo.setText("¿CÓMO VAS?");

        Bundle bundle = getIntent().getExtras();

        ImageView img = (ImageView)findViewById(R.id.imageView2);

        Integer puntAntes = bundle.getInt("puntuacion anterior");
        Integer puntAhora = bundle.getInt("puntuacion actual");
        if (puntAhora > puntAntes)
            img.setImageResource(R.drawable.flechaverde);
        else
            img.setImageResource(R.drawable.flecharoja);

        TextView ahora = (TextView)findViewById(R.id.puntuacionAhora);
        ahora.setText(puntAhora.toString());
        TextView antes = (TextView)findViewById(R.id.puntuacionAnterior );
        antes.setText(puntAntes.toString());


        final ListView lista = (ListView) findViewById(R.id.listView);

        ArrayList<String> t = getIntent().getStringArrayListExtra("titulos");
        ArrayList<Integer> s = getIntent().getIntegerArrayListExtra("si");
        ArrayList<Integer> n = getIntent().getIntegerArrayListExtra("no");

        Integer st = s.size();
        if(t.size()!= 0){
            adapter = new ListViewAdapter(t, s, n);
            lista.setAdapter(adapter);
        }
    }

    public void volver(View v){
        Intent pantallaPrincipal = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(pantallaPrincipal);
    }

    public void ayuda(View v){
        Controlador.getInstancia().ejecutaComando(ListaComandos.AYUDA, "informe");
    }

    public void cargarTema(){
        switch (Configuracion.temaActual){
            case "AS_theme_azul":
                setTheme(R.style.AS_tema_azul);
                break;
            case "AS_theme_rojo":
                setTheme(R.style.AS_tema_rojo);
                break;
            case "AS_theme_rosa":
                setTheme(R.style.AS_tema_rosa);
                break;
            case "AS_theme_verde":
                setTheme(R.style.AS_tema_verde);
                break;
            case "AS_theme_negro":
                setTheme(R.style.AS_tema_negro);
                break;
        }
    }
}
