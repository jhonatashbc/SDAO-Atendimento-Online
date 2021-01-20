package sistema.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.atendimento.domain.Solicitacao;
import sistema.atendimento.exception.NotFoundException;
import sistema.atendimento.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;

	public Solicitacao save(Solicitacao solicitacao) {
		Solicitacao createdSolicitacao = solicitacaoRepository
				.save(solicitacao);
		return createdSolicitacao;
	}

	public Solicitacao getByCodigo(Long codigo) {
		Optional<Solicitacao> result = solicitacaoRepository.findById(codigo);
		return result.orElseThrow(() -> new NotFoundException(
				"Solicitação não encontrada com o código = " + codigo));
	}

	public List<Solicitacao> findAll() {
		List<Solicitacao> solicitacoes = solicitacaoRepository
				.findAllByOrderByDataAsc();
		return solicitacoes;
	}
}
