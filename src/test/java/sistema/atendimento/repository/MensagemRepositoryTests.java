package sistema.atendimento.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sistema.atendimento.domain.Mensagem;
import sistema.atendimento.domain.Solicitacao;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class MensagemRepositoryTests {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Test
	@Order(1)
	public void saveTest() {
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setCodigo(2L);
		Mensagem mensagem = new Mensagem(null, "Somente um teste 2", new Date(), "Jhonatas", true, true, solicitacao);
		
		Mensagem createdMensagem = mensagemRepository.save(mensagem);
		
		assertThat(createdMensagem.getCodigo()).isEqualTo(3L);
	}
	
	@Test
	public void getBySolicitacaoCodigo() {
		List<Mensagem> mensagens = mensagemRepository.findAllBySolicitacaoCodigoOrderByDataAsc(2L);
		
		assertThat(mensagens.size()).isEqualTo(1);
	}
}
