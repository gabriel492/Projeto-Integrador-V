package br.unifacear.edu.SMP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifacear.edu.SMP.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long>{

	Sala findById(long id);
	
}
