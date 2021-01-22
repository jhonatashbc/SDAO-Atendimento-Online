package sistema.atendimento.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sistema.atendimento.domain.Solicitacao;
import sistema.atendimento.domain.enums.SolicitacaoStatus;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

	List<Solicitacao> findAllByOrderByDataAsc();
	
	Page<Solicitacao> findAllByOrderByDataAsc(Pageable pageable);
	
	Page<Solicitacao> findAllByStatusOrderByDataAsc(SolicitacaoStatus status, Pageable pageable);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE solicitacao set status = ?1 AND atendente = 2? WHERE codigo = 3?")
	int updateStatusParaAceita(SolicitacaoStatus status, Long codigoAtendente, Long codigoSolicitacao);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE solicitacao set status = ?1 AND atendente = 2? WHERE codigo = 3?")
	int updateStatusParaFinalizada(SolicitacaoStatus status, Long codigoSolicitacao);

}
