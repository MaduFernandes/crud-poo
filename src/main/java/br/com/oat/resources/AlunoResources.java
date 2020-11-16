package br.com.oat.resources;

import br.com.oat.model.Aluno;
import br.com.oat.repository.AlunoRepository;

import br.com.oat.config.Message;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoResources {

    @Autowired
    AlunoRepository alunoRepository;

    EntityManagerFactory db = Persistence.createEntityManagerFactory("connection");
    EntityManager em = db.createEntityManager();

    public void create() {
        Aluno newAluno = new Aluno();
        newAluno.setNome("Daniel Ferreira");
        newAluno.setCpf("46766507000");
        newAluno.setCurso("Sistemas de Informação");
        newAluno.getMatricula();

        em.getTransaction().begin();
        em.persist(newAluno);
        em.getTransaction().commit();

        System.out.println(Message.CADASTRO);

        em.close();
        db.close();
    }
}
