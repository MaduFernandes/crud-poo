package br.com.oat.resources;

import br.com.oat.model.Aluno;
import br.com.oat.repository.AlunoRepository;
import br.com.oat.config.Message;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoResources implements AlunoRepository{

    Aluno newAluno = new Aluno();

    @Autowired
    AlunoRepository alunoRepository;

    EntityManagerFactory db = Persistence.createEntityManagerFactory("connection");
    EntityManager em = db.createEntityManager();

    public void create() {
        newAluno.setNome("Danilo Ferreira");
        newAluno.setDocumento("44426965004");
        newAluno.setCurso("Sistemas de Informação");
        newAluno.getMatricula();

        em.getTransaction().begin();
        em.persist(newAluno);
        em.getTransaction().commit();

        System.out.println(Message.CADASTRO);

        em.close();
        db.close();
    }

    public void find() {
        newAluno = em.find(Aluno.class, 7);
        System.out.println(newAluno);
    }

    public void update() {

    }

    public void destroy() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("DELETE FROM public.aluno WHERE documento =" + newAluno.getDocumento());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        db.close();
        System.out.println(Message.DELETAR);
    }
}
