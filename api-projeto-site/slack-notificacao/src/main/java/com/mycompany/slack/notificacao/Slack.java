package com.mycompany.slack.notificacao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Slack {

    // executar execuções http e capturar resposta(se tiver)
    private static HttpClient client = HttpClient.newHttpClient();
    // link do slack
    private static final String url = "https://hooks.slack.com/services/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";

    public static void eviarMensagem(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
    
}
