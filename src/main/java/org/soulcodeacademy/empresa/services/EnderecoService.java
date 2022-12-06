package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EnderecoDTO;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.exceptions.EnderecoNotFoundException;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
@Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> listar() {
        return this.enderecoRepository.findAll();
    }


    public Endereco getEndereco(Integer idEndereco) {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new EnderecoNotFoundException(idEndereco));
    }

    public Endereco salvar (EnderecoDTO dto){

        Endereco endereco = new Endereco(null, dto.getCidade(), dto.getUf());
        return this.enderecoRepository.save(endereco);
    }

    public Endereco atualizar( Integer idEndereco, EnderecoDTO dto){
        Endereco enderecoAtual = this.getEndereco(idEndereco);

        enderecoAtual.setCidade(dto.getCidade());
        enderecoAtual.setUf(dto.getUf());
        return this.enderecoRepository.save(enderecoAtual);
    }

    public void deletar (Integer idEndereco){
        Endereco endereco = this.getEndereco(idEndereco);
        this.enderecoRepository.delete(endereco);
    }
}
