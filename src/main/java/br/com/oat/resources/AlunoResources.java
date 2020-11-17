package br.com.oat.resources;

import br.com.oat.model.Aluno;
import br.com.oat.repository.AlunoRepository;
import br.com.oat.config.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class AlunoResources implements AlunoRepository{

    Aluno newAluno = new Aluno();

    EntityManagerFactory db = Persistence.createEntityManagerFactory("connection");
    EntityManager em = db.createEntityManager();

    public void create() {
        newAluno.setNome("Michel Douglas");
        newAluno.setDocumento("68578012201");
        newAluno.setCurso("Sistemas de Informação");
        newAluno.getMatricula();

        em.getTransaction().begin();
        em.persist(newAluno);
        em.getTransaction().commit();

        System.out.println(Message.CADASTRO);

        em.close();
        db.close();
    }

    public List<Aluno> findAll() {
        em.getTransaction().begin();
        Query consultar = em.createQuery("SELECT aluno FROM Aluno aluno");
        List listar = consultar.getResultList();
        em.close();
        return listar;
    }

    public void update() {

    }

    public void destroy() {
        em.getTransaction().begin();
        Aluno excluirAluno = em.find(Aluno.class, 1);
        em.remove(excluirAluno);
        em.getTransaction().commit();
        System.out.println(Message.DELETAR);
    }
}
