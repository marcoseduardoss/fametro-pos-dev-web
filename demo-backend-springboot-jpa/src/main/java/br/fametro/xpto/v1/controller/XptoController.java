package br.fametro.xpto.v1.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fametro.xpto.v1.dto.XptoDto;
import br.fametro.xpto.v1.dto.XptoDtoMapper;
import br.fametro.xpto.v1.model.Xpto;
import br.fametro.xpto.v1.service.ServicoXpto;

@RestController
@RequestMapping("/v1/xptos")
public class XptoController {

	private final ServicoXpto xptoService;

	public XptoController(ServicoXpto xptoService) {
		this.xptoService = xptoService;
	}

	@GetMapping
	public List<XptoDto> listarTodos() {
		List<Xpto> xptos = xptoService.listarXptos();
		return XptoDtoMapper.toDtoList(xptos);
	}
	
	@GetMapping("/{id}")
	public XptoDto obterPorId(@PathVariable Long id) {
		Xpto xpto = xptoService.buscarXptoPorId(id);
		return XptoDtoMapper.toDto(xpto);
	}

//	@GetMapping("/letra/{letra}")
//	public List<XptoDto> listarPorLetraInicial(@PathVariable String letra) {
//		List<Xpto> xptos = xptoService.listarPorLetraInicial(letra);
//		return XptoDtoMapper.toDtoList(xptos);
//	}

//	@GetMapping("/nome/{nome}")
//	public XptoDto buscarPorNome(@PathVariable String nome) {
//		Xpto xpto = xptoService.buscarPorNome(nome);
//		return XptoDtoMapper.toDto(xpto);
//	}

//	@GetMapping("/telefone/{telefone}")
//	public XptoDto buscarPorTelefone(@PathVariable String telefone) {
//		Xpto xpto = xptoService.buscarPorTelefone(telefone);
//		return XptoDtoMapper.toDto(xpto);
//	}

	@PostMapping
	public XptoDto criarXpto(@RequestBody XptoDto xptoDto) {
		Xpto xpto = XptoDtoMapper.fromDto(xptoDto);
		xpto = xptoService.criarXpto(xpto);
		return XptoDtoMapper.toDto(xpto);
	}

	@DeleteMapping("/{id}")
	public void deletarXpto(@PathVariable Long id) {
		xptoService.removerXpto(new Xpto(id));
	}
	
	@PutMapping("/{id}")
	public XptoDto editarXpto(@PathVariable Long id, @RequestBody XptoDto xptoDto) {
		xptoDto.setId(id);
		Xpto xpto = XptoDtoMapper.fromDto(xptoDto);
		Xpto xptoAtualizado = xptoService.atualizarXpto(xpto);
	    return XptoDtoMapper.toDto(xptoAtualizado);
	}

//    @PostMapping("/json/importar")
//    public void importarXptos(@RequestBody List<XptoDto> xptosImportados) {
//        xptoService.importarXptos(XptoDtoMapper.fromDtoList(xptosImportados));
//    }

//	@PostMapping("/csv/importar")
//	public void importarXptos(@RequestParam("file") MultipartFile arquivo) throws IOException {
//		try (BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
//
//			List<XptoDto> xptosDto = new ArrayList<>();
//			String linha;
//
//			for (int numLinha = 1; (linha = reader.readLine()) != null; numLinha++) {
//				// Divida a linha em campos usando a vírgula como delimitador
//
//				String[] campos = linha.split(";");
//				if (numLinha > 1 && campos.length == 3) { // Certifique-se de que há 3 campos: ID, Nome e Telefone
//					String id = campos[0].trim();
//					String nome = campos[1].trim();
//					String telefone = campos[2].trim();
//
//					// Crie um objeto XptoDto com os dados lidos
//					XptoDto xptoDto = new XptoDto();
//					xptoDto.setId(Long.parseLong(id));
//					xptoDto.setNome(nome);
//					xptoDto.setTelefone(telefone);
//					xptosDto.add(xptoDto);
//
//				}
//			}
//
//			// Chame o serviço para importar o xpto
//			xptoService.importarXptos(xptosDto);
//
//		} catch (IOException e) {
//			throw e;
//		}
//	}
//
//	@GetMapping("/csv/exportar")
//	public void exportar(HttpServletResponse response) {
//		response.setContentType("text/csv");
//		response.setHeader("Content-Disposition", "attachment; filename=\"xptos.csv\"");
//
//		List<Xpto> xptos = xptoService.listarTodos();
//
//		try (PrintWriter writer = response.getWriter()) {
//			// Escreve o cabeçalho do CSV
//			writer.println("ID;Nome;Telefone");
//
//			// Escreve os dados dos xptos no CSV
//			for (Xpto xpto : xptos) {
//				writer.println(xpto.getId() + ";" + xpto.getNome() + ";" + xpto.getTelefone());
//			}
//		} catch (IOException e) {
//			// Trate exceções, se necessário
//		}
//	}
}
