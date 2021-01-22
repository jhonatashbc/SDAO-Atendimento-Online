package sistema.atendimento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.atendimento.domain.Atendente;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtendenteUpdateDto {

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	private String mensagemPadrao;
	
	@NotBlank(message = "O campo usuário é obrigatório")
	private String usuario;
	
	@Size(min = 4, max = 20, message = "Senha deve ter no mínimo 4 e no máximo 20 caracteres")
	@NotBlank(message = "O campo senha é obrigatório")
	private String senha;
	
	public Atendente converterParaAtendente(){
		return new Atendente(null, this.nome, null, this.mensagemPadrao, null, this.usuario, this.senha, null, null);
	}
}
