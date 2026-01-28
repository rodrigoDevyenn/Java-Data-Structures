package com.rodrigoleite.estruturadedados.vetor;

import java.util.ArrayList;

public class TesteArrayListAPI {

    public static void main(String[] args) {
        
        ArrayList<String> arraylist = new ArrayList<String>();

        // Método add(String elemento) para adicionar um elemento.
        arraylist.add("A");
        arraylist.add("C");
        System.out.println(arraylist);                               //[A, C]

        // Método add(int indice, String elemento) passando o elemento e a posição desejada.
        arraylist.add(1, "B");
        System.out.println(arraylist);                               //[A, B, C]

        System.out.println();

        // Método contains(String elemento) para verificar se um elemento existe no array.
        boolean existe = arraylist.contains("A");
        if (existe){
            System.out.println("Elemento existe no Array!");
        } else {
            System.out.println("Elemento não existe no Array!");
        }
        existe = arraylist.contains("D");
        if (existe){
            System.out.println("Elemento existe no Array!");
        } else {
            System.out.println("Elemento não existe no Array!");
        }

        System.out.println();

        // Método indexOf(String elemento) verifica qual o indice de um elemento no array.
        int indice = arraylist.indexOf("B");                                               
        if (indice >= 0){                                                   //true
            System.out.println("Elemento na posição " + indice + ".");
        } else {
            System.out.println("Elemento não existe no Array!");
        }
        indice = arraylist.indexOf("D");
        if (indice >= 0){                                                   //false
            System.out.println("Elemento na posição " + indice + ".");
        } else {
            System.out.println("Elemento não existe no Arrat!");
        }

        System.out.println();

        // Método get(int indice) retorna o elemento da posição informada.
        System.out.println(arraylist.get(0));                               //A
        System.out.println(arraylist.get(1));                               //B
        System.out.println(arraylist.get(2));                               //C
        //System.out.println(arraylist.get(3));                             IndexOutOfBoundsException

        System.out.println();

        // Método remove(int indice) remove um elemento pelo indice.
        arraylist.remove(0);                                                //removendo A
        System.out.println(arraylist);                                      //[B, C] 
        
        //Método remove(String elemento) remove um elemento.
        arraylist.remove("B");                                              //removendo B         
        System.out.println(arraylist);                                      //[C]

        System.out.println();

        // Método size() retorna o tamanho do array.
        System.out.println(arraylist.size());                               //1

    }
}
