package br.edu.unifametro.myproj.xpto;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unifametro.myproj.v1.xpto.model.Xpto;
import jakarta.persistence.EntityManager;

//comente o @Disabled, caso queira executar este teste
@Disabled("Desabilitado devido à manutenção")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class XptoIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EntityManager entityManager;

	@BeforeEach
	void setup() {
		Xpto xpto = new Xpto(null, "Exemplo", "Descrição do exemplo", LocalDateTime.now());
		entityManager.persist(xpto);
		entityManager.flush(); // Força a persistência antes do teste
	}

	@Test
	void testListarTodos() throws Exception {
		mockMvc.perform(get("/v1/xptos")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
				.andExpect(jsonPath("$[0].id", greaterThanOrEqualTo(1)))
				.andExpect(jsonPath("$[0].valor1", is("Exemplo")));

	}

	@Test
	void testObterPorId() throws Exception {
		mockMvc.perform(get("/v1/xptos/1")).andExpect(status().isOk()).andExpect(jsonPath("$.valor1", is("Exemplo")));
	}

	@Test
	void testCriarXpto() throws Exception {
		String novoXptoJson = "{\"valor1\":\"Novo Exemplo\",\"valor2\":\"Descrição Novo Exemplo\",\"valor3\":\"2023-04-16T15:00:00\"}";
		mockMvc.perform(post("/v1/xptos").contentType(MediaType.APPLICATION_JSON).content(novoXptoJson))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.valor1", is("Novo Exemplo")));
	}

	@Test
	void testEditarXpto() throws Exception {
		String atualizadoXptoJson = "{\"valor1\":\"Atualizado\",\"valor2\":\"Atualizado Desc\",\"valor3\":\"2023-04-16T16:00:00\"}";
		mockMvc.perform(put("/v1/xptos/1").contentType(MediaType.APPLICATION_JSON).content(atualizadoXptoJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.valor1", is("Atualizado")));
	}

	@Test
	void testDeletarXpto() throws Exception {
		mockMvc.perform(delete("/v1/xptos/1")).andExpect(status().isNoContent());
	}
}
