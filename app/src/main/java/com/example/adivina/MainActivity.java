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


public class MainActivity extends AppCompatActivity {

    //private Random random = new Random();
    public int numeroGerado = NumerosAliatorios.proximoNumero();
    public int tentativas = 0;
    public boolean acertou = false;

    static final String ESTADO_NUMERO_GERADO ="numeroGerado";// constant Caps
    static final String ESTADO_TENTATIVAS ="tentativas";

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt(ESTADO_NUMERO_GERADO, numeroGerado);
        saveInstanceState.putInt(ESTADO_TENTATIVAS, tentativas);

        super.onSaveInstanceState(saveInstanceState);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// para chamar primeiro a superclass primeiro
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            numeroGerado = savedInstanceState.getInt(ESTADO_NUMERO_GERADO);
            tentativas = savedInstanceState.getInt(ESTADO_TENTATIVAS);
        }else{
            numeroGerado = NumerosAliatorios.proximoNumero();
            tentativas = 0;
            acertou = false;
        }

        setTitle("Adivinha "+" by: Leandro Gomes");// alterar o titulo da app
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
        if(Integer.parseInt(valor) < 1 || Integer.parseInt(valor) > 10){
            editTextValor.setError(getString(R.string.intervalo_de_valores));
            editTextValor.requestFocus();
            editTextValor.setText("");
            return;
        }

        int numeroDigitado = Integer.parseInt(valor);
        TextView resultado = findViewById(R.id.textViewResultado);
        if(acertou){
            button.setText(R.string.eviarButton);
            tentativas = 0;
            numeroGerado = NumerosAliatorios.proximoNumero();
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
