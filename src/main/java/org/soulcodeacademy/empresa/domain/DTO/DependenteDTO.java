package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.NotBlank;

public class DependenteDTO {

    @NotBlank(message = "Esse campo é obrigatório.")
    private String nome;
    @NotBlank(message = "Esse campo é obrigatório.")
    private String idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
