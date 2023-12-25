package com.example.ejemplovideo3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActividadFinal extends AppCompatActivity {

    private TextView tDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_final);

        // Configuramos la toolbar
        Toolbar toolbar_actividadfinal = findViewById(R.id.toolbar_actividadfinal);
        setSupportActionBar(toolbar_actividadfinal);
        // Pongo el titulo en la toolbar
        toolbar_actividadfinal.setTitle(getResources().getString(R.string.titulo_actividad_2));
        // Asigno la flecha de atras a la toolbar
        toolbar_actividadfinal.setNavigationIcon(R.drawable.abc_ic_ab_back_material);
        // Hago que cuando se pulse la flecha de atras se cierre la actividad
        toolbar_actividadfinal.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Ligamos los elementos gráficos
        tDatos = findViewById(R.id.tDatos);

        // Obtenemos los datos que se han enviado vía Intent
        Intent intent = getIntent();
        String datos = intent.getStringExtra("datos");
        tDatos.setText(datos);

    }
}