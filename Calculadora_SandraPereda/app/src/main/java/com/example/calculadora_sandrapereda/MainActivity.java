package com.example.calculadora_sandrapereda;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView pantalla;
    TextView operacionTexto;
    double num1, num2;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.pantalla);
        operacionTexto = findViewById(R.id.operacionTexto);

        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);
        Button b0 = findViewById(R.id.b0);

        Button division = findViewById(R.id.division);
        Button multiplicacion = findViewById(R.id.multiplicacion);
        Button resta = findViewById(R.id.resta);
        Button suma = findViewById(R.id.suma);
        Button coma = findViewById(R.id.coma);
        Button igual = findViewById(R.id.igual);
        Button borra = findViewById(R.id.borra);
        Button reset = findViewById(R.id.reset);

        b1.setOnClickListener(v -> escribir("1"));
        b2.setOnClickListener(v -> escribir("2"));
        b3.setOnClickListener(v -> escribir("3"));
        b4.setOnClickListener(v -> escribir("4"));
        b5.setOnClickListener(v -> escribir("5"));
        b6.setOnClickListener(v -> escribir("6"));
        b7.setOnClickListener(v -> escribir("7"));
        b8.setOnClickListener(v -> escribir("8"));
        b9.setOnClickListener(v -> escribir("9"));
        b0.setOnClickListener(v -> escribir("0"));

        coma.setOnClickListener(v -> {
            if (!pantalla.getText().toString().contains(",")) {
                pantalla.append(",");
            }
        });

        suma.setOnClickListener(v -> guardarOperacion("+"));
        resta.setOnClickListener(v -> guardarOperacion("-"));
        multiplicacion.setOnClickListener(v -> guardarOperacion("*"));
        division.setOnClickListener(v -> guardarOperacion("/"));

        igual.setOnClickListener(v -> calcular());

        borra.setOnClickListener(v -> {
            String texto = pantalla.getText().toString();

            if (texto.length() > 1) {
                pantalla.setText(texto.substring(0, texto.length() - 1));
            } else {
                pantalla.setText("0");
            }
        });

        reset.setOnClickListener(v -> {
            pantalla.setText("0");
            num1 = 0;
            num2 = 0;
            operacion = "";
        });
    }

    public void escribir(String numero) {
        String texto = pantalla.getText().toString();

        if (texto.equals("0") || texto.equals("Error")) {
            pantalla.setText(numero);
        } else {
            pantalla.append(numero);
        }
    }

    public void guardarOperacion(String op) {
        num1 = Double.parseDouble(
                pantalla.getText().toString().replace(",", ".")
        );

        operacion = op;

        operacionTexto.setText(pantalla.getText().toString() + " " + op);
        pantalla.setText("0");
    }

    public void calcular() {
        if (operacion.isEmpty()) {
            return;
        }

        num2 = Double.parseDouble(
                pantalla.getText().toString().replace(",", ".")
        );

        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    pantalla.setText("Error");
                    operacion = "";
                    return;
                }
                resultado = num1 / num2;
                break;
        }

        pantalla.setText(String.valueOf(resultado).replace(".", ","));
        operacion = "";
        operacionTexto.setText("");
    }
}
