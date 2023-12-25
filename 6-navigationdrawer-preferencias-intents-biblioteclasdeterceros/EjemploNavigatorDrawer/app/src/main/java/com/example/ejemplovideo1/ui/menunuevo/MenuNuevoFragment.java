package com.example.ejemplovideo1.ui.menunuevo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejemplovideo1.R;

public class MenuNuevoFragment extends Fragment implements  View.OnClickListener{

    private TextView tNuevoMensaje;
    private Button bPulsame;

    public static MenuNuevoFragment newInstance() {
        return new MenuNuevoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Obtenemos el layout de la pantalla para buscar los elementos
        View root = inflater.inflate(R.layout.menu_nuevo_fragment, container,
                false);

        // Obtenemos los elementos del fragment
        // IMPORTANTÍSIMO hacer el findViewById desde el root
        tNuevoMensaje = root.findViewById(R.id.tNuevoMensaje);
        bPulsame = root.findViewById(R.id.bPulsame);
        bPulsame.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
// TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bPulsame:
                tNuevoMensaje.setText("Has pulsado el botón");
                break;
        }
    }

}