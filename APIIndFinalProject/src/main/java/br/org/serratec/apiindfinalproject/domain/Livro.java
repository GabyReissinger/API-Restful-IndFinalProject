package br.org.serratec.apiindfinalproject.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank(message = "Título é obrigatório u_u")
	private String titulo;

	@Column
	@NotNull(message = "Quantidade de páginas é obrigatório u_u")
	private Integer qntPaginas;

	@OneToOne
	//@JoinColumn(name = "publicacao_id")
	private Publicacao publicacao;

	public Livro() {
	}

	public Livro(Long id, @NotBlank(message = "Título é obrigatório u_u") String titulo,
			@NotNull(message = "Quantidade de páginas é obrigatório u_u") Integer qntPaginas, Publicacao publicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.qntPaginas = qntPaginas;
		this.publicacao = publicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQntPaginas() {
		return qntPaginas;
	}

	public void setQntPaginas(Integer qntPaginas) {
		this.qntPaginas = qntPaginas;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}