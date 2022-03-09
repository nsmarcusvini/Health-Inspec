package com.mycompany.individual;

import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class App {

    public static void main(String[] args) {
        Methods metodos = new Methods();
        Scanner scanString = new Scanner(System.in);
        Scanner scanNumber = new Scanner(System.in);

        System.out.println("Handebol Cup");

        System.out.println("\nDigite seu nome: ");
        String nomeDigitado = scanString.nextLine();

        System.out.println(String.format("\nOlá %s!, selecione uma opção que lhe "
                + "agrade:\n", nomeDigitado));

        System.out.println("1- Média de gols por jogo \n"
                + "2- Sou um bom artilheiro? \n"
                + "3- Tente sua sorte \n"
                + "4- Sair \n\n"
                + "5- (JOGO)Chute ao gol");
        Integer numeroDigitado = scanNumber.nextInt();

        while (!numeroDigitado.equals(1) && !numeroDigitado.equals(2)
                && !numeroDigitado.equals(3) && !numeroDigitado.equals(4)
                && !numeroDigitado.equals(5)) {
            System.out.println("Número invalido, tente novamente.");
            numeroDigitado = scanNumber.nextInt();
        }
        while (numeroDigitado != 4) {

            switch (numeroDigitado) {
                case 1:
                    metodos.calculoMedia();
                    System.out.println(String.format("\nOlá %s!, selecione uma opção que lhe "
                            + "agrade:\n", nomeDigitado));

                    System.out.println("1- Média de gols por jogo \n"
                            + "2- Sou um bom artilheiro? \n"
                            + "3- Tente sua sorte \n"
                            + "4- Sair \n\n"
                            + "5- (JOGO)Chute ao gol");
                    numeroDigitado = scanNumber.nextInt();
                    break;

                case 2:
                    metodos.artilheiro();
                    System.out.println(String.format("\nOlá %s!, selecione uma opção que lhe "
                            + "agrade:\n", nomeDigitado));

                    System.out.println("1- Média de gols por jogo \n"
                            + "2- Sou um bom artilheiro? \n"
                            + "3- Tente sua sorte \n"
                            + "4- Sair \n\n"
                            + "5- (JOGO)Chute ao gol");
                    numeroDigitado = scanNumber.nextInt();
                    break;

                case 3:
                    metodos.testeSuaSorte();
                    System.out.println(String.format("\nOlá %s!, selecione uma opção que lhe "
                            + "agrade:\n", nomeDigitado));

                    System.out.println("1- Média de gols por jogo \n"
                            + "2- Sou um bom artilheiro? \n"
                            + "3- Tente sua sorte \n"
                            + "4- Sair \n\n"
                            + "5- (JOGO)Chute ao gol");
                    numeroDigitado = scanNumber.nextInt();
                    break;

                case 4:
                    System.out.println("\nAté mais!!");
                    System.out.println("\n------ Fim da aplicação ------\n");
                    break;

                case 5:
                    metodos.desafio();
                    System.out.println(String.format("\nOlá %s!, selecione uma opção que lhe "
                            + "agrade:\n", nomeDigitado));

                    System.out.println("1- Média de gols por jogo \n"
                            + "2- Sou um bom artilheiro? \n"
                            + "3- Tente sua sorte \n"
                            + "4- Sair \n\n"
                            + "5- (JOGO)Chute ao gol");
                    numeroDigitado = scanNumber.nextInt();
                    break;
            }
            System.out.println("\nAté mais!!");
                    System.out.println("\n------ Fim da aplicação ------\n");
        }
    }
}
