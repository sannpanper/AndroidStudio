package com.example.tema4_interfazusuario;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private Animation miAnimacion;
    private Button boton1, boton2, boton3;
    private  TextView miTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);
        boton3 = findViewById(R.id.boton3);
        miTexto = findViewById(R.id.texto);

    }


    protected void onStart(){
        super.onStart();

        miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miAnimacion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion);
                //aqui configuramos la animacion
                miAnimacion.setRepeatMode(Animation.RESTART);
                miAnimacion.setRepeatCount(20);
                //Por ultimo se aplica la animacion al texto
                miTexto.startAnimation(miAnimacion);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miAnimacion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotar);
                miTexto.startAnimation(miAnimacion);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(miAnimacion != null){

                    miTexto.clearAnimation();
                    miAnimacion.cancel();
                    miAnimacion = null;
                }


            }
        });

        miTexto.setText("Nuevo texto a mostrar");
        //Opcion1 para cambiar el color
        miTexto.setTextColor(Color.RED);
        //
        miTexto.setTypeface(null, Typeface.BOLD);
        //cambio el tamaño del texto
        miTexto.setTextSize(24);
        //cambiar tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);





    }


}