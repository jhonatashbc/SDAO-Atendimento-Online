package sistema.atendimento.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.atendimento.domain.Solicitacao;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoSaveDto {

	@NotBlank(message = "Nome do cliente é obrigatório")
	private String clienteNome;

	@NotBlank(message = "Nome da empresa do cliente é obrigatório")
	private String empresaNome;

	public Solicitacao converterParaSolicitacao() {
		return new Solicitacao(null, null, this.clienteNome, this.clienteNome, null, null, null);
	}
}
