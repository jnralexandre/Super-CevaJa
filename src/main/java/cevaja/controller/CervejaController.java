package cevaja.controller;

import cevaja.integration.service.CervejaService;
import cevaja.model.Cerveja;
import cevaja.model.dto.CervejaRequestDTO;
import cevaja.model.dto.CervejaResponseDTO;
import cevaja.model.dto.converter.CervejaConverter;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarCerveja(@RequestBody CervejaRequestDTO cervejaRequestDTO) {
        cervejaService.cadastrarCerveja(cervejaRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar-cervejas")
    public ResponseEntity<List<CervejaResponseDTO>> buscarTodasCervejas() {
        return ResponseEntity.ok(this.cervejaService.buscarTodasCervejas());
    }

    @DeleteMapping("/deletar-usuarios/{type}")
    public ResponseEntity<Void> deletarCervejaPorTipo(@PathVariable("type") String type) {
        this.cervejaService.deletarCervejaPorTipo(type);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CervejaResponseDTO> alterarNomeTipoCervejaPorId(@PathVariable("id") Long id,
                                                                          @RequestBody CervejaRequestDTO cervejaRequestDTO) {
        Cerveja cervejaAlterada = this.cervejaService.alteraPrecoCervejaPorId(id, cervejaRequestDTO);
        return ResponseEntity.ok(CervejaConverter.converterParaDTO(cervejaAlterada));
    }

}
