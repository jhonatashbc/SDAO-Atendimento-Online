package sistema.atendimento.resource;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.atendimento.domain.Atendente;
import sistema.atendimento.dto.AtendenteSaveDto;
import sistema.atendimento.dto.AtendenteUpdateDto;
import sistema.atendimento.service.AtendenteService;

@RestController
@RequestMapping(value = "atendente")
public class AtendenteResource {

	@Autowired
	private AtendenteService atendenteService;

	@PostMapping
	public ResponseEntity<Atendente> save(
			@RequestBody @Valid AtendenteSaveDto atendenteDto) {
		Atendente atendente = atendenteDto.converterParaAtendente();
		atendente.setCriacao(new Date());
		atendente.setDisponivel(true);

		Atendente createdAtendente = atendenteService.save(atendente);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAtendente);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Atendente> update(
			@PathVariable(name = "codigo") Long codigo,
			@RequestBody @Valid AtendenteUpdateDto atendenteDto) {
		Atendente atendente = atendenteDto.converterParaAtendente();
		atendente.setCodigo(codigo);

		Atendente updatedAtendente = atendenteService.save(atendente);

		return ResponseEntity.ok(updatedAtendente);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Atendente> getById(@PathVariable(name = "codigo") Long codigo){
		Atendente atendente = atendenteService.getByCodigo(codigo);
		
		return ResponseEntity.ok(atendente);
	}
}
