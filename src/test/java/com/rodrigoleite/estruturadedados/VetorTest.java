package com.rodrigoleite.estruturadedados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.rodrigoleite.estruturadedados.vetor.Vetor;

public class VetorTest {

    @Test
    void adicionarElemento(){
        Vetor vetor = new Vetor(5);
        vetor.adiciona("Elemento 1");
        assertEquals("Elemento 1", vetor.getElementoPosicao(0));
    }
    
}
