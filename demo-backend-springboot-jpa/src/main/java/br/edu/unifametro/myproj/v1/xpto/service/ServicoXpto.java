package br.edu.unifametro.myproj.v1.xpto.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unifametro.myproj.v1.xpto.exception.ValorOuRecursoNaoEncontradoException;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;
import br.edu.unifametro.myproj.v1.xpto.repository.RepositorioXpto;

@Service
public class ServicoXpto {

	private RepositorioXpto repositorioXpto;

	public ServicoXpto(RepositorioXpto repositorioXpto) {
		this.repositorioXpto = repositorioXpto;
	}

	public List<Xpto> listarXptos() {
		Sort ordenacao = Sort.by(Sort.Direction.DESC, "id");
		List<Xpto> xptos = repositorioXpto.findAllOrdered(ordenacao);
		if (xptos.isEmpty()) {// lanca excecao se nao existir
			throw new ValorOuRecursoNaoEncontradoException("Nenhuma xpto encontrada.");
		}
		return xptos;
	}

	public Xpto criarXpto(Xpto novaXpto) {
		return repositorioXpto.save(novaXpto);
	}

	public Xpto atualizarXpto(Xpto xpto) {
		buscarXptoPorId(xpto.getId());// lanca excecao se nao existir
		return repositorioXpto.save(xpto);// atualiza objeto nao nulo

	}

	public void removerXpto(Xpto xpto) {
		buscarXptoPorId(xpto.getId());// lanca excecao se nao existir
		repositorioXpto.deleteById(xpto.getId());// remove se id nao nulo
	}

	public Xpto buscarXptoPorId(Long id) {
		return repositorioXpto.findById(id).orElseThrow(() -> new ValorOuRecursoNaoEncontradoException("Xpto nao encontrada."));
	}

}
