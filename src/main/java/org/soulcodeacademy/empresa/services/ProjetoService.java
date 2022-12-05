package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.DTO.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listar() {
        return this.projetoRepository.findAll();
    }

    public Projeto getProjeto(Integer idProjeto) {
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()) {
            throw new RuntimeException("Projeto não encontrado");
        } else {
            return projeto.get();
        }
    }

    public Projeto salvar(ProjetoDTO dto) {
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());
        Projeto projetoSalvo = this.projetoRepository.save(projeto);
        return projetoSalvo;
    }

    public Projeto atualizar(Integer idProjeto, ProjetoDTO dto) {
        // Verificar se o cargo existe mesmo
        Projeto projetoAtual = this.getProjeto(idProjeto);

        projetoAtual.setNome(dto.getNome());
        projetoAtual.setOrcamento(dto.getOrcamento());
        projetoAtual.setDescricao(dto.getDescricao());

        Projeto atualizado = this.projetoRepository.save(projetoAtual);
        return atualizado;
    }

    public void deletar(Integer idProjeto) {
        Projeto projeto = this.getProjeto(idProjeto);
        this.projetoRepository.delete(projeto);
    }
}
