package br.org.serratec.apiindfinalproject.exception;

import java.util.List;

public class ErroResposta {

	private Integer status;
	private String titulo;
	private List<String> erros;

	public ErroResposta(Integer status, String titulo, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.erros = erros;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}