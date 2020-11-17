package br.com.oat.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository {

    void create();
    void find();
    void update();
    void destroy();

}
