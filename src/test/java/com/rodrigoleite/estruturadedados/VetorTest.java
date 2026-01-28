package com.rodrigoleite.estruturadedados;

import com.rodrigoleite.estruturadedados.vetor.Vetor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class VetorTest {

    @Test
    void adicionarElementosQuandoHaEspaco() {
        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2));

    }

    @Test
    void adicionarElementoComVetorCheio() {

        Vetor vetor = new Vetor(2);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        
        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2));
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

    @Test
    void aumentarCapacidadeDoVetorAdicionandoFinal(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("D");
        vetor.adiciona("E");

        assertEquals(6, vetor.getCapacidade());
        assertEquals(5, vetor.getTamanho());
    }

    @Test
    void aumentarCapacidadeDoVetorAdicionandoPosicao(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        assertEquals(6, vetor.getCapacidade());
        assertEquals(5, vetor.getTamanho());
    }

    @Test
    void removeElementoValido(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        vetor.remove(1);
        
        assertEquals("C", vetor.buscaPorIndice(1));
        assertEquals(4, vetor.getTamanho());
    }

    @Test
    void removeElementoIndiceNegativo(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.remove(-1);});

        assertEquals("Posição inválida!", e.getMessage());
    }

    @Test
    void removeElementoIndiceMaiorOuIgualTamanho(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.remove(5);});
        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {vetor.remove(6);});

        assertEquals("Posição inválida!", e.getMessage());
        assertEquals("Posição inválida!", e2.getMessage());
    }

    @Test
    void removePorElementoValido(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        
        vetor.remove("A");

        assertEquals("B", vetor.buscaPorIndice(0));
        assertEquals(2, vetor.getTamanho());
    }

    @Test
    void removePorElementoQueNaoExiste(){

        Vetor vetor = new Vetor(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.remove("D");});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
 
}
