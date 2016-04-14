package cr.ac.itcr.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cr.ac.itcr.examenkevin.datos.IRepository;
import cr.ac.itcr.examenkevin.datos.MetodosBase;
import cr.ac.itcr.examenkevin.entity.Usuarios;

public class Registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }

    public void guardarDatos(View v){

        EditText user = (EditText) findViewById(R.id.uEditText);
        EditText pass = (EditText) findViewById(R.id.cEditText);

        IRepository repository = new MetodosBase(getApplicationContext());
        Usuarios usuario = new Usuarios();
        usuario.setUser(user.getText().toString());
        usuario.setPass(pass.getText().toString());
        repository.Save(usuario);
        Toast.makeText(getApplicationContext(), "Cuenta creada exitosamante", Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(),MainActivity.class);;
        startActivity(i);



    }

}
