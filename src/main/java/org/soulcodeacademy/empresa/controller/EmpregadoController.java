package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> empregados() {
        return this.empregadoService.list();
    }

    @GetMapping("/empregado/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado) {
        return this.empregadoService.getEmpegado(idEmpregado);
    }

    @PostMapping("/empregado")
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto) {
        Empregado empregado = this.empregadoService.salvar(dto);
        return empregado;
    }

    @PutMapping("/funcionarios/{idFuncionario}")
    public Empregado atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idFuncionario, dto);
        return atualizado;
    }

    @DeleteMapping("/empregados/{idEmpregado}")
    public void deletar(@PathVariable Integer idFuncionario) {
        this.empregadoService.deletar(idFuncionario);
    }
}
