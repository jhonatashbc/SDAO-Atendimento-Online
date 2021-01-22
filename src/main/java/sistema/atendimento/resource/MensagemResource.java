package sistema.atendimento.resource;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema.atendimento.domain.Mensagem;
import sistema.atendimento.dto.MensagemSaveDto;
import sistema.atendimento.service.MensagemService;

@RestController
@RequestMapping(value = "mensagem")
public class MensagemResource {

	@Autowired
	private MensagemService mensagemService;

	@PostMapping
	public ResponseEntity<Mensagem> save(@RequestBody @Valid MensagemSaveDto mensagemDto) {
		Mensagem mensagem = mensagemDto.converterParaMensagem();
		mensagem.setData(new Date());
		mensagem.setEnviado(true);
		mensagem.setRecebido(false);

		Mensagem createdMensagem = mensagemService.save(mensagem);

		return ResponseEntity.status(HttpStatus.CREATED).body(createdMensagem);
	}
}
