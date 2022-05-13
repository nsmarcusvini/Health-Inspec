package com.mycompany.log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogTeste {
    public static void main(String[] args) throws IOException{
        String dataLog = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        String texto = String.format("%s log realizado com sucesso \n", dataLog);
        Log.guardarLog(texto);
    }
}
