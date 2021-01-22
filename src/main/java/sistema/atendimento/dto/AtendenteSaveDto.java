package sistema.atendimento.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import sistema.atendimento.domain.Atendente;
import sistema.atendimento.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtendenteSaveDto {

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	private String mensagemPadrao;
	
	@NotBlank(message = "O campo usuário é obrigatório")
	private String usuario;
	
	@Size(min = 4, max = 20, message = "Senha deve ter no mínimo 4 e no máximo 20 caracteres")
	@NotBlank(message = "O campo senha é obrigatório")
	private String senha;
	
	@NotNull(message = "O campo role é obrigatório")
	private Role role;
	
	public Atendente converterParaAtendente(){
		return new Atendente(null, this.nome, null, this.mensagemPadrao, null, this.usuario, this.senha, this.role, null);
	}
}
