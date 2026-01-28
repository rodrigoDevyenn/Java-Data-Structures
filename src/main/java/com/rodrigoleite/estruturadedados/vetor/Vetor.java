package com.rodrigoleite.estruturadedados.vetor;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;
    
    @SuppressWarnings("unchecked")
    public Vetor(int capacidade){
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(T elemento) {
        
        this.aumentarCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;

    }

    public boolean adiciona(T elemento, int indice){

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

    public void remove(int indice){

        verificaIndiceValido(indice);
        for (int i = indice; i < (this.tamanho - 1); i++){
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    public void remove (T elemento){
        this.remove(buscaPorElemento(elemento));
    }

    public T obtem(int indice) throws IllegalArgumentException{
        verificaIndiceValido(indice);
        return elementos[indice];
    }

    public int buscaPorElemento(T elemento){

        for (int i =0 ; i < this.tamanho; i++){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public boolean contem(T elemento){

        int indice = buscaPorElemento(elemento);
        if (indice >= 0){
            return true;
        }
        return false;
    }

    public int ultimoIndice(T elemento){

        for (int i = (this.tamanho - 1); i >= 0; i--){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;

    }

    @SuppressWarnings("unchecked")
    private void aumentarCapacidade(){

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

    public int getCapacidade(){
        return this.elementos.length;
    }
}
