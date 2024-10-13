package br.org.serratec.apiindfinalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.apiindfinalproject.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
