package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.DTO.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empregados")
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping
    public List<Empregado> empregados() {
        return this.empregadoService.list();
    }

    @GetMapping("/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado) {
        return this.empregadoService.getEmpegado(idEmpregado);
    }

    @PostMapping
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto) {
        Empregado empregado = this.empregadoService.salvar(dto);
        return empregado;
    }

    @PutMapping("/{idEmpregado}")
    public Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idEmpregado, dto);
        return atualizado;
    }

    @DeleteMapping("/{idEmpregado}")
    public void deletar(@PathVariable Integer idEmpregado) {
        this.empregadoService.deletar(idEmpregado);
    }
}
