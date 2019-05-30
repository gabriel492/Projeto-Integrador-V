package br.unifacear.edu.SMP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unifacear.edu.SMP.entity.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmpApplicationTests {

	@Test
	public void contextLoads() {
		Pessoa p = new Pessoa();
		p.setNome("gabriel");
		
	}

}
