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
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2));

    }

    @Test
    void adicionarElementoComVetorCheio() {

        Vetor<String> vetor = new Vetor<String>(2);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        
        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2));
    }

    @Test
    void verificarTamanhoDoVetor(){

        Vetor<String> vetor = new Vetor<String>(10);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(3, vetor.getTamanho());

    }

    @Test
    void verificarImpressaoDoVetor(){

        Vetor<String> vetor = new Vetor<String>(10);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("[A, B, C]", vetor.toString());

    }

    @Test
    void fazerBuscaValida() {

        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals("A", vetor.buscaPorIndice(0));
        assertEquals("B", vetor.buscaPorIndice(1));
        assertEquals("C", vetor.buscaPorIndice(2)); 
    }

    @Test
    void fazerBuscaInvalidaComIndiceNegativo() {

        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.buscaPorIndice(-1);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
    
    @Test
    void fazerBuscaInvalidaComIndiceMaiorQueTamanho() {

        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.buscaPorIndice(3);});
        
        assertEquals("Posição inválida!", e.getMessage());
    }
    
    @Test
    void fazerBuscaPorElementoQueExiste(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(0, vetor.buscaPorElemento("A"));
        assertEquals(1, vetor.buscaPorElemento("B"));
        assertEquals(2, vetor.buscaPorElemento("C"));
    }

    @Test
    void fazerBuscaPorElementoQueNaoExiste(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(-1, vetor.buscaPorElemento("D"));
    }

    @Test
    void fazerBuscaPorElementoQueExisteComCaseDiferente(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");

        assertEquals(-1, vetor.buscaPorElemento("a"));
        assertEquals(-1, vetor.buscaPorElemento("b"));
    }

    @Test
    void adicionarElementoNaPosicaoDesejada(){

        Vetor<String> vetor = new Vetor<String>(10);
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

        Vetor<String> vetor = new Vetor<String>(10);
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

        Vetor<String> vetor = new Vetor<String>(10);
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

        Vetor<String> vetor = new Vetor<String>(3);
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

        Vetor<String> vetor = new Vetor<String>(3);
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

        Vetor<String> vetor = new Vetor<String>(3);
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

        Vetor<String> vetor = new Vetor<String>(3);
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

        Vetor<String> vetor = new Vetor<String>(3);
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

        Vetor<String> vetor = new Vetor<String>(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        
        vetor.remove("A");

        assertEquals("B", vetor.buscaPorIndice(0));
        assertEquals(2, vetor.getTamanho());
    }

    @Test
    void removePorElementoQueNaoExiste(){

        Vetor<String> vetor = new Vetor<String>(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {vetor.remove("D");});
        
        assertEquals("Posição inválida!", e.getMessage());
    }

    @Test 
    void contemElemento(){

        Vetor<String> vetor = new Vetor<String>(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);

        boolean resultado = vetor.contem("A");

        assertTrue(resultado);
    }

    @Test 
    void contemElementoNaoExistente(){

        Vetor<String> vetor = new Vetor<String>(3);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);

        boolean resultado = vetor.contem("D");

        assertFalse(resultado);
    }

    @Test
    void ultimoIndicePrimeiraPosicao(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        int indice = vetor.ultimoIndice("A");

        assertEquals(0, indice);
    }

    @Test
    void ultimoIndiceRepetidoDuasVezes(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("A", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        int indice = vetor.ultimoIndice("A");

        assertEquals(2, indice);
    }

    @Test
    void ultimoIndiceRepetidoTresVezes(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("A", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("A", 4);

        int indice = vetor.ultimoIndice("A");

        assertEquals(4, indice);
    }

    @Test
    void ultimoIndiceElementoInexistente(){
        
        Vetor<String> vetor = new Vetor<String>(5);
        vetor.adiciona("A", 0);
        vetor.adiciona("B", 1);
        vetor.adiciona("C", 2);
        vetor.adiciona("D", 3);
        vetor.adiciona("E", 4);

        int indice = vetor.ultimoIndice("F");

        assertEquals(-1, indice);
    }
}
