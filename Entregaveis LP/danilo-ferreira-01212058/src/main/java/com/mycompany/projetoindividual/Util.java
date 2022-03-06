package com.mycompany.projetoindividual;

public class Util {
    Boolean validarQuantidadeAssistida(Integer quantidadeAssistida) {
        if (quantidadeAssistida.equals(0)) {
            System.out.println("Bem, não tem como gostar de algo que "
                    + "nunca viu...");
            return false;
        } else if (quantidadeAssistida < 0) {
            String frase = "É possível assistir %d filmes?";
            System.out.println(String.format(frase, quantidadeAssistida));
            return false;
        } else {
            return true;
        }
    }
    
    Boolean validarQuantidadeQueGostou(Integer quantidadeQueGostou, 
            Integer quantidadeAssistida) {
        
        if (quantidadeAssistida < quantidadeQueGostou) {
            System.out.println(String.format(
                    "Gostou de %d filmes e assistiu %d?", quantidadeQueGostou, 
                    quantidadeAssistida));
            
            return false;
        } else if (quantidadeQueGostou < 0) {
            System.out.println("Odiou tanto assim?");
            return false;
        } else {
            return true;
        }
    }
    
    void exibirPorcentagem(Integer quantidadeQueAssistiu, 
            Integer quantidadeQueGostou) {
        String frasePorcentagem = "Você gostou de %d%% dos filmes que assistiu!";
        Integer porcentagem = (quantidadeQueGostou * 100 / quantidadeQueAssistiu);
        
        System.out.println(String.format(frasePorcentagem, porcentagem));
    }
    
    Boolean validarIdade(Integer idade) {
        if (idade < 0) {
            System.out.println("Idade negativa?");
            return false;
        } else {
            return true;
        }
    }
    
    void exibirPersonagem(Integer idade) {
        if (idade <= 10) {
            System.out.println("Você é o Homem-Aranha!");
        } else if (idade <= 20) {
            System.out.println("Você é o Homem-Formiga!");
        } else if (idade <= 30) {
            System.out.println("Você é a Viúva Negra!");
        } else if (idade <= 40) {
            System.out.println("Você é o Doutor Estranho!");
        } else if (idade <= 50) {
            System.out.println("Você é o Homem de Ferro!");
        } else if (idade <= 60) {
            System.out.println("Você é o Capitão América!");
        } else if (idade <= 70) {
            System.out.println("Você é a Wanda!");
        } else {
            System.out.println("Você é o Thor");
        }
    }
    
    
}
