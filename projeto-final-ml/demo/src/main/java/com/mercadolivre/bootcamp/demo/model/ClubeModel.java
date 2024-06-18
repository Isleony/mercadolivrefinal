package com.mercadolivre.bootcamp.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "clube")
public class ClubeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do clube obrigatório")
    @Size(min = 2, message = "Nome do clube deve ter no mínimo 2 letras")
    private String nome;

    @NotBlank(message = "Sigla do estado obrigatória")
    @Size(min = 2, message = "Sigla do estado deve ter no mínimo 2 letras")
    private String siglaEstado;

    private LocalDate dataCriacao;

    private Boolean ativo;

    public ClubeModel() {
    }

    public ClubeModel(String nome, String siglaEstado, LocalDate dataCriacao, Boolean ativo) {
        this.nome = nome;
        this.siglaEstado = siglaEstado;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isValid() {
        return this.nome != null && !this.nome.isBlank() &&
                this.siglaEstado != null && !this.siglaEstado.isBlank() &&
                this.dataCriacao != null && this.dataCriacao.isBefore(LocalDate.now()) &&
                this.ativo != null;
    }
}
