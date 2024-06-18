package com.mercadolivre.bootcamp.demo.service;

import java.time.LocalDate;
import java.util.List;

public interface PartidaService {
    <Partida> List<Partida> buscarPartidasPorClubeEData(Long idClube, LocalDate data);
    Long IdClube = null, data = null;

    }



