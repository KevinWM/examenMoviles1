package cr.ac.itcr.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cr.ac.itcr.examenkevin.datos.IRepository;
import cr.ac.itcr.examenkevin.datos.MetodosBaseTortugas;
import cr.ac.itcr.examenkevin.entity.Tortugas;

public class EditarELiminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_eliminar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText nombreTortuga = (EditText) findViewById(R.id.eETxtNom);
        final EditText pesoTortuga = (EditText) findViewById(R.id.eETxtPeso);
        final EditText colorTortuga = (EditText) findViewById(R.id.eETxtColor);
        final EditText razaTortuga = (EditText) findViewById(R.id.eETxtRaza);

        Intent i = getIntent();
        final String nombre = i.getStringExtra("nombre");

        nombreTortuga.setText(i.getStringExtra("nombre").toString());
        pesoTortuga.setText(i.getStringExtra("peso"));
        colorTortuga.setText(i.getStringExtra("color"));
        razaTortuga.setText(i.getStringExtra("raza"));


        Button addButton = (Button)  findViewById(R.id.eEModificar);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tortugas tortuga = new Tortugas();
                tortuga.setNombre(nombre);
                tortuga.setPeso(pesoTortuga.getText().toString());
                tortuga.setColor(colorTortuga.getText().toString());
                tortuga.setRaza(razaTortuga.getText().toString());

                IRepository repository = new MetodosBaseTortugas(getApplicationContext());
                repository.Update(tortuga);
                finish();


            }

        });

        Button deleteButton = (Button)  findViewById(R.id.eELiminar);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tortugas tortuga = new Tortugas();
                tortuga.setNombre(nombreTortuga.getText().toString());
                tortuga.setPeso(pesoTortuga.getText().toString());
                tortuga.setColor(colorTortuga.getText().toString());
                tortuga.setRaza(razaTortuga.getText().toString());

                IRepository repository = new MetodosBaseTortugas(getApplicationContext());
                repository.Delete(tortuga);
                finish();
                Toast.makeText(getApplicationContext(), "Tortuga Eliminada", Toast.LENGTH_LONG).show();




            }

        });



    }

}
