package sistema.atendimento.resource;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.atendimento.domain.Solicitacao;
import sistema.atendimento.domain.enums.SolicitacaoStatus;
import sistema.atendimento.dto.SolicitacaoSaveDto;
import sistema.atendimento.dto.SolicitacaoUpdateDto;
import sistema.atendimento.service.SolicitacaoService;

@RestController
@RequestMapping(value = "solicitacao")
public class SolicitacaoResource {

	@Autowired
	private SolicitacaoService solicitacaoService;

	@PostMapping
	public ResponseEntity<Solicitacao> save(@RequestBody @Valid SolicitacaoSaveDto solicitacaoDto) {
		Solicitacao solicitacao = solicitacaoDto.converterParaSolicitacao();
		solicitacao.setData(new Date());
		solicitacao.setStatus(SolicitacaoStatus.ABERTA);

		Solicitacao createdSolicitacao = solicitacaoService.save(solicitacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSolicitacao);
	}

	@PatchMapping("/{codigo}/aceita")
	public ResponseEntity<?> updateStatusAceita(@RequestBody @Valid SolicitacaoUpdateDto solicitacaoDto,
			@PathVariable(name = "codigo") Long codigo) {
		solicitacaoService.updateStatusAceita(solicitacaoDto.getAtendente(), codigo);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/{codigo}/finalizada")
	public ResponseEntity<?> updateStatusFinalizada(@PathVariable(name = "codigo") Long codigo) {
		solicitacaoService.updateStatusFinalizada(codigo);
		return ResponseEntity.ok().build();
	}
	
	//findallaberta
	
	//findallaceita
	
	//findallfinalizada
	
	//findallcodigo

}
