package br.edu.unifametro.myproj.v1.xpto.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unifametro.myproj.v1.xpto.model.Xpto;

/**
 * Interface de repositório para a entidade Xpto.
 * Esta interface estende JpaRepository, fornecendo métodos CRUD padrão para a entidade Xpto.
 */
public interface RepositorioXpto extends JpaRepository<Xpto, Long> {

    /**
     * Retorna todos os registros da entidade Xpto ordenados de acordo com a ordenação especificada.</br></br><b>
     *
     * Exemplo de uso:											</br></b>
     *  Sort ordenacao = Sort.by(Sort.Direction.DESC, "id");	</br>
     *  return repositorioXpto.findAllOrdered(ordenacao);
     *  
     *  </br></br>
     * @param ordenacao o tipo de ordenação a ser aplicado
     * @return uma lista de objetos Xpto ordenados de acordo com a ordenação especificada
     */
    @Query("SELECT x FROM Xpto x")//query jpql
    List<Xpto> findAllOrdered(Sort ordenacao);
}
