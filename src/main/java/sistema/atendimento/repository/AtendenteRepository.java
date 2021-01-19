package sistema.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.atendimento.domain.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long>{

}
