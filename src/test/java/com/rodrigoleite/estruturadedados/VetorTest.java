package com.rodrigoleite.estruturadedados;

import com.rodrigoleite.estruturadedados.vetor.Vetor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VetorTest {


    @Test
    void adicionarElementosQuandoHaEspaco() {
        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        
        boolean resultado = vetor.adiciona("C");

        assertTrue(resultado);
        assertEquals("A", vetor.getElementoPosicao(0));
        assertEquals("B", vetor.getElementoPosicao(1));
        assertEquals("C", vetor.getElementoPosicao(2));

    }

    @Test
    void adicionarElementoComVetorCheio() {

        Vetor vetor = new Vetor(2);
        vetor.adiciona("A");
        vetor.adiciona("B");

        boolean resultado = vetor.adiciona("C");

        assertFalse(resultado);
        assertEquals("A", vetor.getElementoPosicao(0));
        assertEquals("B", vetor.getElementoPosicao(1));
    }

    @Test
    void testarGetElementos(){
         Vetor vetor = new Vetor(5);
         
         String[] vetor2 = vetor.getElementos();
         for (int i = 0; i < vetor.getElementos().length; i++){
            assertEquals(vetor2[i], vetor.getElementoPosicao(i));
         }
    }
    
}
