package sistema.atendimento.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "atendente")
public class Atendente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date criacao;

	@Column(name = "mensagem_padrao", columnDefinition = "text")
	private String mensagemPadrao;

	@Column
	private Boolean disponivel;
	
	@Getter(onMethod = @__({@JsonIgnore}))
	@OneToMany(mappedBy = "atendente")
	private List<Solicitacao> solicitacoes;

}
