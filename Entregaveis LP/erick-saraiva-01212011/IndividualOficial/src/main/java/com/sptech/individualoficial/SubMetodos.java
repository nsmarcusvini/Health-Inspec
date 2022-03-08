package com.sptech.individualoficial;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SubMetodos {
      
    Double calculo() {
    Scanner leitorInvest = new Scanner(System.in);
    Scanner leitorAnos = new Scanner(System.in);
    System.out.println(String.format("Quanto deseja investir ?"));
    Double qtdInvest = leitorInvest.nextDouble();
    System.out.println(String.format("Por quantos anos deseja investir ?"));
    Double anos = leitorAnos.nextDouble();
    
    Double taxa = 10.75 /100;
    Double meses = anos * 12;
    Double totalInvestido = qtdInvest * meses;
    Double resultado = (totalInvestido * taxa) + totalInvestido;
       
    System.out.println(String.format("Considerando uma taxa de 10,75 ao ano:"));
        System.out.println(String.format("Após %.0f anos você investiu R$ %.2f" +
                " e terá R$ %.2f com o investimento.", 
                anos, totalInvestido, resultado));
    
    return resultado;
    }
    
    void condicional() {
        
        
    Scanner leitorQntInvest = new Scanner(System.in);
    System.out.println(String.format("Quanto quer investir por ano ?"));
    Double dinheiroInvestido = leitorQntInvest.nextDouble();
    Double taxa1 = 9.48 / 100;
    Double taxa2 = 10.48 / 100;
    Double taxa3 = 12.48 / 100;
    Double resultado1 = (dinheiroInvestido * taxa1) + dinheiroInvestido;
    Double resultado2 = (dinheiroInvestido * taxa2) + dinheiroInvestido;
    Double resultado3 = (dinheiroInvestido * taxa3) + dinheiroInvestido;
    
    if (dinheiroInvestido <= 600) {
        
        System.out.println(String.format("Com esse valor de invesimento por ano: "));
        System.out.println(String.format("Você deve investir em uma ação fixa como o tesouro direto"));
        System.out.println(String.format("O tesouro direto tem uma taxa mais baixa "
                + "que as outras ações"
                + "então no final do ano você terá acumulado R$ %.2f.", resultado1)); 
    }
    else if (dinheiroInvestido <= 1200) {
        
        System.out.println(String.format("Com esse valor de invesimento por ano: "));
        System.out.println(String.format("Você deve investir em uma ação fixa como o tesouro direto"
            + "ou tentar duas ações com uma de maior risco para ter um maior retorno."));
        System.out.println(String.format("Investindo em duas ações no final do ano"
                + " você terá acumulado R$ %.2f.", resultado2)); 
    }
    else {
        
        System.out.println(String.format("Com esse valor já é possível diferenciar seus investimentos:"));
        System.out.println(String.format("Simulando que você gosta de investir"
                + " em ações de maior risco para ter um maior retorno."));
        System.out.println(String.format("Você pode investir em criptmoedas por exemplo, "
                + "então fazendo um cálculo de investidor de criptmoedas"
                + " você terá acumulado R$ %.2f.", resultado3));
         
    } 

    }
    
    void livre(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Seu nome completo:");
        String nomeDigitado = leitor.nextLine();
        
        
        Integer n1 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n2 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n3 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n4 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n5 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n6 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n7 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n8 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n9 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n10 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n11 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n12= ThreadLocalRandom.current().nextInt(0, 10);
        Integer n13 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n14= ThreadLocalRandom.current().nextInt(0, 10);
        Integer n15 = ThreadLocalRandom.current().nextInt(0, 10);
        Integer n16 = ThreadLocalRandom.current().nextInt(0, 10);
 
        
        System.out.println(String.format("ESSE É O SEU NOVO CARTÃO DE CRÉDITO:"));
        System.out.println(String.format("--------------------------------------"));
        System.out.println(String.format("%d%d%d%d %d%d%d%d %d%d%d%d %d%d%d%d", 
                n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16));
        System.out.println(String.format("07/28"));
        System.out.println(String.format("%s", nomeDigitado));
        
        
        
        
    }
 
}
  

