package com.rodrigoleite.estruturadedados;

import org.junit.jupiter.api.Test;

import com.rodrigoleite.estruturadedados.pilha.Pilha;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilhaTest {

    @Test
    void testarInstanciaComConstrutorVazio(){

        Pilha<Integer> pilha = new Pilha<Integer>();
        assertEquals("[]", pilha.toString());
        assertEquals(0, pilha.getTamanho());
    }

    @Test
    void testarInstanciaComConstrutor(){
        Pilha<Integer> pilha = new Pilha<Integer>(10);
        assertEquals("[]", pilha.toString());
        assertEquals(0, pilha.getTamanho());
    }

    @Test
    void empilharElemento(){
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.empilhar(4);
        pilha.empilhar(5);

        assertEquals("[1, 2, 3, 4, 5]", pilha.toString());
        assertEquals(5, pilha.getTamanho());
    }

    
}
