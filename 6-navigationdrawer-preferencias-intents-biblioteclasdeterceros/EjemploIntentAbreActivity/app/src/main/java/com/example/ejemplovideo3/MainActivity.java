package com.example.ejemplovideo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bNavegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligamos los elementos gráficos
        bNavegar = findViewById(R.id.bNavegar);

        bNavegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.bNavegar:
                //Iniciando la actividad Visor
                Intent intent = new Intent(this, ActividadFinal.class);
                // Agregamos parámetros al intent
                intent.putExtra("datos", "Este dato es de la anterior Activity");
                startActivity(intent);
                break;
        }
    }
}