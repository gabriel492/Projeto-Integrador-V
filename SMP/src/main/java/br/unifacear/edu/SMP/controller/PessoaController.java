package br.unifacear.edu.SMP.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unifacear.edu.SMP.entity.Pessoa;
import br.unifacear.edu.SMP.repository.PessoaRepository;

@CrossOrigin(origins = "*")
@RestController
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	
	@GetMapping("/pessoas")
	public List<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	public Pessoa listaPessoaUnico(@PathVariable(value="id") long id){
		return pessoaRepository.findById(id);
	}
	
	
	@PostMapping("/pessoa")
	public Pessoa salvaPessoa(@RequestBody @Valid Pessoa Pessoa) {
		return pessoaRepository.save(Pessoa);
	}
	
	
	@DeleteMapping("/pessoa")
	public void deletaPessoa(@RequestBody @Valid Pessoa Pessoa) {
		pessoaRepository.delete(Pessoa);
	}
	
	
	@PutMapping("/pessoa")
	public Pessoa atualizaPessoa(@RequestBody @Valid Pessoa Pessoa) {
		return pessoaRepository.save(Pessoa);
	}
	 

}
