package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.DTO.DependenteDTO;
import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> depedentes(){
        return this.dependenteService.listarTodos();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return this.dependenteService.getDependente(idDependente);
    }

    @PostMapping("/dependentes")
    public Dependente salvarDependente(@Valid @RequestBody DependenteDTO dependenteDTO){
        return this.dependenteService.salvar(dependenteDTO);
    }

    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizarDependente(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dependenteDTO){
        return this.dependenteService.atualizar(idDependente, dependenteDTO);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public void deletar(@PathVariable Integer idDependente){
        this.dependenteService.deleltar(idDependente);
    }
}
