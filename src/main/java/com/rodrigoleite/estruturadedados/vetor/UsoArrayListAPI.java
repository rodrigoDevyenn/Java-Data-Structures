package com.rodrigoleite.estruturadedados.vetor;

import java.util.ArrayList;
import java.util.Scanner;

import com.rodrigoleite.estruturadedados.classesdeuso.Contato;

public class UsoArrayListAPI {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        preencherListaCom30Contatos(contatos);

        int opcao = -1;
        while (opcao != 0){

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
                    excluirTodosContatos(contatos);
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
    private static void imprimirLista(ArrayList<Contato> contatos){
        StringBuilder sb = new StringBuilder();
        sb.append("Meus Contatos - Quantidade: ");
        sb.append(contatos.size());
        sb.append("\n\n");
        for (Contato contato : contatos){
            sb.append(contato);
        }
        sb.append("\n\n");
        System.out.println(sb);
    }

    private static void tamanhoDaLista(ArrayList<Contato> contatos){

        int tamanho = contatos.size();
        if (tamanho == 0){
            System.out.println("\nA Lista Está Vazía!\n");
        } else if (tamanho == 1){
            System.out.println("\nA Lista Tem 1 Contato.\n");
        } else {
            System.out.println("\nA Lista Tem " + tamanho + " Contatos.\n");
        }
    }

    private static void ultimaPosicaoContato(Scanner scan, ArrayList<Contato> contatos){

        Contato contato = criarContato(scan);
        int posicao = contatos.lastIndexOf(contato);
        if (posicao >= 0){
            System.out.println("\nA Última Ocorrência Deste Contato Foi Na Posição " + posicao + ".\n");
        } else {
            System.out.println("\nContato Não Foi Encontrado Na Lista!\n");
        }
    }

    private static void verificarContatoNaLista(Scanner scan, ArrayList<Contato> contatos){

        Contato contato = criarContato(scan);
        boolean respostaMetodo = contatos.contains(contato);
        if (respostaMetodo){
            System.out.println("\nContato Encotrado Na Lista!\n");
        } else {
            System.out.println("\nContato Não Encontrado Na Lista!\n");
        }
    }

    private static void consultarPosicaoLista(Scanner scan, ArrayList<Contato> contatos){
        
        int posicao = lerInfoInt(scan, "Entre com a posicão do contato que deseja consultar:");
        Contato contato;
        try {
            contato = contatos.get(posicao);
            System.out.println("\nContato Da Posição " + posicao + ":\n\n" + contato);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nPosição Inválida!\n");
        }
    }

    private static void excluirTodosContatos(ArrayList<Contato> contatos){

        contatos.clear();
        System.out.println("\nTodos Os Contatos Foram Exluidos Com Sucesso!\n");
    }

    private static void excluirContatoPosicao(Scanner scan, ArrayList<Contato> contatos){

        int posicao = lerInfoInt(scan, "Entre com a posicão do contato que deseja remover:");
        Contato contato;
        try {
            contato = contatos.remove(posicao);
            System.out.println("\nContato: " + contato + " Foi Removido Com Sucesso!\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nPosição Inválida!\n");
        }
    }

    private static void excluirContato(Scanner scan, ArrayList<Contato> contatos){

        Contato contato = criarContato(scan);
        boolean respostaMetodo = contatos.remove(contato);
        if (respostaMetodo){
            System.out.println("\nContato: " + contato + " Foi Removido Com Sucesso!\n");
        } else {
            System.out.println("\nContato Não Encontrado Na Lista!\n");
        }
    }

    private static void adicionarContatoPosicao(Scanner scan, ArrayList<Contato> contatos){

        Contato contato = criarContato(scan);
        int posicao = lerInfoInt(scan, "Entre com a posição desejada:");

        try {
            contatos.add(posicao, contato);
            System.out.println("\nContato Adicionado Com Sucesso Na Posição " + posicao + "!\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nPosição Inválida!\n");
        }
        
    }

    private static void adicionarContato(Scanner scan, ArrayList<Contato> contatos){

        Contato contato = criarContato(scan);
        boolean respostaMetodo = contatos.add(contato);
        if (respostaMetodo){
            System.out.println("\nContato Adicionado Com Sucesso!\n");
        } else {
            System.out.println("\nNão Foi Possível Adicionar Contato\n");
        }
    }

    private static Contato criarContato(Scanner scan){

        String nome = lerInfoString(scan, "Entre com o nome:");
        String telefone = lerInfoString(scan, "Entre com o telefone:");
        String email = lerInfoString(scan, "Entre com o e-mail:");
        Contato contato = new Contato(nome, telefone, email);
        return contato;

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

    private static String lerInfoString(Scanner scan, String mensagem){
        
        System.out.println(mensagem);
        String entrada  = scan.nextLine();
        return entrada;
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

    private static void preencherListaCom30Contatos(ArrayList<Contato> contatos){

        for (int i = 0; i < 30; i++){
            Contato contato = new Contato();
            contato.setNome("Contato " + (i + 1));
            contato.setTelefone("(86) 9 0000-00" + (i + 10));
            contato.setEmail("contato" + (i+1) + "@email.com");
            contatos.add(contato);
        }
    }
}
