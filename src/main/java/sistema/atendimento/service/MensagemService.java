package sistema.atendimento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.atendimento.domain.Mensagem;
import sistema.atendimento.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Mensagem save(Mensagem mensagem){
		Mensagem createdMensagem = mensagemRepository.save(mensagem);
		return createdMensagem;
	}
	
	public List<Mensagem> getBySolicitacaoCodigo(Long codigo){
		List<Mensagem> mensagens = mensagemRepository.findAllBySolicitacaoCodigoOrderByDataAsc(codigo);
		return mensagens;
	}
	
	public List<Mensagem> findAll(){
		List<Mensagem> mensagens = mensagemRepository.findAllByOrderByDataAsc();
		return mensagens;
	}
}
