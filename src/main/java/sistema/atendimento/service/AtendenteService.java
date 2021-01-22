package sistema.atendimento.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.atendimento.domain.Atendente;
import sistema.atendimento.exception.NotFoundException;
import sistema.atendimento.repository.AtendenteRepository;

@Service
public class AtendenteService {

	@Autowired
	private AtendenteRepository atendenteRepository;

	public Atendente save(Atendente atendente) {
		atendente.setCriacao(new Date());
		atendente.setDisponivel(true);

		Atendente createdAtendente = atendenteRepository.save(atendente);
		return createdAtendente;
	}
	
	public Atendente update(Atendente atendente) {
		Atendente updatedAtendente = atendenteRepository.save(atendente);
		return updatedAtendente;
	}
	
	public Atendente getByCodigo(Long codigo){
		Optional<Atendente> result = atendenteRepository.findById(codigo);
		return result.orElseThrow(()-> new NotFoundException("Não existe nenhum atendente com o código = " + codigo));
	}
	
}
