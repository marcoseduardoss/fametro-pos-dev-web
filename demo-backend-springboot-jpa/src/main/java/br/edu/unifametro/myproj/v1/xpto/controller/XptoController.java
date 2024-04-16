package br.edu.unifametro.myproj.v1.xpto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifametro.myproj.v1.xpto.dto.XptoDto;
import br.edu.unifametro.myproj.v1.xpto.mapper.XptoDtoMapper;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;
import br.edu.unifametro.myproj.v1.xpto.service.ServicoXpto;

@RestController
@RequestMapping("/v1/xptos")
public class XptoController {

	private final ServicoXpto xptoService;

	public XptoController(ServicoXpto xptoService) {
		this.xptoService = xptoService;
	}

	@GetMapping
	public ResponseEntity<List<XptoDto>> listarTodos() {
		List<Xpto> xptos = xptoService.listarXptos();
		return ResponseEntity.ok(XptoDtoMapper.toDtoList(xptos));
	}

	@GetMapping("/{id}")
	public ResponseEntity<XptoDto> obterPorId(@PathVariable Long id) {
		Xpto xpto = xptoService.buscarXptoPorId(id);
		return ResponseEntity.ok(XptoDtoMapper.toDto(xpto));
	}

	@PostMapping
	public ResponseEntity<XptoDto> criarXpto(@RequestBody XptoDto xptoDto) {
		Xpto xpto = XptoDtoMapper.fromDto(xptoDto);
		Xpto novoXpto = xptoService.criarXpto(xpto);
		return ResponseEntity.status(HttpStatus.CREATED).body(XptoDtoMapper.toDto(novoXpto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarXpto(@PathVariable Long id) {
		xptoService.removerXpto(new Xpto(id));
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<XptoDto> editarXpto(@PathVariable Long id, @RequestBody XptoDto xptoDto) {
		xptoDto.setId(id);
		Xpto xpto = XptoDtoMapper.fromDto(xptoDto);
		Xpto xptoAtualizado = xptoService.atualizarXpto(xpto);
		return ResponseEntity.ok(XptoDtoMapper.toDto(xptoAtualizado));
	}

}
