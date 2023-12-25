package com.example.ejemplovideo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bMostrarToast, bMostrarToast2, bMostrarToast3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ***** Ligamos los recursos de la actividad *****
        bMostrarToast = (Button)findViewById(R.id.bMostrarToast);
        bMostrarToast2 = (Button)findViewById(R.id.bMostrarToast2);
        bMostrarToast3 = (Button)findViewById(R.id.bMostrarToast3);
        // ************************************************

        bMostrarToast.setOnClickListener(this);
        bMostrarToast2.setOnClickListener(this);
        bMostrarToast3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.bMostrarToast:
                Toast.makeText(getApplicationContext(),
                        "Toast por defecto", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bMostrarToast2:
                Random aleatorio = new Random();
                Toast t = Toast.makeText(getApplicationContext(),
                        "Toast con gravity", Toast.LENGTH_SHORT);
                switch(aleatorio.nextInt()%4)
                {
                    case 0:
                        t.setGravity(Gravity.CENTER | Gravity.LEFT,0,0);
                        break;
                    case 1:
                        t.setGravity(Gravity.CENTER | Gravity.RIGHT,0,0);
                        break;
                    case 2:
                        t.setGravity(Gravity.CENTER | Gravity.TOP,0,0);
                        break;
                    case 3:
                        t.setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
                        break;
                }
                t.show();
                break;
            case R.id.bMostrarToast3:
                Toast toast3 = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.lytLayout));
                TextView txtMsg = layout.findViewById(R.id.txtMensaje);
                txtMsg.setText(R.string.toast_personalizado);
                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setView(layout);
                toast3.show();
                break;
        }
    }
}