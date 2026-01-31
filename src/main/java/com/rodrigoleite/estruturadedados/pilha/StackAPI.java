package com.rodrigoleite.estruturadedados.pilha;

import java.util.Stack;

public class StackAPI {

    public static void main(String[] args) {
        
        // Declaração e instânciação da Pilha.
        Stack<Integer> pilha = new Stack<Integer>();

        // Método isEmpty() - Retorna true se a pilha estiver vazia, se não retorna false
        System.out.println(pilha.isEmpty());                //true

        // Método size() - retorna o tamanho da pilha.
        System.out.println(pilha.size());

        // Método toString() - imprimir a pilha.
        System.out.println(pilha.toString());

        // Método push() - Para empilhar um elemento na pilha.
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        System.out.println();

        System.out.println(pilha.isEmpty());                //false
        System.out.println(pilha.size());                   // 3
        System.out.println(pilha);                          //[1, 2, 3]

        System.out.println();

        /*  Método pop() - desempilhar um elemeto(sempre o último que foi adicionado) da pilha e retorna. */
        System.out.println(pilha.pop() );                   // 3
        System.out.println(pilha.size());                   // 2
        System.out.println(pilha);                          //[1, 2]

        // Método peek() - verifica/espia o topo da pilha.
        System.out.println(pilha.peek());                   //2


        

    }
}
