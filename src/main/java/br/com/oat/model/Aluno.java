package br.com.oat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String curso;

    @Column
    private String matricula;

    public Aluno(String nome, String cpf, String curso, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.matricula = matricula;
    }

    public Aluno() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        Integer semestre;

        Random valorRandomico = new Random();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar data = Calendar.getInstance();
        if (data.get(Calendar.MONTH) <= 6) {
            semestre = 1;
        } else {
            semestre = 2;
        }
        matricula = dataFormatada.format(data.getTime()) + "-" + valorRandomico.nextInt(99) + "-" + semestre;

        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
