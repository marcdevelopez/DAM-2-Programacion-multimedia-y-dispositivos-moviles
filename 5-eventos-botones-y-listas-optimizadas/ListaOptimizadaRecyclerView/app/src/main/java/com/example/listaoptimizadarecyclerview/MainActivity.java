package com.example.listaoptimizadarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaEjemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ligo los elementos gráficos
        listaEjemplo = findViewById(R.id.listaEjemplo);

        // Creamos 20 elemento de la lista
        ArrayList<ElementoLista> elementos = new ArrayList<>();

        for (int i = 1; i <= 20; i++)
        {
            ElementoLista elemento = new ElementoLista("Elem " + i + " - T1", "Elem " + i + " - T2");
            elementos.add(elemento);
        }

        // Con esto el tamaño del recyclerwiew no cambiará
        listaEjemplo.setHasFixedSize(true);
        // Creo un layoutmanager LinearLayoutManager para el recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(this);
        // Creo un layoutmanager GridLayoutManager para el recyclerview
        // LinearLayoutManager llm = new GridLayoutManager(this,3);
        listaEjemplo.setLayoutManager(llm);
        // Creamos el adaptador
        AdaptadorEjemplo adaptador = new AdaptadorEjemplo(this, elementos);
        // Indicamos que el adaptador de la lista en el que hemos creado
        listaEjemplo.setAdapter(adaptador);
        adaptador.refrescar();

    }

}