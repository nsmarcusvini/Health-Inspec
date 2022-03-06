package com.mycompany.projetoindividual;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Util util = new Util();

        System.out.println("Bem vindo ao programa para fãs da Marvel! \n"
                + "Escolha uma opção: \n\t"
                + "1- Calcule o quanto você gosta de Marvel! \n\t"
                + "2- Digite sua idade e descubra que personagem você é \n\t"
                + "3- Recomendações \n\t"
                + "4- Sair \n\t"
                + "5 - QUIZ!!");

        Scanner input = new Scanner(System.in);

        Integer opcaoEscolhida = input.nextInt();

        while (opcaoEscolhida < 1 || opcaoEscolhida > 5) {
            System.out.println("Digite uma opção válida!");
            opcaoEscolhida = input.nextInt();
        }

        while (opcaoEscolhida != 4) {
            switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Digite quantos filmes da Marvel "
                            + "você já assistiu:");
                    Integer quantidadeAssistida = input.nextInt();

                    while (!(util.validarQuantidadeAssistida(quantidadeAssistida))) {
                        quantidadeAssistida = input.nextInt();
                    }

                    if (util.validarQuantidadeAssistida(quantidadeAssistida)) {
                        String fraseFilmesQueGostou = "Desses %d filmes, quantos "
                                + "você gostou?";
                        System.out.println(String.format(fraseFilmesQueGostou,
                                quantidadeAssistida));

                        Integer filmesQueGostou = input.nextInt();

                        while (!(util.validarQuantidadeQueGostou(filmesQueGostou,
                                quantidadeAssistida))) {
                            filmesQueGostou = input.nextInt();
                        }

                        if (util.validarQuantidadeQueGostou(filmesQueGostou,
                                quantidadeAssistida)) {

                            util.exibirPorcentagem(quantidadeAssistida, filmesQueGostou);

                            System.out.println("Digite outro número do menu para "
                                    + "continuar jogando ou 4 para sair!");
                            opcaoEscolhida = input.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite sua idade:");
                    Integer idade = input.nextInt();

                    while (!(util.validarIdade(idade))) {
                        idade = input.nextInt();
                    }

                    if (util.validarIdade(idade)) {
                        util.exibirPersonagem(idade);

                        System.out.println("Digite outro número do menu para "
                                + "continuar jogando ou 4 para sair!");
                        opcaoEscolhida = input.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("Ok. Iremos recomendar o top 5 filmes SOLOS da Marvel\n\t");

                    System.out.println("==========================================================");
                    System.out.println("""
                                       1: Homem-Aranha - Sem Volta Para Casa
                                       2: Capitão América - O Soldado Invernal 
                                       3: Pantera Negra 
                                       4: Thor - Ragnarok
                                       5: Homem de Ferro
                                       """);
                    System.out.println("==========================================================");

                    System.out.println("Digite outro número do menu para "
                            + "continuar jogando ou 4 para sair!");
                    opcaoEscolhida = input.nextInt();
                    break;
                case 5:
                    System.out.println("Vamos começar o quiz!");
                    System.out.println("Digite o número da alternativa para"
                            + "responder a pergunta");
                    
                    System.out.println("=====================================");
                    
                    Integer nota = 0;
                    
                    System.out.println("""
                                       Qual desses morreu em Ultimato? 
                                       \t1- Tony 
                                       \t2- Thor
                                       \t3- Peter Parker
                                       """);
                    Integer resposta1 = input.nextInt();
                    if (resposta1.equals(1)) {
                        nota++;
                    }
                    
                    System.out.println("""
                                       Qual é o nome do segundo filme do 
                                       Capitão América? 
                                       \t1- Longe de Casa
                                       \t2- Só Capitão América 2 mesmo
                                       \t3- Soldado Invernal
                                       """);
                    Integer resposta2 = input.nextInt();
                    if (resposta2.equals(3)) {
                        nota++;
                    }
                    
                    System.out.println("""
                                       Quem é o vilão de Guardiões da Galáxia 2?
                                       \t1 - Ronan
                                       \t2 - Ego
                                       \t3 - Thanos
                                       """);
                    Integer resposta3 = input.nextInt();
                    if (resposta3.equals(2)) {
                        nota++;
                    }
                    
                    System.out.println(String.format("Você tirou %d!", nota));
                    
                    System.out.println("Digite outro número do menu para "
                            + "continuar jogando ou 4 para sair!");
                    opcaoEscolhida = input.nextInt();
                    
                    break;
            }
        }
    }
}
