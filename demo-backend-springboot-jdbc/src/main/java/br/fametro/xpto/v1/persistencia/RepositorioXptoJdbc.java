package br.fametro.xpto.v1.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import br.fametro.xpto.v1.negocio.Xpto;

@Component
public class RepositorioXptoJdbc implements RepositorioXpto {

	private final Connection conexao;

	public RepositorioXptoJdbc(DataSource dataSource) {
		try {

			this.conexao = dataSource.getConnection();

		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
	}
	
	private Xpto mapearResultadoParaXpto(ResultSet resultado) throws SQLException {
		Long id = resultado.getLong("id");
		String valor1 = resultado.getString("valor1");
		String valor2 = resultado.getString("valor2");
		String valor3 = resultado.getString("valor3");
		return new Xpto(id, valor1, valor2, valor3);
	}

	@Override
	public Xpto salvarXpto(Xpto xpto) {
		String sql = "INSERT INTO xpto (valor1, valor2, valor3) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, xpto.getValor1());
			stmt.setString(2, xpto.getValor2());
			stmt.setString(3, xpto.getValor3()== null ? null : xpto.getValor3().toString());

			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new PersistenciaException("A inserção falhou, nenhum registro foi adicionado.");
			}

			// Recupere o ID gerado para o registro inserido
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					xpto.setId(generatedKeys.getLong(1));
					System.out.printf("[LOG] ID do registro 'inserido': %d!\n", xpto.getId());
				} else {
					throw new PersistenciaException("Nenhum ID gerado.");
				}
			}
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao salvar xpto.", e);
		}
		return xpto;
	}

	@Override
	public Xpto buscarXptoPorId(Long id) {
		String sql = "SELECT * FROM xpto WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setLong(1, id);
			try (ResultSet resultado = stmt.executeQuery()) {
				if (resultado.next()) {
					return mapearResultadoParaXpto(resultado);
				}
			}
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao buscar xpto por ID.", e);
		}
		return null;
	}

	@Override
	public List<Xpto> listarXptos() {
		
		List<Xpto> xptos = new ArrayList<>();
		String sql = "SELECT * FROM xpto ORDER BY id DESC";
		
		try (
				PreparedStatement stmt = conexao.prepareStatement(sql); 
				ResultSet resultado = stmt.executeQuery()
		) {
			
			while (resultado.next()) {
				xptos.add(mapearResultadoParaXpto(resultado));
			}
			
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao listar xptos.", e);
		}
		return xptos;
	}

	@Override
	public void atualizarXpto(Xpto xpto) {
		String sql = "UPDATE xpto SET valor1 = ?, valor2 = ?, valor3 = ? WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, xpto.getValor1());
			stmt.setString(2, xpto.getValor2());
			stmt.setString(3, xpto.getValor3()== null ? null : xpto.getValor3().toString());
			stmt.setLong(4, xpto.getId());
			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new PersistenciaException("A atualização falhou, nenhum registro foi atualizado.");
			}

			System.out.printf("[LOG] ID do registro 'atualizado': %d!\n", xpto.getId());
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao atualizar xpto.", e);
		}
	}

	@Override
	public void excluirXpto(Xpto xpto) {
		String sql = "DELETE FROM xpto WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setLong(1, xpto.getId());
			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new PersistenciaException("A exclusão falhou, nenhum registro foi removido.");
			}

			System.out.printf("[LOG] ID do registro 'removido': %d!\n", xpto.getId());
		} catch (SQLException e) {
			throw new PersistenciaException("Erro ao excluir xpto.", e);
		}
	}
	
}
