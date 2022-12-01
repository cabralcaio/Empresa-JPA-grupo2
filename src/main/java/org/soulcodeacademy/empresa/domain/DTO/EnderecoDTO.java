package org.soulcodeacademy.empresa.domain.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class EnderecoDTO {

    @NotBlank( message = "Campo cidade é obrigatorio")
    private  String cidade;

    @NotBlank(message = "Campo UF é obrigatorio")
    private  String uf;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
