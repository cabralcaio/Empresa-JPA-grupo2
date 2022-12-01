package org.soulcodeacademy.empresa.domain.DTO;

import org.soulcodeacademy.empresa.domain.Endereco;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EmpregadoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigaótio")
    private String email;

    @NotBlank(message = "Salario é obritório" )
    @Min(value = 1200, message = "Salario obrigatório")
    @Max(value = 30000, message = "Salario obrigatório")
    private Double salario;

    @NotBlank(message = "Endereço é obrigtório")
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
