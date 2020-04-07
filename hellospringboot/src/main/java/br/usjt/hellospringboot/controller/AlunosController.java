package br.usjt.hellospringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.hellospringboot.model.Aluno;
import br.usjt.hellospringboot.repository.AlunosRepository;
import br.usjt.hellospringboot.service.AlunoService;
@Controller
public class AlunosController {
	//@Autowired
	//private AlunosRepository alunosRepo;
	@Autowired
	private AlunoService alunoService;
	@GetMapping("/alunos")
	public ModelAndView listarAlunos() {
		//PASSANDO O NOME DA PÁG PARA O CONSTRUTOR
		ModelAndView mv = new ModelAndView("lista_alunos");
		//MODELAR FORMULARIO
		mv.addObject(new Aluno());
		// BUSCAR A COLEÇÃO COM O SERVICE
		List<Aluno> alunos = alunoService.listarTodos();
		//ADICONA A COLEÇÃO AO OBJETO MODEL AND VIEW
		mv.addObject("alunos", alunos);
		//DEVOLVE O OBJETO AO MV
		return mv;
	}

	@PostMapping("/alunos")
	public String salvar(Aluno aluno) {
		//SALVANDO COM O SERVICE
		alunoService.salvar(aluno);
		return "redirect:/alunos";
	}

}
