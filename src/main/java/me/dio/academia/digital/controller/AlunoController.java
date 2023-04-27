package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return service.getAll(dataDeNascimento);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @GetMapping("/{id}/avaliacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id) {
        return service.getAllAvaliacaoFisica(id);
    }

}
