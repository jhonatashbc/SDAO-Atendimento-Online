package sistema.atendimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.atendimento.domain.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

	List<Mensagem> findAllByOrderByDataAsc();
	
	List<Mensagem> findAllBySolicitacaoCodigoOrderByDataAsc(Long codigo);
}
