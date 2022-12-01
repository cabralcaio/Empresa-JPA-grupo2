package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;

public class DependenteDTO {

    @NotBlank(message = "Esse campo é obrigatório.")
    private String nome;
    @NotBlank(message = "Esse campo é obrigatório.")
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
