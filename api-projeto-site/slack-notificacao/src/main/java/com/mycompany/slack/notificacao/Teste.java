
package com.mycompany.slack.notificacao;

import java.io.IOException;
import org.json.JSONObject;


public class Teste {
    
    public static void main(String[] args)throws IOException, InterruptedException {
        JSONObject json = new JSONObject();
        
        json.put("text","Sudo SU! :smile:");
        Slack.eviarMensagem(json);
    }
}
