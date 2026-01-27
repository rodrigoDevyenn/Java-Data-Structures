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

    public String buscaPorIndice(int indice) throws IllegalArgumentException{

        if (!(indice >= 0 && indice < tamanho)){
            throw new IllegalArgumentException("Posição inválida!");
        }
        return elementos[indice];
    }

    public int buscaPorElemento(String elemento){

        for (int i =0 ; i < this.tamanho; i++){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho; i++){
            if (i < this.tamanho - 1){
                s.append(this.elementos[i]);
                s.append(", ");
            } else {
                s.append(this.elementos[i]);
            }
        }
        s.append("]");
        return s.toString();
    }

    public int getTamanho(){
        return tamanho;
    }
}
