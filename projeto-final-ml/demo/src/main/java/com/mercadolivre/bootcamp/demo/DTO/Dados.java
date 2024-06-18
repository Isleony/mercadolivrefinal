package com.mercadolivre.bootcamp.demo.DTO;

import com.mercadolivre.bootcamp.demo.model.ClubeModel;
import jdk.internal.jimage.BasicImageReader;

public class Dados {

    private BasicImageReader clube;

    private void validarDadosClube(ClubeModel clubeModel) {
        if (clube.getName().length() < 2) {
            throw new DadosInvalidosException("Nome do clube deve ter no mínimo 2 letras.");
        }

    }
}
