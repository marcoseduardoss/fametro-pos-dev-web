package br.edu.unifametro.myproj.v1.xpto.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unifametro.myproj.exception.RecursoNaoEncontradoGlobalException;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;
import br.edu.unifametro.myproj.v1.xpto.repository.RepositorioXpto;

@Service
public class ServicoXpto {

    private final RepositorioXpto repositorioXpto;

    public ServicoXpto(RepositorioXpto repositorioXpto) {
        this.repositorioXpto = repositorioXpto;
    }

    public List<Xpto> listarXptos() {
        Sort ordenacao = Sort.by(Sort.Direction.DESC, "id");
        List<Xpto> xptos = repositorioXpto.findAllOrdered(ordenacao);
        if (xptos.isEmpty()) {
            throw new RecursoNaoEncontradoGlobalException("Nenhuma xpto encontrada.");
        }
        return xptos;
    }

    public Xpto criarXpto(Xpto novaXpto) {
        return repositorioXpto.save(novaXpto);
    }

    public Xpto atualizarXpto(Xpto xpto) {
        assegurarExistenciaXpto(xpto.getId());
        return repositorioXpto.save(xpto);
    }

    public void removerXpto(Xpto xpto) {
        assegurarExistenciaXpto(xpto.getId());
        repositorioXpto.deleteById(xpto.getId());
    }
    
    public Xpto buscarXptoPorId(Long id) {
        return repositorioXpto.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoGlobalException("Xpto com ID " + id + " não encontrada."));
    }

    /**
     * Verifica se uma entidade Xpto existe no repositório pelo ID.
     * Lança uma exceção se a entidade não for encontrada.
     * @param id O identificador da entidade Xpto
     */
    private void assegurarExistenciaXpto(Long id) {
        if (!repositorioXpto.existsById(id)) {
            throw new RecursoNaoEncontradoGlobalException("Xpto com ID " + id + " não encontrada.");
        }
    }
    
}
