package cevaja.controller;

import cevaja.integration.service.CervejaService;
import cevaja.model.dto.CervejaRequestDTO;
import cevaja.model.dto.CervejaResponseDTO;
import cevaja.model.dto.UsuarioRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cervejas")
public class CervejaController {

    private CervejaService cervejaService;

    public CervejaController(CervejaService cervejaService) {
        this.cervejaService = cervejaService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrarCerveja(@RequestBody CervejaRequestDTO cervejaRequestDTO) {
        cervejaService.cadastrarCerveja(cervejaRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar-cervejas")
    public ResponseEntity<List<CervejaResponseDTO>> buscarTodasCervejas() {
        return ResponseEntity.ok(this.cervejaService.buscarTodasCervejas());
    }
}
