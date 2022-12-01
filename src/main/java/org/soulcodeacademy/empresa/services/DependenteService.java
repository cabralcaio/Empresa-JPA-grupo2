package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.DTO.DependenteDTO;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

        @Autowired
        private DependenteRepository dependenteRepository;

        public List<Dependente> listarTodos() {
                return this.dependenteRepository.findAll();
        }

        public Dependente getDependente(Integer idDependente) {
                Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

                if (dependente.isEmpty()) {
                        throw new RuntimeException("Dependente não encontrado!");
                } else {
                        return dependente.get();
                }
        }

        public Dependente salvar(DependenteDTO dto) {
                Dependente novoDependente = new Dependente(null, dto.getNome(), dto.getIdade());
                return this.dependenteRepository.save(novoDependente);
        }

        public Dependente atualizar(Integer idDependente, DependenteDTO dto) {
                Dependente dependenteAtual = this.getDependente(idDependente);
                dependenteAtual.setNome(dto.getNome());
                dependenteAtual.setIdade(dto.getIdade());
                return this.dependenteRepository.save(dependenteAtual);
        }

        public void deleltar(Integer idDependente) {
                Dependente dependente = this.getDependente(idDependente);
                this.dependenteRepository.delete(dependente);
        }


}
