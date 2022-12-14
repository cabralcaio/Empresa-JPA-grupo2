package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.DTO.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> listar() {
        return  this.enderecoService.listar();
    }

    @GetMapping("/enderecos/{idEndereco}")
    public  Endereco getEndereco (@PathVariable Integer idEndereco){
        return  this.enderecoService.getEndereco(idEndereco);
    }

    @PostMapping("/endereco")
    public Endereco salvar(@Valid @RequestBody EnderecoDTO dto){
        Endereco endereco = this.enderecoService.salvar(dto);
        return endereco;
    }

    @PutMapping("/endereco/{idEndereco}")
    public Endereco  atualizar(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO dto){
        Endereco atualizado = this.enderecoService.atualizar(idEndereco, dto);
        return atualizado;
    }

    @DeleteMapping("/endereco/{idCliente}")
    public void deletar (@PathVariable Integer idEndereco){
        this.enderecoService.deletar(idEndereco);
    }
}
