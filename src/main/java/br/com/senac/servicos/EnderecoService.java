package br.com.senac.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Endereco;
import br.com.senac.repositorio.EnderecoRepositorio;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepositorio repoEndereco;

	public List<Endereco> buscar(Aluno aluno) throws org.hibernate.ObjectNotFoundException {
		List<Endereco> objEndereco = repoEndereco.findByAluno(aluno);
		return objEndereco;
	}
}
