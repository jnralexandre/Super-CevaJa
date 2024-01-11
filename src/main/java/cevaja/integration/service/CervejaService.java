package cevaja.integration.service;

import cevaja.model.Cerveja;
import cevaja.model.dto.CervejaRequestDTO;
import cevaja.model.dto.CervejaResponseDTO;
import cevaja.model.dto.converter.CervejaConverter;
import cevaja.repository.CervejaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CervejaService {

    private CervejaRepository cervejaRepository;

    private static final String MENSAGEM_PARA_TIPO_CERVEJA_EXISTENTE = "O tipo da cerveja já possuí um cadastro no Banco de Dados";
    private static final String MENSAGEM_PARA_TIPO_CERVEJA_INEXISTENTE = "Não é possível deletar uma Cerveja inexistente.";
    private static final String MENSAGEM_PARA_ID_INEXISTENTE = "Não é possível alterar uma Cerveja inexistente.";

    public CervejaService(CervejaRepository cervejaRepository) {
        this.cervejaRepository = cervejaRepository;
    }

    public Cerveja buscarCervejaPorTipo(String type) {
        return cervejaRepository.findByType(type);
    }

    public void cadastrarCerveja(CervejaRequestDTO cervejaRequestDTO) {
        String type = cervejaRequestDTO.getType();
        BigDecimal price = cervejaRequestDTO.getPrice();

        Cerveja cervejaExistentePorTipo = buscarCervejaPorTipo(type);

        if (cervejaExistentePorTipo != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_PARA_TIPO_CERVEJA_EXISTENTE);
        }

        Cerveja cervejaParaAdicionar = CervejaConverter.converterParaEntidade(cervejaRequestDTO);
        cervejaRepository.save(cervejaParaAdicionar);
    }

    public List<CervejaResponseDTO> buscarTodasCervejas() {
        List<Cerveja> listaCerveja = cervejaRepository.findAll();

        List<CervejaResponseDTO> listaCervejasResponseDTO = new ArrayList<>();
        for (Cerveja u : listaCerveja) {
            listaCervejasResponseDTO.add(CervejaConverter.converterParaDTO(u));
        }

        return listaCervejasResponseDTO;
    }

    public void deletarCervejaPorTipo(String type) {
        Cerveja cervejaParaDeletar = cervejaRepository.findByType(type);

        if (cervejaParaDeletar == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_TIPO_CERVEJA_INEXISTENTE
            );
        } else {
            cervejaRepository.delete(cervejaParaDeletar);
        }
    }

    public Cerveja alteraPrecoCervejaPorId(Long id, CervejaRequestDTO cervejaRequestDTO) {
        Optional<Cerveja> cervejaOptionalParaAlterar = cervejaRepository.findById(id);

        if (cervejaOptionalParaAlterar.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_ID_INEXISTENTE
            );
        } else {
            Cerveja cervejaParaAlterar = cervejaOptionalParaAlterar.get();
            BigDecimal price = cervejaRequestDTO.getPrice();

            if (price != null) {
                cervejaParaAlterar.setPrice(price);
            }

            cervejaRepository.save(cervejaParaAlterar);

            return cervejaParaAlterar;
        }

    }

}
