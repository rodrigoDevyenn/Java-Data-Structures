package com.rodrigoleite.estruturadedados.pilha;

import com.rodrigoleite.estruturadedados.base.EstruturaEstatica;

public class Pilha <T> extends EstruturaEstatica <T> {

    public Pilha(){
        super();
    }

    public Pilha(int capacidade){
        super(10);
    }

    public void empilhar(T elemento){
        super.adiciona(elemento);
    }

    
}
