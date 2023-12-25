package com.example.listaoptimizadarecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * RecyclerView.Adapter: Representa un adaptador que gestionará cómo se mostrarán los elementos en
 * pantalla.
 */
public class AdaptadorEjemplo extends RecyclerView.Adapter<AdaptadorEjemplo.HolderEjemplo> {

    /**
     * Clase interna equivalente al Holder de los elementos.
     * RecyclerView.ViewHolder: Esta clase se encargará de la gestión de la memoria del dispositivo
     * a la hora de mostrar la lista optimizada. Nosotros únicamente le tendremos que indicar qué
     * elementos habrá.
     */
    public static class HolderEjemplo extends RecyclerView.ViewHolder {
        TextView tEjemplo1, tEjemplo2;

        HolderEjemplo(View itemView) {
            /*
                En el constructor obtendremos los recursos del fichero
                de recursos xml que tengamos asociado a la clase, en
                este caso el fichero elemento.xml
            */
            super(itemView);
            tEjemplo1 = itemView.findViewById(R.id.tEjemplo1);
            tEjemplo2 = itemView.findViewById(R.id.tEjemplo2);
            // Si hubiera que sobrecargar eventos se haria aqui
        }
    }

    ;

    // Atributos de la clase AdaptadorEjemplo
    private ArrayList<ElementoLista> elementos;
    private Context contexto;

    /**
     * Constructor de la clase
     *
     * @param contexto  Contexto de la aplicación
     * @param elementos Elementos de la lista
     */
    public AdaptadorEjemplo(Context contexto, ArrayList<ElementoLista> elementos) {
        this.contexto = contexto;
        this.elementos = elementos;
    }

    /**
     * Agrega los datos que queramos mostrar
     *
     * @param datos Datos a mostrar, en este caso, los elementos básicos de la lista
     */
    public void add(ArrayList<ElementoLista> datos) {
        elementos.clear();
        elementos.addAll(datos);
    }

    /**
     * Actualiza los datos del ReciclerView
     */
    public void refrescar() {
        notifyDataSetChanged();
    }

    @Override
    /**
     * Este método irá creando uno a uno los elementos de la lista optimizando el uso de memoria del
     * dispositivo
     */
    public HolderEjemplo onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento, parent,
                false);
        HolderEjemplo pvh = new HolderEjemplo(v);
        return pvh;
    }

    @Override
    /**
     * Este método mostrará los datos de cada elemento que esté visible en la lista
     */
    public void onBindViewHolder(HolderEjemplo elementoactual, int position) {
        // Ponemos los datos correspondientes al titular de posicion position
        elementoactual.tEjemplo1.setText(elementos.get(position).getTexto1());
        elementoactual.tEjemplo2.setText(elementos.get(position).getTexto2());
    }

    @Override
    /**
     * Este método devolverá la cantidad de elementos que hay en la lista
     */
    public int getItemCount() {
        return elementos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}