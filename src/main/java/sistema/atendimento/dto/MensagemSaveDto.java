package sistema.atendimento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.atendimento.domain.Mensagem;
import sistema.atendimento.domain.Solicitacao;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MensagemSaveDto {

	@NotBlank(message = "Mensagem não pode estar vazia")
	private String mensagem;

	@NotBlank(message = "Origem é obrigatório")
	private String origem;

	@NotNull(message = "Solicitação é obrigatório")
	private Solicitacao solicitacao;

	public Mensagem converterParaMensagem() {
		return new Mensagem(null, this.mensagem, null, this.origem, null, null, this.solicitacao);
	}
}
