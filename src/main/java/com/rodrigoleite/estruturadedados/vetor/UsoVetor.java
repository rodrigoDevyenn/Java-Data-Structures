package com.rodrigoleite.estruturadedados.vetor;

import java.util.Scanner;

import com.rodrigoleite.estruturadedados.classesdeuso.Contato;

public class UsoVetor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Vetor<Contato> contatos = new Vetor<Contato>(20);
        preencherVetorCom30Contatos(contatos);

        int opcao = 1;
        while(opcao != 0){
            opcao = obterOpcaoMenu(scan);
            switch (opcao) {
                case 1:
                    adicionarContato(scan, contatos);
                    break;
                case 2:
                    adicionarContatoPosicao(scan, contatos);
                    break;
                case 3:
                    excluirContato(scan, contatos);
                    break;
                case 4:
                    excluirContatoPosicao(scan, contatos);
                    break;
                case 5:
                    excluirTodos(contatos);
                    break;
                case 6:
                    consultarPosicaoLista(scan, contatos);
                    break;
                case 7:
                    verificarContatoNaLista(scan, contatos);
                    break;
                case 8:
                    ultimaPosicaoContato(scan, contatos);
                    break;
                case 9:
                    tamanhoDaLista(contatos);
                    break;
                case 10:
                    imprimirLista(contatos);
                    break;
                case 0:
                    break;
            }
        }

    

    }
    private static void imprimirLista(Vetor<Contato> contatos){

        if (contatos.getTamanho() == 0){
            System.out.println("\nA Lista Está Vazia!\n");
        } else {
            System.out.println(contatos);
        }
    }

    private static void tamanhoDaLista(Vetor<Contato> contatos){

        int tamanho = contatos.getTamanho();
        if (tamanho > 0){
            System.out.println("\nA Lista Tem " + tamanho + " Contatos!\n");
        } else {
            System.out.println("\nA Lista Está Vazia!\n");
        }
    }

    private static void ultimaPosicaoContato(Scanner scan, Vetor<Contato> contatos){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);

        int posicao = contatos.ultimoIndice(contato);
        if (posicao >= 0){
            System.out.println("\nA Última Posição Que Este Contato Foi Encontrado Foi " + posicao + ".\n");
        } else {
            System.out.println("\nContato Não Encontrado!\n");
        }

    }

    private static void verificarContatoNaLista(Scanner scan, Vetor<Contato> contatos){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);

        if (contatos.contem(contato)){
            System.out.println("\nContato Existe Na Lista!\n");
        } else {
            System.out.println("\naContato Não Existe Na Lista!\n");
        }
    }

    private static void consultarPosicaoLista(Scanner scan, Vetor<Contato> contatos){

        Contato contato = null;
        int posicao = lerInfoInt(scan, "Entre com a posição desejada:");
        try {
            contato = contatos.obtem(posicao);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(contato); 
    }

    private static void excluirTodos(Vetor<Contato> contatos){

        contatos.limpar();
        System.out.println("\nContatos Exluidos!\n");
    }

    private static void excluirContatoPosicao(Scanner scan, Vetor<Contato> contatos){

        int posicao = lerInfoInt(scan, "Entre com a posição desejada:");
        try {
            contatos.remove(posicao);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    private static void excluirContato(Scanner scan, Vetor<Contato> contatos){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);

        contatos.remove(contato);

        
    }

    private static void adicionarContatoPosicao(Scanner scan, Vetor<Contato> contatos){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);
        
        int posicao = lerInfoInt(scan, "Entre com a posição desejada:");
        try {
            contatos.adiciona(contato, posicao);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            

    }

    private static void adicionarContato(Scanner scan, Vetor<Contato> contatos){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);
        contatos.adiciona(contato);

    }

    private static String lerInfoString(Scanner scan, String mensagem){
        
        System.out.println(mensagem);
        String entrada  = scan.nextLine();
        return entrada;
    }

    private static int lerInfoInt(Scanner scan, String mensagem){

        String entrada;
        int info = 0;
        boolean opcaoValida = false;
        while(!opcaoValida){
            try{
                System.out.println(mensagem);
                entrada = scan.nextLine();
                info = Integer.parseInt(entrada);
                opcaoValida = true;
            } catch (Exception e) {
                System.out.println("\nEntrada inválida!\n");
            }
        }
        return info;  
    }

    private static int obterOpcaoMenu(Scanner scan){

        int opcao = 0;
        String entrada;
        boolean opcaoValida = false;

        while (!opcaoValida){
            System.out.println("1 - Adicionar Contao");
            System.out.println("2 - Adicionar Contato Na Posição");
            System.out.println("3 - Excluir Um Contato");
            System.out.println("4 - Excluir Contato De Uma Posição");
            System.out.println("5 - Excluir Todos Os Contatos");
            System.out.println("6 - Consultar Uma Posição Da Lista");
            System.out.println("7 - Verificar Se Um Contato Está Na Lista");
            System.out.println("8 - Ultima Posicao Do Contato");
            System.out.println("9 - Tamanho Da Lista");
            System.out.println("10 -Imprimir A Lista");
            System.out.println("0 - Sair");

            try {
                System.out.println("Entre com a opcao desejada:");
                entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 10){
                    opcaoValida = true;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("\nOpção inválida! Tente novamente!\n");
            }
        }
        return opcao;
        
    }

    private static void preencherVetorCom30Contatos(Vetor<Contato> contatos){

        for (int i = 0; i < 30; i++){
            Contato contato = new Contato();
            contato.setNome("Contato " + (i + 1));
            contato.setTelefone("(86) 9 0000-00" + (i + 10));
            contato.setEmail("contato" + (i+1) + "@email.com");
            contatos.adiciona(contato);
        }
    }
}
