package sistema.atendimento.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.atendimento.domain.Atendente;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoUpdateDto {

	@NotNull(message = "Atendente é obrigatório")
	private Atendente atendente;
}
