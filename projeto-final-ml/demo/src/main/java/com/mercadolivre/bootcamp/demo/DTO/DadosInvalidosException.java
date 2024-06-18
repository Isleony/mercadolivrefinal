package com.mercadolivre.bootcamp.demo.DTO;

public class DadosInvalidosException extends RuntimeException {
    public DadosInvalidosException(String message) {
        super(message);
    }
    public class Validador {

        public void validarDados(String dados) {
            if (dados == null || dados.isEmpty()) {
                throw new DadosInvalidosException("Nome do clube deve ter no mínimo 2 letras.");
            }

        }

        public void main(String[] args) {
            Validador validador = new Validador();
            try {
                validador.validarDados(null);
            } catch (DadosInvalidosException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

}


