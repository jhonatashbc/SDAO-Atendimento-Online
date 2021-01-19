package sistema.atendimento.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sistema.atendimento.domain.Atendente;
import sistema.atendimento.domain.Solicitacao;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class SolicitacaoRepositoryTests {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	@Test
	@Order(1)
	public void saveTest() {
		Atendente atendente = new Atendente();
		atendente.setCodigo(1L);
		Solicitacao solicitacao = new Solicitacao(null, new Date(), "Juliana", "Sao Judas", atendente, null);
		
		Solicitacao createdSolicitacao = solicitacaoRepository.save(solicitacao);
		
		assertThat(createdSolicitacao.getCodigo()).isEqualTo(1L);
	}
	
	@Test
	public void getByIdTest() {
		Optional<Solicitacao> result = solicitacaoRepository.findById(2L);
		Solicitacao solicitacao = result.get();
		
		assertThat(solicitacao.getClienteEmpresa()).isEqualTo("Sao Judas");
	}
	
}
