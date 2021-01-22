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
import sistema.atendimento.domain.enums.Role;
import sistema.atendimento.util.HashUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AtendenteRepositoryTests {

	@Autowired
	private AtendenteRepository atendenteRepository;
	
	@Test
	@Order(1)
	public void saveTest() {
		Atendente atendente = new Atendente(null, "Jhonatas", new Date(), "Bem vindo", true, "jhonatas", HashUtil.getSecureHash("senha123"), Role.ADMIN, null);
		Atendente createdAtendente = atendenteRepository.save(atendente);
		
		assertThat(createdAtendente.getCodigo()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		Atendente atendente = new Atendente(1L, "Jhonatas Henrique", new Date(), "Bem vindo", true, "jhonatas", HashUtil.getSecureHash("senha123"), Role.ADMIN, null);
		Atendente createdAtendente = atendenteRepository.save(atendente);
		
		assertThat(createdAtendente.getNome()).isEqualTo("Jhonatas Henrique");
	}
	
	@Test
	public void getByIdTest() {
		Optional<Atendente> result = atendenteRepository.findById(1L);
		Atendente atendente = result.get();
		
		assertThat(atendente.getMensagemPadrao()).isEqualTo("Bem vindo");
	}
}
