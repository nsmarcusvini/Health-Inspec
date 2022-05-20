/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.slack.notificacao;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;

/**
 *
 * @author nsmar
 */
public class AlertsSlack {
        
    Looca looca = new Looca();
    SlackIntegrationTest sendMsg = new SlackIntegrationTest();
    
    
    Double ram = looca.getMemoria().getTotal() / 1073741824.0;
    Double disco = looca.getGrupoDeDiscos().getTamanhoTotal() / 1073741824.0;
    
   
        
            
}
