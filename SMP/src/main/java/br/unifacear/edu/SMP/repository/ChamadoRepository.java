package br.unifacear.edu.SMP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.unifacear.edu.SMP.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

	Chamado findById(long id);
	
}
