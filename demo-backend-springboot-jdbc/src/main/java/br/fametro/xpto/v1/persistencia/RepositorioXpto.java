package br.fametro.xpto.v1.persistencia;

import java.util.List;

import br.fametro.xpto.v1.negocio.Xpto;

public interface RepositorioXpto{//Porta de Saída
    Xpto salvarXpto(Xpto xpto);
    Xpto buscarXptoPorId(Long id);
    List<Xpto> listarXptos();
    void atualizarXpto(Xpto xpto);
    void excluirXpto(Xpto xpto);
}
