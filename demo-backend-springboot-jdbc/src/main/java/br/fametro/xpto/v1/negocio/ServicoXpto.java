package br.fametro.xpto.v1.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import br.fametro.xpto.v1.persistencia.RepositorioXpto;

@Service
public class ServicoXpto {

	private RepositorioXpto repositorioXpto;

	public ServicoXpto(RepositorioXpto repositorioXpto) {
		this.repositorioXpto = repositorioXpto;
	}

	public List<Xpto> listarXptos() {
		List<Xpto> xptos = repositorioXpto.listarXptos();
		if (xptos.isEmpty()) {
			throw new NegocioException("Nenhuma xpto encontrada.");
		}
		return xptos;
	}

	public Xpto criarXpto(Xpto novaXpto) {
		return repositorioXpto.salvarXpto(novaXpto);
	}

	public Xpto atualizarXpto(Xpto xpto) {
		repositorioXpto.atualizarXpto(xpto);
		return buscarXptoPorId(xpto.getId());
	}
		
	public void removerXpto(Xpto xpto) {
		Xpto xptoExistente = this.buscarXptoPorId(xpto.getId());
		repositorioXpto.excluirXpto(xptoExistente);
	}
	
	public Xpto buscarXptoPorId(Long id) {
		Xpto xptoExistente = repositorioXpto.buscarXptoPorId(id);
		
		if (xptoExistente == null) {
			throw new NegocioException("Xpto não encontrada.");
		}
		
		return xptoExistente;
	}

}
