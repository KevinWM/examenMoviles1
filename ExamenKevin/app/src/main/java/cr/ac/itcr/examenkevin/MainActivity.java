package cr.ac.itcr.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import cr.ac.itcr.examenkevin.datos.IRepository;
import cr.ac.itcr.examenkevin.datos.MetodosBase;
import cr.ac.itcr.examenkevin.entity.Usuarios;

public class MainActivity extends AppCompatActivity {



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

    public void levantarActivityRegistrarse(View v){
        Intent i = new Intent(getApplicationContext(),Registrarse.class);;
        startActivity(i);
    }


    public void loguearse(View v){
        EditText user = (EditText) findViewById(R.id.userText);
        EditText pass = (EditText) findViewById(R.id.passText);

        IRepository repository = new MetodosBase(getApplicationContext());
        ArrayList<Usuarios> usuarios = repository.GetAll();

        for(int i=0; i<usuarios.size(); i++){
            if((usuarios.get(i).getUser().equals(user.getText().toString())) &&
                    (usuarios.get(i).getPass().equals(pass.getText().toString()))){

                Toast.makeText(getApplicationContext(), "Bienvenido " + user.getText(), Toast.LENGTH_LONG).show();
                Intent in = new Intent(getApplicationContext(),DashBoardActivity.class);;
                startActivity(in);
                return;
            }
        }
        Toast.makeText(getApplicationContext(), "Usuario y contraseña invalidos ", Toast.LENGTH_LONG).show();
    }


}
