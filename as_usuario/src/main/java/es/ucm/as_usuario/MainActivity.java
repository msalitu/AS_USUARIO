package es.ucm.as_usuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void personalizacion(View v){
        Intent cambiosUsuario = new Intent (getApplicationContext(), Configuracion.class);
        startActivity(cambiosUsuario);
    }

    public void ayuda(View v){
        //Esto debera llevar al pdf con la ayuda
    }

    public void verComoVas(View v){
        //Esto debera llevar al pdf con el informe de actividad
    }

    public void verEventos(View v){
        Intent verEventosUsuario = new Intent (getApplicationContext(), VerEventos.class);
        startActivity(verEventosUsuario);
    }

    public void verReto(View v){
        Intent verRetoUsuario = new Intent (getApplicationContext(), VerReto.class);
        startActivity(verRetoUsuario);
    }

}
