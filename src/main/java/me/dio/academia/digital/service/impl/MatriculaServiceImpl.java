package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private AlunoRepository alRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alRepository.getById(form.getAlunoId());
        matricula.setAluno(aluno);
        return repository.save(matricula);
    }

    @Override
    public void delete(Long id) {
        Matricula matricula = repository.getById(id);
        repository.delete(matricula);
        
    }

    @Override
    public Matricula get(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return repository.findAll();
        }
        else {
            return repository.findByAlunoBairro(bairro);
        }
    }
    
}
