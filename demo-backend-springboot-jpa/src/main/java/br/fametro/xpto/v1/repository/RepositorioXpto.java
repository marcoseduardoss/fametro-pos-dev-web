package br.fametro.xpto.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fametro.xpto.v1.model.Xpto;

public interface RepositorioXpto extends JpaRepository<Xpto, Long> {
    // Métodos customizados podem ser declarados aqui
}
