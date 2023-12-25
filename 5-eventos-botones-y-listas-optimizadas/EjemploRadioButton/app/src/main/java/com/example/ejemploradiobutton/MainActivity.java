package com.example.ejemploradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaramos los objetos gráficos:
    private RadioGroup rgGrupo;
    private RadioButton rb1;
    private RadioButton rb2;
    private CheckBox chb1;
    private CheckBox chb2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // enlazamos objetos gráfico al código
        chb1 = findViewById(R.id.checkBox1);
        chb2 = findViewById(R.id.checkBox2);

        rgGrupo = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);


        // damos funcionalidad a los RadioButtons:
        rgGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getId()) {
                    case R.id.radioGroup:
                        switch (checkedId) {
                            case R.id.radioButton1:
                                System.out.println("Has marcado el radiobutton 1");
                                break;
                            case R.id.radioButton2:
                                System.out.println("Has marcado el radiobutton 2");
                                break;
                        }
                }
            }
        });

    }

    /**
     *  Damos funcionalidad a los CheckBoxs:
     *  Esta vez usamos el método que enlazamos en el archivo xml del activity_main, asociado a los
     *  checkboxs
     */

    public void onClickCheckBox(View v) {
        switch (v.getId()) {
            case R.id.checkBox1:
                System.out.println("Has marcado el checkbox 1");
                break;
            case R.id.checkBox2:
                System.out.println("Has marcado el checkbox 2");
                break;
        }
    }

}