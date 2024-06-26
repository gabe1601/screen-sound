package com.example.alura.screensounds.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGptQuery {

    public static String getInformation (String text){
        OpenAiService service = new OpenAiService("sk-proj-kNnlrrSYZ8pXtfLgOG1zT3BlbkFJpdAqemCN04u9Ez47sby0");


        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-0125")
                .prompt("me fale sobre o artista: " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var answer = service.createCompletion(request);
        return answer.getChoices().get(0).getText();
    }
}
