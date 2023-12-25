package vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplovideo1.R;

import java.util.ArrayList;

import modelo.Pescado;

public class AdaptadorPescado extends RecyclerView.Adapter<AdaptadorPescado.HolderPescado>{

    public static class HolderPescado extends RecyclerView.ViewHolder
    {
        ImageView ivFish;
        TextView textFishName, textPrice, textSize, textType;

        HolderPescado(View itemView)
        {
            super(itemView);
            ivFish = itemView.findViewById(R.id.ivFish);
            textFishName = itemView.findViewById(R.id.textFishName);
            textPrice = itemView.findViewById(R.id.textPrice);
            textSize = itemView.findViewById(R.id.textSize);
            textType = itemView.findViewById(R.id.textType);
        }
    };

    private ArrayList<Pescado> datos;
    private Context contexto;

    public AdaptadorPescado(Context contexto, ArrayList<Pescado> datos)
    {
        this.contexto = contexto;
        this.datos = datos;
    }

    /**
     * Agrega los datos que queramos mostrar
     * @param datos Datos a mostrar
     */
    public void add(ArrayList<HolderPescado> datos)
    {
        datos.clear();
        datos.addAll(datos);
    }

    /**
     * Actualiza los datos del ReciclerView
     */
    public void refrescar()
    {
        notifyDataSetChanged();
    }

    @Override
    public HolderPescado onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_pescado, parent, false);
        HolderPescado pvh = new HolderPescado(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(HolderPescado pescadoactual, int position)
    {
        pescadoactual.ivFish.setImageResource(R.drawable.ic_img_fish);
        pescadoactual.textFishName.setText(datos.get(position).getNombre());
        pescadoactual.textPrice.setText(String.valueOf(datos.get(position).getPrecio()));
        pescadoactual.textSize.setText(datos.get(position).getTamano());
        pescadoactual.textType.setText(datos.get(position).getCategoria());
        pescadoactual.textPrice.setTextColor(ContextCompat.getColor(contexto, R.color.colorAccent));
    }

    @Override
    public int getItemCount()
    {
        return datos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
