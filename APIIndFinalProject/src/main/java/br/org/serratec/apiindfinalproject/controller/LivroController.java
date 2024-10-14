package br.org.serratec.apiindfinalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.apiindfinalproject.domain.Livro;
import br.org.serratec.apiindfinalproject.domain.Publicacao;
import br.org.serratec.apiindfinalproject.repository.LivroRepository;
import br.org.serratec.apiindfinalproject.repository.PublicacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private PublicacaoRepository publicacaoRepository;

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro) {
		Publicacao publicacao = livro.getPublicacao();
		if (publicacao != null) {
			publicacao = publicacaoRepository.save(publicacao);
			livro.setPublicacao(publicacao);
		}

		Livro livroSalvo = livroRepository.save(livro);
		return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livroDetalhes) {
		Optional<Livro> livroOpt = livroRepository.findById(id);

		if (livroOpt.isPresent()) {
			Livro livro = livroOpt.get();
			livro.setTitulo(livroDetalhes.getTitulo());
			livro.setQntPaginas(livroDetalhes.getQntPaginas());
			livro.setPublicacao(livroDetalhes.getPublicacao());
			Livro livroAtualizado = livroRepository.save(livro);
			return ResponseEntity.ok(livroAtualizado);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
