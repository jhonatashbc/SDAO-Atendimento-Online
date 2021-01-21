package sistema.atendimento.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.atendimento.domain.Solicitacao;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

	List<Solicitacao> findAllByOrderByDataAsc();
	
	Page<Solicitacao> findAllByOrderByDataAsc(Pageable pageable);

}
