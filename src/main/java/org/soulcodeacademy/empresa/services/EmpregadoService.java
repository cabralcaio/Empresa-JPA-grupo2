package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    public List<Empregado> list() {
        return this.empregadoRepository.findAll();
    }

    public Empregado getEmpegado(Integer idEmpregado) {
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if (empregado.isEmpty()) {
            throw new RuntimeException("Empregado não encontrado");
        } else {
            return empregado.get();
        }
    }

    public Empregado salvar(EmpregadoDTO dto) {
       Empregado empregado = new Empregado(null,
               dto.getNome(),
               dto.getEmail(),
               dto.getSalario(),
               dto.getEndereco());

       Empregado salvo = this.empregadoRepository.save(empregado);
       return salvo;
    }

    public Empregado atualizar(Integer idDependente, EmpregadoDTO dto) {
        Empregado empregadoAtual = this.getEmpegado(idDependente);

        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        empregadoAtual.setEndereco(dto.getEndereco());
        return this.empregadoRepository.save(empregadoAtual);
    }

    public void deletar(Integer idEmpregado) {
        Empregado empregado = this.getEmpegado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }



}
