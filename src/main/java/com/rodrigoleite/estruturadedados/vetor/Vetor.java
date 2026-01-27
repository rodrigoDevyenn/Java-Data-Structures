package com.rodrigoleite.estruturadedados.vetor;

public class Vetor {

    private String[] elementos;
    private int tamanho;
    
    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(String elemento) {

        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public String[] getElementos(){
        return elementos;
    }

    public String getElementoPosicao(int posicao){
        return elementos[posicao];
    }

    public int getTamanho(){
        return tamanho;
    }
}
