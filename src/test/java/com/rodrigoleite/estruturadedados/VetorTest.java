package com.rodrigoleite.estruturadedados;

import com.rodrigoleite.estruturadedados.vetor.Vetor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2));

    }

    @Test
    void adicionarElementoComVetorCheio() {

        Vetor vetor = new Vetor(2);
        vetor.adiciona("A");
        vetor.adiciona("B");

        boolean resultado = vetor.adiciona("C");

        assertFalse(resultado);
        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
    }

    @Test
    void verificarTamanhoDoVetor(){

        Vetor vetor = new Vetor(10);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(3, vetor.getTamanho());

    }

    @Test
    void verificarImpressaoDoVetor(){

        Vetor vetor  = new Vetor(10);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("[A, B, C]", vetor.toString());

    }

    @Test
    void fazerBuscaValida() {

        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2)); 
    }

    @Test
    void fazerBuscaInvalidaComIndiceNegativo() {

        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.buscaPorIndice(-1);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
    
    @Test
    void fazerBuscaInvalidaComIndiceMaiorQueTamanho() {

        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.buscaPorIndice(3);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
    
    @Test
    void fazerBuscaPorElementoQueExiste(){
        
        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(0, vetor.buscaPorElemento("A"));
        assertEquals(1, vetor.buscaPorElemento("B"));
        assertEquals(2, vetor.buscaPorElemento("C"));
    }

    @Test
    void fazerBuscaPorElementoQueNaoExiste(){
        
        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(-1, vetor.buscaPorElemento("D"));
    }

    @Test
    void fazerBuscaPorElementoQueExisteComCaseDiferente(){
        
        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(-1, vetor.buscaPorElemento("a"));
        assertEquals(-1, vetor.buscaPorElemento("b"));
    }

    @Test
    void adicionarElementoNaPosicaoDesejada(){

        Vetor vetor = new Vetor(10);
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        vetor.adiciona("A", 0);
        vetor.adiciona("D", 3);

        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("D", vetor.buscaPorIndice(3));
        assertEquals("G", vetor.buscaPorIndice(6));
    }

    @Test
    void adicionarElementoNaPosicaoNegativa(){

        Vetor vetor = new Vetor(10);
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.adiciona("A", -1);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }

    @Test
    void adicionarElementoNaPosicaoMaiorQueTamanho(){

        Vetor vetor = new Vetor(10);
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.adiciona("H", 10);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
 
}
