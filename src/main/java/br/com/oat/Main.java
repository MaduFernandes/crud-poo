package br.com.oat;

import br.com.oat.model.Aluno;
import br.com.oat.resources.AlunoResources;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlunoResources aluno = new AlunoResources();
        aluno.create();

        List<Aluno> alunos = aluno.findAll();

        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("ID: " + alunos.get(i).getId() + "\nNome: " + alunos.get(i).getNome() +
                    " \nMatricula: " + alunos.get(i).getMatricula() + "\nCurso: " + alunos.get(i).getCurso());
        }
        /*aluno.update();*/
        aluno.destroy();
    }
}
