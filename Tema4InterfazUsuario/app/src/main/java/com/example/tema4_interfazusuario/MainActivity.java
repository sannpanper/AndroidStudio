package com.example.tema4_interfazusuario;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView miTexto = (TextView) findViewById(R.id.texto);

        miTexto.setText("Nuevo texto a mostrar");

        // Opción 1 para cambiar el color
        miTexto.setTextColor(Color.parseColor("#C08AFF"));

        // Opción 2 para cambiar el color
        // miTexto.setTextColor(Color.RED);

        // Cambiar el texto a negrita
        miTexto.setTypeface(null, Typeface.BOLD);

        // Cambiar el tamaño del texto
        miTexto.setTextSize(20);

        // Cambiar tipo de letra
        miTexto.setTypeface(Typeface.MONOSPACE);
    }
}