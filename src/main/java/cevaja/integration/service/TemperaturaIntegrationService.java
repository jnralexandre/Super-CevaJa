package cevaja.integration.service;

import cevaja.integration.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TemperaturaIntegrationService {

    private final RestTemplate restTemplate;
    @Value("${wather-integration-api}")
    private String uri;

    public TemperaturaIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WeatherResponse buscarTemperaturaNoServicoExterno() {
        WeatherResponse weatherServicoExterno = this.restTemplate.getForObject(uri, WeatherResponse.class);

        return weatherServicoExterno;
    }

}
