package lt.viko.eif.astrukcinskas.trecias_pd_pi24sn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApiClientConfig {

    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("https://api.api-ninjas.com")
                .requestInterceptor((request, body, execution) -> {
                    System.out.println("External API request URL: " + request.getURI());
                    System.out.println("External API method: " + request.getMethod());
                    return execution.execute(request, body);
                })
                .build();
    }

}
