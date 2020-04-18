package com.example.adivina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    public int numeroGerado;
    public int tentativas = 0;
    public boolean acertou = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //  Toast.makeText(this,"numero\n"+ numeroGerado,Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void tentativa(View view) {

        EditText editTextValor = (EditText) findViewById(R.id.valorAdivinha);
        String valor = editTextValor.getText().toString();
        Button button = (Button)findViewById(R.id.buttonSend);

        if(valor.length() == 0){
            editTextValor.setError(editTextValor.getHint());
            editTextValor.requestFocus();
            return;
        }
        if(Integer.parseInt(valor)<0 || Integer.parseInt(valor)>10){
            editTextValor.setError(getString(R.string.intervalo_de_valores));
            editTextValor.requestFocus();
            editTextValor.setText("");
            return;
        }

        int numeroDigitado = Integer.parseInt(valor);
        TextView resultado = findViewById(R.id.textViewResultado);

        if(acertou){
            button.setText(R.string.eviarButton);
            numeroGerado = random.nextInt(10)+1;
            tentativas = 0;
            resultado.setText(getString(R.string.resultado)+"\t"+tentativas+getString(R.string.tentativas));
            acertou = false;

        } else{
            tentativas++;
            if(numeroDigitado == numeroGerado){// compara o numero digitado com o geradpo
                resultado.setText(getString(R.string.acertou_depois_de)+tentativas+getString(R.string.tentativas));
                button.setText(R.string.recomeçar);
                acertou = true;

                /*if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setNavigationBarColor(Color.GREEN); // fundo
                    getWindow().setStatusBarColor(Color.CYAN); // topo
                    getWindow().setNavigationBarDividerColor(Color.GRAY);
                }*/

            } else{
                resultado.setText(getString(R.string.resultado)+"\t"+tentativas+getString(R.string.tentativas));
            }
        }
    }
}
