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
import br.unifacear.edu.SMP.entity.Chamado;
import br.unifacear.edu.SMP.repository.ChamadoRepository;

@CrossOrigin(origins = "*")
@RestController
public class ChamadoController {
	
	
	@Autowired
	ChamadoRepository chamadoRepository;
	
	
	@GetMapping("/chamados")
	public List<Chamado> listachamados(){
		return chamadoRepository.findAll();
	}
	
	@GetMapping("/chamado/{id}")
	public Chamado listachamadoUnico(@PathVariable(value="id") long id){
		return chamadoRepository.findById(id);
	}
	
	
	@PostMapping("/chamado")
	public Chamado salvachamado(@RequestBody @Valid Chamado chamado) {
		return chamadoRepository.save(chamado);
	}
	
	
	@DeleteMapping("/chamado")
	public void deletachamado(@RequestBody @Valid Chamado chamado) {
		chamadoRepository.delete(chamado);
	}
	
	
	@PutMapping("/chamado")
	public Chamado atualizachamado(@RequestBody @Valid Chamado chamado) {
		return chamadoRepository.save(chamado);
	}
}
