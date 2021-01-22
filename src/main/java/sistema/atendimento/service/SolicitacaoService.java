package sistema.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sistema.atendimento.domain.Atendente;
import sistema.atendimento.domain.Solicitacao;
import sistema.atendimento.domain.enums.SolicitacaoStatus;
import sistema.atendimento.exception.NotFoundException;
import sistema.atendimento.model.PageModel;
import sistema.atendimento.model.PageRequestModel;
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
	
	public int updateStatusAceita(Atendente atendente, Long codigoSolicitacao) {
		return solicitacaoRepository.updateStatusParaAceita(SolicitacaoStatus.ACEITA, atendente.getCodigo(), codigoSolicitacao);
	}
	
	public int updateStatusFinalizada(Long codigoSolicitacao) {
		return solicitacaoRepository.updateStatusParaFinalizada(SolicitacaoStatus.FINALIZADA, codigoSolicitacao);
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
	
	public PageModel<Solicitacao> findAllOnLazyModel(PageRequestModel pr) {
		Pageable pageable = pr.toSpringPageRequest();
		Page<Solicitacao> page = solicitacaoRepository.findAllByOrderByDataAsc(pageable);
		
		PageModel<Solicitacao> pm = new PageModel<Solicitacao>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		
		return pm;
	}
	
	public PageModel<Solicitacao> findAllAbertaOnLazyModel(PageRequestModel pr) {
		Pageable pageable = pr.toSpringPageRequest();
		Page<Solicitacao> page = solicitacaoRepository.findAllByStatusOrderByDataAsc(SolicitacaoStatus.ABERTA ,pageable);
		
		PageModel<Solicitacao> pm = new PageModel<Solicitacao>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		
		return pm;
	}
	
	public PageModel<Solicitacao> findAllAceitaOnLazyModel(PageRequestModel pr) {
		Pageable pageable = pr.toSpringPageRequest();
		Page<Solicitacao> page = solicitacaoRepository.findAllByStatusOrderByDataAsc(SolicitacaoStatus.ACEITA ,pageable);
		
		PageModel<Solicitacao> pm = new PageModel<Solicitacao>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		
		return pm;
	}
	
	public PageModel<Solicitacao> findAllFinalizadaOnLazyModel(PageRequestModel pr) {
		Pageable pageable = pr.toSpringPageRequest();
		Page<Solicitacao> page = solicitacaoRepository.findAllByStatusOrderByDataAsc(SolicitacaoStatus.FINALIZADA ,pageable);
		
		PageModel<Solicitacao> pm = new PageModel<Solicitacao>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		
		return pm;
	}
}
