package com.example.adivina;

import java.util.Random;

public class NumerosAliatorios {

    private static Random random = new Random();
    /**
     *
     * @return Devolve um numero entre um e 10
     */

    public static int proximoNumero(){
        int n;
            n = random.nextInt(10) + 1;
        return n;
    }
}
