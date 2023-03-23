package br.com.senac.servicos;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Aluno;
import br.com.senac.repositorio.AlunoRepositorio;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepositorio repoAluno;

	public Aluno buscar(Integer id) throws org.hibernate.ObjectNotFoundException {
		Optional<Aluno> objAluno = repoAluno.findById(id);
		return objAluno.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encotrada! Id: " + id + ",  Tipo: ", Aluno.class));
	}
	
	public Aluno inserir(Aluno objAluno) {
		objAluno.setId(null);
		return repoAluno.save(objAluno);
	}
	
	public Aluno alterar(Aluno objAluno) throws org.hibernate.ObjectNotFoundException {
		Aluno objAlunoEncontrado = buscar(objAluno.getId());
		objAlunoEncontrado.setNome(objAluno.getNome());
		return repoAluno.save(objAlunoEncontrado);
	}
	
	public void excluir(Integer id) {
		repoAluno.deleteById(id);
	}
	
	public List<Aluno> listaAlunos() {
		return repoAluno.findAll();
	}
	
}
