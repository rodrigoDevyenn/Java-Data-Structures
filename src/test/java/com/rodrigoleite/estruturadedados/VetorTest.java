package com.rodrigoleite.estruturadedados;

import com.rodrigoleite.estruturadedados.vetor.Vetor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VetorTest {

    @Test
    void adicionarElemento(){
        Vetor vetor = new Vetor(5);
        for (int i = 0; i < vetor.getElementos().length; i++){
            vetor.adiciona(("Elemento " + (i + 1)));
        }
        assertEquals("Elemento 1", vetor.getElementoPosicao(0));
    }

    @Test
    void adicionarElementoComVetorCheio(){
        Vetor vetor = new Vetor(5);
        for (int i = 0; i < vetor.getElementos().length; i++){
            vetor.adiciona(("Elemento " + (i + 1)));
        }
        vetor.adiciona("Elemento 6");
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
