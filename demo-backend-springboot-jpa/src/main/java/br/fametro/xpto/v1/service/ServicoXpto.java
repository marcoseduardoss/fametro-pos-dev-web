package br.fametro.xpto.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.fametro.xpto.v1.model.Xpto;
import br.fametro.xpto.v1.repository.RepositorioXpto;

@Service
public class ServicoXpto {

	private RepositorioXpto repositorioXpto;

	public ServicoXpto(RepositorioXpto repositorioXpto) {
		this.repositorioXpto = repositorioXpto;
	}

	public List<Xpto> listarXptos() {
		List<Xpto> xptos = repositorioXpto.findAll();
		if (xptos.isEmpty()) {
			throw new NegocioException("Nenhuma xpto encontrada.");
		}
		return xptos;
	}

	public Xpto criarXpto(Xpto novaXpto) {
		return repositorioXpto.save(novaXpto);
	}

	public Xpto atualizarXpto(Xpto xpto) {
		repositorioXpto.save(xpto);
		return buscarXptoPorId(xpto.getId());
	}
		
	public void removerXpto(Xpto xpto) {
		//Xpto xptoExistente = this.buscarXptoPorId(xpto.getId());
		repositorioXpto.deleteById(xpto.getId());
	}
	
	public Xpto buscarXptoPorId(Long id) {
        return repositorioXpto.findById(id).orElseThrow(() -> new NegocioException("Xpto não encontrada."));
    }

}
