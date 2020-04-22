package com.example.adivina;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NumerosAleatoriosUnitTest {
    @Test
    public void numerosAleatoriosFuncionaCorretamente() {
        for (int i = 0; i < 1000000; i++){
            int n = NumerosAliatorios.proximoNumero();
            assertTrue(n >=1 && n <= 10);
        }
    }
}