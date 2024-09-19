package com.example.tarea2menus;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Spinner;
import android.widget.TextView;


public class Inicio1Activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio1);
        //Localizar los controles
        TextView txtSaludo = (TextView)findViewById(R.id.TextViewMain);
        //Recuperamos la información pasada en el intent
                Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
                txtSaludo.setText("Hola " + bundle.getString("NOMBRE"));

        final String[] datos =
                new String[]{"Estar mas delgad@ ","Ser mas fuerte ","Salud","Evitar estres","Estetica","Aburrimiento","Otro"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        R.layout.spinner_item, datos);

        Spinner cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
        adaptador.setDropDownViewResource(
                R.layout.spinner_item);
        cmbOpciones.setAdapter(adaptador);

        //Esto ya estaba
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}