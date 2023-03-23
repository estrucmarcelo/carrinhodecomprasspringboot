package br.com.senac.servicos;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Pedido;
import br.com.senac.repositorio.PedidoRepositorio;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepositorio repoPedido;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> objPedido = repoPedido.findById(id);
		return objPedido.orElseThrow(() -> new ObjectNotFoundException("Pedido",Pedido.class));
	}
	
	public Pedido inserir(Pedido objPedido) {
		objPedido.setId(null);
		return repoPedido.save(objPedido);
	}
	
//	public Pedido alterar(Pedido objPedido) throws ObjectNotFoundException {
//		Pedido objPedidoEncontrado = buscar(objPedido.getId());
//		objPedidoEncontrado.setNome(objPedido.getNome());
//		return repoAluno.save(objPedidoEncontrado);
//	}
	
	public void excluir(Integer id) {
		repoPedido.deleteById(id);
	}
	
	public List<Pedido> listaPedidos() {
		return repoPedido.findAll();
	}
	
}
