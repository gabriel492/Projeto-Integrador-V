package br.unifacear.edu.SMP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifacear.edu.SMP.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findById(long id);
	
}
