package br.org.serratec.apiindfinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.apiindfinalproject.domain.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
}
