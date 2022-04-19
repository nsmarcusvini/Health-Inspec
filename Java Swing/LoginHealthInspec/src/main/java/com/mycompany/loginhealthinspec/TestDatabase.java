
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import java.net.InetAddress;
import org.springframework.jdbc.core.JdbcTemplate; 



public class TestDatabase {
    
    
    
    public static void main(String[] args) {
        
        Looca looca = new Looca();
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        
        
        try {
            
        String tipoMaquina = "Totem";
        String nomeMaquina = InetAddress.getLocalHost().getHostName().toString();
        String sistemaOperacional = looca.getSistema().getSistemaOperacional().toString();
        String tempoDeUso = looca.getSistema().getTempoDeAtividade().toString();
        String bits = looca.getSistema().getArquitetura().toString();
        
        con.update("INSERT INTO maquinas VALUES ( ?, ?, ?, ?, ?, ?, ?)",
                null, tipoMaquina, nomeMaquina, sistemaOperacional,
                tempoDeUso, bits, 1);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        // Parametros para o primeiro insert de uma maquina
 
        
        // Inserindo valores na tabela componentes
       
        
        
    }

    
  
}

