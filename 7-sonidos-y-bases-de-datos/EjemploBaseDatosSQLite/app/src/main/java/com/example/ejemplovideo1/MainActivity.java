package com.example.ejemplovideo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText tCodigo, tNombre;
    private Button bInsertar;
    private BDUsuarios bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligamos los elementos gráficos
        tCodigo = findViewById(R.id.tCodigo);
        tNombre = findViewById(R.id.tNombre);
        bInsertar = findViewById(R.id.bInsertar);

        bd = new BDUsuarios(this);

        bInsertar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.bInsertar:
                int codigo = Integer.valueOf(tCodigo.getText().toString());
                String nombre = tNombre.getText().toString();

                try
                {
                    bd.insertarUsuario(codigo, nombre);
                    Toast.makeText(getApplicationContext(), "Usuario insertado correctamete", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                    System.out.println("Error: " + e.toString());
                }

                break;
        }
    }
}