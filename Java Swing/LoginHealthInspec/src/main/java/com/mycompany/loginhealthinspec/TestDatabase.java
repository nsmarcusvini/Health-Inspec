
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import org.springframework.jdbc.core.JdbcTemplate; 


public class TestDatabase {
    
    public static void main(String[] args) {
        
        Looca looca = new Looca();
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        
        // Parametros para o primeiro insert
        String processador = looca.getProcessador().getNome().toString();
        String so = looca.getSistema().getSistemaOperacional().toString();
        String regi = looca.getSistema().getTempoDeAtividade().toString();
        
        // Inserindo valores na tabela
        con.update("INSERT INTO registros VALUES ( ?, ?, ?, ?)",
                null, processador, so, regi);
        
        
    }
    
    
}
