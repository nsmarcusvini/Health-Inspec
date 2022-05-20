
package com.mycompany.loginhealthinspec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    public static void guardarLog(String textoLog){
        File diretorio = new File("logs");
        diretorio.mkdir();
        
        String arquivoData = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        String arquivoNome = String.format("logs/%s.txt", arquivoData);
        
        String dataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss - ").format(LocalDateTime.now());
        
        
        File arquivo = new File(arquivoNome);
        
        try (
                FileWriter criadorDeArquivos = new FileWriter(arquivo, true);
                BufferedWriter escrever = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(escrever);){
                    
            escritorDeArquivos.append("\n " + dataHora + textoLog);
                
        }catch (IOException erro) {
            erro.printStackTrace();
        }
        
    }
    
}
