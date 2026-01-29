package com.rodrigoleite.estruturadedados.base;

public class EstruturaEstatica <T> {

    protected T[] elementos;
    protected int tamanho;

    
    @SuppressWarnings("unchecked")
    public EstruturaEstatica(int capacidade){
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public EstruturaEstatica(){
        this(10);
    }

    protected void adiciona(T elemento) {
        
        this.aumentarCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;

    }

    protected boolean adiciona(T elemento, int indice){

        if (this.tamanho != indice){
            verificaIndiceValido(indice);
        }
        
        this.aumentarCapacidade();
        for (int i = (tamanho -1); i >= indice; i--){
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[indice] = elemento;
        this.tamanho++;
        return true;
    }

    @SuppressWarnings("unchecked")
    protected void aumentarCapacidade(){

        if (this.tamanho == this.elementos.length){
            T[] novoElementos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++){
                novoElementos[i] = this.elementos[i];
            }
            this.elementos = novoElementos;
        }
    }

    private boolean verificaIndiceValido(int inidice){
        if (inidice < 0 || inidice >= this.tamanho){
            throw new IllegalArgumentException("Posição inválida!");
        }
        return true;
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
