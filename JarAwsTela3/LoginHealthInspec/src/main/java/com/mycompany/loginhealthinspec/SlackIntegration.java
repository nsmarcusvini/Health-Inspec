/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginhealthinspec;

import com.github.britooo.looca.api.core.Looca;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SlackIntegration {
    Looca looca = new Looca();
   
    

    private static String webHookUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-3482532505233-3523046039027-MbPFejOnM6mGpr7dk4IKTOWK";
    private static String slackChannel = "projeto-agilidade-de-processos";

    public static void sendMessageToSlack(String message) {

        try {

            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(webHookUrl, payload);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

