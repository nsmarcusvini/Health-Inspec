package com.mycompany.josias.florencio.silva.ra;

import java.util.Scanner;

public class InteligenciaQuaseArtificial {
    public static void main(String[] args) {
        do {
            MetodoTeste();
        } while (!MetodoTeste());
    }

    public static boolean MetodoTeste() {
        Scanner userInsert = new Scanner(System.in);

        System.out.println("");
        System.out.println("====================================================================================");
        System.out.println("BEM-VINDO(A)! SELECIONE UM NUMERO DE 1 A 4, E VAMOS BRINCAR UM POUCO COM A MINHA IA");
        System.out.println("===================================================================================");
        System.out.println("");
        System.out.println("Numero 1 - Calculadora");
        System.out.println("Numero 2 - Condicionais");
        System.out.println("Numero 3 - Surpresa!");
        System.out.println("Numero 4 - Fechar programa");
        System.out.println("");
        Integer numeroInsert = userInsert.nextInt();

        boolean boolRetornoMetodo = false;
        if (numeroInsert == 4) {
            boolRetornoMetodo = true;
        }

        switch (numeroInsert) {
            case 1:
                Scanner scannerPrimeiroNumero = new Scanner(System.in);
                Scanner scannerSegundoNumero = new Scanner(System.in);

                System.out.println("");
                System.out.println("==================================================");
                System.out.println("TA BEM, MEU CONSAGRADO! BORA FAZER ALGUMAS CONTAS!");
                System.out.println("==================================================");
                System.out.println("");

                System.out.println("Escolha o primeiro número");
                Double primeiroNumero = scannerPrimeiroNumero.nextDouble();
                System.out.println("Escolha o segundo número");
                Double segundoNumero = scannerSegundoNumero.nextDouble();
                System.out.println("");

                Double soma = primeiroNumero + segundoNumero;
                Double subtracao = primeiroNumero - segundoNumero;
                Double multiplicacao = primeiroNumero * segundoNumero;
                Double divisao = primeiroNumero / segundoNumero;

                String fraseSoma = String.format("A soma dos números escolhidos é de: %.0f", soma);
                String fraseSubtracao = String.format("A subtração dos números escolhidos é de: %.0f", subtracao);
                String fraseMultiplicacao = String.format("A multiplicação dos números escolhidos é de: %.0f",
                        multiplicacao);
                String fraseDivisao = String.format("A divisão dos números escolhidos é de: %.1f", divisao);

                System.out.println(fraseSoma);
                System.out.println(fraseSubtracao);
                System.out.println(fraseMultiplicacao);
                System.out.println(fraseDivisao);
                System.out.println("");
                break;

            case 2:
                Scanner scannerConversaBot = new Scanner(System.in);

                System.out.println("");
                System.out.println("========================================");
                System.out.println("OK, MEU CUPINCHA! BORA BATER UM PAPINHO!");
                System.out.println("========================================");
                System.out.println("Do que você gosta mais?");
                System.out.println("Numero 1 - Animes");
                System.out.println("Numero 2 - Filmes");
                System.out.println("Numero 3 - Jogos");
                System.out.println("");

                Integer conversaBot = scannerConversaBot.nextInt();

                switch (conversaBot) {
                    case 1:
                        System.out.println("");
                        System.out.println("=======================================================");
                        System.out.println("Sujeitinho de bom gosto! Aqui vai algumas recomedações:");
                        System.out.println("=======================================================");
                        System.out.println("");
                        System.out.println("Cowboy Bebop");
                        System.out.println("Monster");
                        System.out.println("Akira");
                        System.out.println("Castlevania");
                        System.out.println("DevilMan Cry Baby");
                        System.out.println("");

                        break;

                    case 2:
                        System.out.println("");
                        System.out.println("=======================================================");
                        System.out.println("Sujeitinho de bom gosto! Aqui vai algumas recomedações:");
                        System.out.println("=======================================================");
                        System.out.println("");
                        System.out.println("A Origem");
                        System.out.println("Era Uma Vez em Hollywood");
                        System.out.println("Os Oito Odiados");
                        System.out.println("Bastardos Inglórios");
                        System.out.println("Eu Sou a Lenda");
                        System.out.println("");

                        break;

                    case 3:
                        System.out.println("");
                        System.out.println("=======================================================");
                        System.out.println("Sujeitinho de bom gosto! Aqui vai algumas recomedações:");
                        System.out.println("=======================================================");
                        System.out.println("");
                        System.out.println("Elden Ring");
                        System.out.println("God of War (2018)");
                        System.out.println("Bloodborne");
                        System.out.println("Dead Space");
                        System.out.println("Shadow of The Colossus");
                        System.out.println("");

                        break;

                    default:
                        System.out.println("");
                        System.out.println("=================================");
                        System.out.println("NÚMERO INVÁLIDO! TENTE NOVAMENTE!");
                        System.out.println("=================================");
                        System.out.println("");
    
                        break;
                }
                break;

            case 3:
                Scanner scannerResposta = new Scanner(System.in);

                System.out.println("");
                System.out.println("================================");
                System.out.println("AE MEU PEIXE, TU CURTE MUSICA???");
                System.out.println("================================");
                System.out.println("");

                System.out.println("1 - OPA! ADORO!");
                System.out.println("2 - Naah...");
                System.out.println("");
                
                Integer Resposta = scannerResposta.nextInt();

                switch (Resposta) {
                    case 1:
                        System.out.println("");
                        System.out.println("=======================================================================");
                        System.out.println("ERA ISSO QUE EU QUERIA OUVIR!..?. Ou Ler? Compilar, talvez?");
                        System.out.println("...");
                        System.out.println("encurtador.com.br/aqvI4");
                        System.out.println("=======================================================================");
                        System.out.println("BOM! ERA ISSO QUE EU QUERIA OUV... c.. COMPLICAR :D");
                        System.out.println("EU TROUXE PARA VOCE ALGUMAS MUSICAS DAS QUAIS ACHO QUE VOCÊ PODE GOSTAR");
                        System.out.println("BOM PROVEITO!");
                        System.out.println("=======================================================================");
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("Joe Hicks - Cold");
                        System.out.println("https://www.youtube.com/watch?v=KBlyHvLb4jI");
                        System.out.println("===========================================");
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("Nick Kingswell - Undertow");
                        System.out.println("https://www.youtube.com/watch?v=3a-DX9XOxdk");
                        System.out.println("===========================================");
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("twenty one pilots - Heavydirtysoul (TOPxMM)");
                        System.out.println("https://www.youtube.com/watch?v=0KEwQEBEvIU");
                        System.out.println("===========================================");
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("MUSE - Time is Running Out");
                        System.out.println("https://www.youtube.com/watch?v=O2IuJPh6h_A");
                        System.out.println("===========================================");
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("Powerwolf - Raise Your Fist, Evangelist");
                        System.out.println("https://www.youtube.com/watch?v=Yv1LukhMaHI");
                        System.out.println("===========================================");
                        System.out.println("");
                        
                        break;
                    
                    case 2:
                        System.out.println("");
                        System.out.println("==========================================================================");
                        System.out.println("MASOQ??? QUEM NÃO CURTE MUSICA??? ");
                        System.out.println("PARE DE TESTAR MINHAS POSSIBILIDADES COMO PROGRAMA E VÁ RESPONDER DIREITO!");
                        System.out.println("Tu ta muito ousado...");
                        System.out.println("...");
                        System.out.println("Seu ousado...");
                        System.out.println("==========================================================================");
                        System.out.println("");
                        
                        break;
                
                    default:
                        System.out.println("");
                        System.out.println("=================================");
                        System.out.println("NÚMERO INVÁLIDO! TENTE NOVAMENTE!");
                        System.out.println("=================================");
                        System.out.println("");
                        
                        break;
                }
                break;

            case 4:
                System.out.println("");
                System.out.println("==============");
                System.out.println("ATÉ A PRÓXIMA!");
                System.out.println("==============");
                System.out.println("");

                break;

            default:
                System.out.println("");
                System.out.println("=================================");
                System.out.println("NÚMERO INVÁLIDO! TENTE NOVAMENTE!");
                System.out.println("=================================");
                System.out.println("");

                break;
        }
        return boolRetornoMetodo;
    }
}