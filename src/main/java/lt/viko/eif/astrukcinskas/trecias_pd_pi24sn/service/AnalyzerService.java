package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.model.Vehicle.Vehicle;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzerService {

    private final String systemPrompt =
            """
                    You are an electric vehicle evaluator and advisor.
                    Your task is to compare electric cars and advise which car is the better choice.
                    Analyze the cars based on the provided data, such as year, power, acceleration, energy efficiency, battery capacity, charging power, charging speed, and supported charging features.
                    The response must be short, clear, and suitable for an average user.
                    Do not hallucinate. Use only the provided data.
                    """;

    private final ChatClient chatClient;


    public AnalyzerService(ChatClient.Builder builder) {
        this.chatClient =  builder.build();
    }

    public String createCarsAnalysis(List<Vehicle> cars, String userPrompt) throws JsonProcessingException {
        System.out.println(cars);
        ObjectMapper objectMapper = new ObjectMapper();
        String carsJson = objectMapper.writeValueAsString(cars);

        userPrompt = userPrompt + "\n Car details:\n%s";

        String aiResponse = chatClient
                .prompt()
                .system(systemPrompt)
                .user(userPrompt.formatted(carsJson))
                .call()
                .content();

        return aiResponse;
    }
}
