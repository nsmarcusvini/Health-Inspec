package com.sptech.individualoficial;

import java.util.Scanner;

public class MetodosMain {
    
    void options() {
SubMetodos sub = new SubMetodos();
Scanner read = new Scanner(System.in);
System.out.println(String.format("Bem vindo ao Banco!"));
System.out.println(String.format("Selecione uma das opções com o número correspondente:"));
System.out.println(String.format("Opção 1: Simulador de Investimento\n"
        + "Opção 2: Simulador de Ações\n"
        + "Opção 3: Faça seu cartão de crédito\n"
        + "Opção 4: Finalizar programa."));
Integer options = read.nextInt();

switch (options) {
    case 1:
        System.out.println(String.format("Bem vindo a área de simulador de investimento!"));
        sub.calculo();
    break;
    case 2:
        System.out.println(String.format("Bem vindo a área de ações de investimento!"));
        sub.condicional();
    break;
    case 3:
        System.out.println(String.format(""));
        sub.livre();
    break;
    case 4:
        System.out.println(String.format("Obrigado pela preferência!"));
    break;
    default:
        System.out.println(String.format("Dígitos Errados!"));
        System.out.println(String.format("Tente Novamente!"));
        System.out.println(String.format("----------------------"));
        options();
        break;
    }

  };
    
 
}

    
    
    
    

