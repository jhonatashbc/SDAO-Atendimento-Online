package sistema.atendimento.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "solicitacao")
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(length = 100, nullable = false)
	private String clienteNome;

	@Column(length = 200, nullable = false)
	private String clienteEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "atendente_codigo", nullable = false)
	private Atendente atendente;
	
	@Getter(onMethod = @__({@JsonIgnore}))
	@OneToMany(mappedBy = "solicitacao")
	private List<Mensagem> mensagens;

}
