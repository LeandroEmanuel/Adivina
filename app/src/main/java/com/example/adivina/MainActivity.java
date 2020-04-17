package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    public int numeroGerado = random.nextInt(10)+1;
    public int tentativas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toast.makeText(this,"numero\n"+ numeroGerado,Toast.LENGTH_SHORT).show();
    }

    public void tentativa(View view) {

        EditText editTextValor = (EditText) findViewById(R.id.valorAdivinha);
        String valor = editTextValor.getText().toString();
        int numeroDigitado = Integer.parseInt(valor);
        TextView resultado = findViewById(R.id.textViewResultado);
        tentativas++;
        if(numeroDigitado != numeroGerado){// compara o numero digitado com o geradpo*/
            resultado.setText("Acertou  depois de:\n"+tentativas+" tentativas");
        } else{
            resultado.setText(getString(R.string.Resultado)+ "\t"+ tentativas);
        }

        /*if(valor.length() == 0){
            editTextValor.setError(editTextValor.getHint());
            editTextValor.requestFocus();
            return;
        }*/
        /*if(Integer.parseInt(valor)<0 || Integer.parseInt(valor)>10){
            editTextValor.setError("\n Apenas numeros entre 1 e 10");
            editTextValor.requestFocus();
            editTextValor.setText("");
            return;
        }*/
    }
}
