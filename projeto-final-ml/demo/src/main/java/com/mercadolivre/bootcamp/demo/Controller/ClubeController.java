package com.mercadolivre.bootcamp.demo.Controller;

import com.mercadolivre.bootcamp.demo.model.ClubeModel;
import com.mercadolivre.bootcamp.demo.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demo/clube")
public class ClubeController {

    private final ClubeRepository clubeRepository;

    @Autowired
    public ClubeController(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarClube(@RequestBody ClubeModel clube) {
        try {
            validarDadosClube(clube);
            verificarConflitoNome(clube);

            clubeRepository.save(clube);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DadosInvalidosException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ConflitoNomeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    private void validarDadosClube(ClubeModel clube) throws DadosInvalidosException, ConflitoNomeException {
        if (clube.getNome() == null || clube.getNome().isEmpty()) {
            throw new DadosInvalidosException("Nome do clube é obrigatório.");
        }

        verificarConflitoNome(clube);
    }

    private void verificarConflitoNome(ClubeModel clube) throws ConflitoNomeException {
        Optional<ClubeModel> existingClube = clubeRepository.findByNome(clube.getNome());

        if (existingClube.isPresent()) {
            throw new ConflitoNomeException("Já existe um clube com o nome '" + clube.getNome() + "'.");
        }
    }
}

class DadosInvalidosException extends Exception {
    public DadosInvalidosException(String message) {
        super(message);
    }
}

class ConflitoNomeException extends Exception {
    public ConflitoNomeException(String message) {
        super(message);
    }
}
