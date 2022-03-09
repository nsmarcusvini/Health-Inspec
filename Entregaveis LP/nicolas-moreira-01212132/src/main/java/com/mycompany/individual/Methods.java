
package com.mycompany.individual;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Nicolas
 */
public class Methods {

    void calculoMedia() {
        Scanner scanNumber = new Scanner(System.in);
        Integer jogarDeNovo = 1;
        while (jogarDeNovo.equals(1)) {

            System.out.println("\nDigite quantos jogos você jogou no campeonato:");
            Double qtdJogos = scanNumber.nextDouble();
            Double qtdGols = 0.0;
            Double mediaGols = 0.0;
            for (int i = 1; i <= qtdJogos; i++) {
                System.out.println(String.format("\nQuantos gols você fez no"
                        + " %dº jogo:", i));
                qtdGols += scanNumber.nextDouble();
            }
            mediaGols = qtdGols / qtdJogos;
            System.out.println(String.format("\n Sua média de gols durante os %.0f"
                    + " jogos do campeonato foi de:\n %.1f", qtdJogos, mediaGols));

            System.out.println("\nDeseja jogar de novo?\n"
                    + "1 - Sim\n"
                    + "0 - Não\n");
            jogarDeNovo = scanNumber.nextInt();
        }
            

    }

    void artilheiro() {
        Scanner scanNumber = new Scanner(System.in);
        Integer jogarDeNovo = 1;
        while (jogarDeNovo.equals(1)) {

            System.out.println("\nDigite quantos gols você fez no campeonato que"
                    + " jogou: ");
            Integer qtdGols = scanNumber.nextInt();
            if (qtdGols > 50) {
                System.out.println("\n VOCÊ É IMPARAVEL, INCANSÁVEL,"
                        + " UM ARTILHEIRO NATO!!!");
            } else if (qtdGols > 30) {
                System.err.println("\n Você faz gols demais!!");
            } else if (qtdGols > 15) {
                System.out.println("\n Você joga muito bem!!");
            } else if (qtdGols > 5) {
                System.out.println("\n Você é bom em fazer gols, mas tente elevar"
                        + " o nivel");
            } else {
                System.out.println("\n Acho que você tem que treinar mais, hein?");
            }
            System.out.println("\nDeseja jogar de novo?\n"
                    + "1 - Sim\n"
                    + "0 - Não\n");
            jogarDeNovo = scanNumber.nextInt();
        }
            
    }

    void testeSuaSorte() {
        Scanner scanNumber = new Scanner(System.in);
        Integer jogarDeNovo = 1;
        while (jogarDeNovo.equals(1)) {

            System.out.println("\nDigite um número de 1 a 8 e veja se ganha um"
                    + " troféu de campeonato: ");
            Integer numeroSorte = scanNumber.nextInt();

            Integer numeroRandom = ThreadLocalRandom.current().nextInt(1, 8);

            if (numeroSorte.equals(numeroRandom)) {
                System.out.println("\nParábens você ganhou um troféu do campeonato!");
            } else {
                System.out.println("Que pena, você não teve sorte, tente na"
                        + " próxima!");
            }
            System.out.println("\nDeseja jogar de novo?\n"
                    + "1 - Sim\n"
                    + "0 - Não\n");
            jogarDeNovo = scanNumber.nextInt();
        }
            
    }

    void desafio() {
        Scanner scanNumber = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        Integer golsFeitos = 0;
        Integer golsPerdidos = 0;
        Integer jogarDeNovo = 1;
        while (jogarDeNovo.equals(1)) {

            System.out.println("Vamos ver quantos gols você faz?\n"
                    + "Você tem 10 tentativas, vamos lá!!!\n");
            Integer numeroRandom = ThreadLocalRandom.current().nextInt(1, 10);
            for (int i = 1; i <= 10; i++) {
                numeroRandom = ThreadLocalRandom.current().nextInt(0, 2);
                System.out.println("\nHora de jogar, digite 'JOGAR', para jogar"
                        + " a bola no gol");
                String chutar = scanString.nextLine();
                if (numeroRandom.equals(1)) {
                    System.out.println(String.format("\n%dº tentativa: ", i));
                    System.out.println("ERROOOU!!!");
                    golsPerdidos++;
                } else {
                    System.out.println(String.format("\n%dº tentativa: ", i));
                    System.out.println("GOOOOOL!!!");
                    golsFeitos++;
                }
            }
            System.out.println(String.format("\nSua pontuação final foi de:\n"
                    + "%d gols feitos.\n"
                    + "%d gols perdidos.\n", golsFeitos, golsPerdidos));
            if (golsFeitos > golsPerdidos) {
                System.out.println("\nVocê é um bom goleador!!");
            }else if (golsFeitos.equals(golsPerdidos)) {
                System.out.println("Você é um goleador mediano!");
            }  
            else {
                System.out.println("\nVocê tem que dar uma melhorada na sua mira!\n");
            }
            System.out.println("\nDeseja jogar de novo?\n"
                    + "1 - Sim\n"
                    + "0 - Não\n");
            jogarDeNovo = scanNumber.nextInt();
            golsFeitos = 0;
            golsPerdidos = 0;
        }
           
    }
    
}
