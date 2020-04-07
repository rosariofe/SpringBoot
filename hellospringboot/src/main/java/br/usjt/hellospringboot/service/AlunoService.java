package br.usjt.hellospringboot.service;

import java.util.List;

import br.usjt.hellospringboot.model.Aluno;
import br.usjt.hellospringboot.model.Calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.usjt.hellospringboot.repository.AlunosRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunosRepository alunosRepo;
	@Autowired
	private Calculadora calculadora;

	public void salvar(Aluno aluno) {
		alunosRepo.save(aluno);

	}

	public List<Aluno> listarTodos() {
		List<Aluno> alunos = alunosRepo.findAll();
		for (Aluno aluno : alunos)

			aluno.setMediaFinal(calculadora.calculaMedia(aluno.getNota1(), aluno.getNota2()));
		return alunos;
	}
}