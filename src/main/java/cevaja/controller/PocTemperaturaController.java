package cevaja.controller;


import cevaja.integration.response.WeatherResponse;
import cevaja.integration.service.TemperaturaIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/temperatura")
public class PocTemperaturaController {

    private TemperaturaIntegrationService temperaturaIntegrationService;

    public PocTemperaturaController(TemperaturaIntegrationService temperaturaIntegrationService) {
        this.temperaturaIntegrationService = temperaturaIntegrationService;
    }

    @GetMapping
    public ResponseEntity<WeatherResponse> buscarTemperatura() {
        WeatherResponse temperaturaBuscadaServicoExterno = this.temperaturaIntegrationService.buscarTemperaturaNoServicoExterno();
        return ResponseEntity.ok(temperaturaBuscadaServicoExterno);
    }

}
