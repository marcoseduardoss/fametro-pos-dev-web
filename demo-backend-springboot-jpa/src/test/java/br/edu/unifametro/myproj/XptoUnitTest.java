package br.edu.unifametro.myproj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifametro.myproj.v1.xpto.exception.ValorOuRecursoNaoEncontradoException;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;
import br.edu.unifametro.myproj.v1.xpto.repository.RepositorioXpto;
import br.edu.unifametro.myproj.v1.xpto.service.ServicoXpto;

//comente esta linha, caso queira executar este teste
//@Disabled("Desabilitado devido à manutenção")
@SpringBootTest
class XptoUnitTest {

	@Mock
	private RepositorioXpto repositorioXpto;

	private ServicoXpto servicoXpto;

	private AutoCloseable closeable;

	@BeforeEach
	void setUp() {

		closeable = MockitoAnnotations.openMocks(this);
		MockitoAnnotations.openMocks(this);
		servicoXpto = new ServicoXpto(repositorioXpto); // Injeção manual do mock

		// Configure o comportamento esperado do mock com BDDMockito
		List<Xpto> expectedList = new ArrayList<>();
		expectedList.add(new Xpto(1L, "Teste", "Descrição Teste", LocalDateTime.now()));
		given(repositorioXpto.findAllOrdered(any(Sort.class))).willReturn(expectedList);
	}

	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	void quandoListarXptos_entaoDeveriaRetornarLista() {
		List<Xpto> result = servicoXpto.listarXptos();
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getValor1()).isEqualTo("Teste");
	}

	@Test
	void quandoBuscarXptoPorId_entaoDeveriaRetornarXpto() {
	    // Criação do objeto Xpto esperado.
	    Xpto expectedXpto = new Xpto(1L, "Teste", "Descrição Teste", LocalDateTime.now());

	    // Configuração do mock para retornar o Xpto esperado quando o método findById for chamado com o ID 1L.
	    given(repositorioXpto.findById(1L)).willReturn(Optional.of(expectedXpto));

	    // Ação de buscar o Xpto por ID.
	    Xpto result = servicoXpto.buscarXptoPorId(1L);

	    // Verificação se o resultado possui o valor1 igual a "Teste".
	    assertThat(result.getValor1()).isEqualTo("Teste");
	}


	@Test
	void quandoCriarXpto_entaoDeveriaPersistir() {
		Xpto novoXpto = new Xpto(null, "Novo Teste", "Nova Descrição", LocalDateTime.now());
		when(repositorioXpto.save(any(Xpto.class))).thenReturn(novoXpto);

		Xpto result = servicoXpto.criarXpto(novoXpto);

		assertThat(result).isNotNull();
		assertThat(result.getValor1()).isEqualTo("Novo Teste");
	}

	@Test
	void quandoAtualizarXpto_entaoDeveriaRetornarXptoAtualizado() {
		Xpto existenteXpto = new Xpto(1L, "Teste", "Descrição Teste", LocalDateTime.now());
		Xpto atualizadoXpto = new Xpto(1L, "Atualizado", "Descrição Atualizada", LocalDateTime.now());

		// Configure o mock para retornar o Xpto existente quando o findById for
		// chamado.
		given(repositorioXpto.findById(1L)).willReturn(Optional.of(existenteXpto));

		// Configure o mock para retornar o Xpto atualizado quando o save for chamado.
		given(repositorioXpto.save(any(Xpto.class))).willReturn(atualizadoXpto);

		Xpto result = servicoXpto.atualizarXpto(atualizadoXpto);

		assertThat(result.getValor1()).isEqualTo("Atualizado");
	}

	@Test
	void quandoDeletarXpto_entaoDeveriaRemover() {
		// Criação do objeto Xpto existente.
		Xpto existenteXpto = new Xpto(1L, "Teste", "Descrição Teste", LocalDateTime.now());

		// Configuração do mock para retornar o Xpto existente quando o método findById
		// for chamado com o ID 1L.
		given(repositorioXpto.findById(1L)).willReturn(Optional.of(existenteXpto));

		// Ação de deletar o Xpto.
		servicoXpto.removerXpto(new Xpto(1L));

		// Verificação se o método deleteById foi chamado uma vez com o ID 1L.
		verify(repositorioXpto, times(1)).deleteById(1L);
	}

	@Test
	void quandoBuscarXptoPorIdNaoExistente_entaoDeveriaLancarExcecao() {
		when(repositorioXpto.findById(anyLong())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> servicoXpto.buscarXptoPorId(2L)).isInstanceOf(ValorOuRecursoNaoEncontradoException.class)
				.hasMessageContaining("Xpto nao encontrada.");
	}
}
