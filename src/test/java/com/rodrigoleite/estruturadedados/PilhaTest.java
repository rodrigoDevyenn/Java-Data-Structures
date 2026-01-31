package com.rodrigoleite.estruturadedados;

import com.rodrigoleite.estruturadedados.pilha.Pilha;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void pilhaEstaVazia(){
        Pilha<Integer> pilha = new Pilha<Integer>();
        boolean resposta = pilha.estaVazia();
        assertTrue(resposta);
    }

    @Test
    void pilhaNaoEstaVazia(){
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);

        boolean resposta = pilha.estaVazia();
        assertFalse(resposta);
    }

    @Test
    void verificarTopoDaPilha(){
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);

        assertEquals(3, pilha.topo());
    }

    @Test
    void verificarTopoDaPilhaVazia(){
        Pilha<Integer> pilha = new Pilha<Integer>();
    
        assertEquals(null, pilha.topo());
    }
    
    @Test
    void desempilharPilha(){
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);

        assertEquals(3, pilha.desempilhar());
        assertEquals("[1, 2]", pilha.toString());
    }

    @Test
    void desempilharPilhaVazia(){
        Pilha<Integer> pilha = new Pilha<Integer>();
    
        assertEquals(null, pilha.desempilhar());
    }

    
}
