package br.com.oat.repository;

import br.com.oat.model.Aluno;

import java.util.List;

public interface AlunoRepository {

    void create();
    List<Aluno> findAll();
    void update();
    void destroy();

}
