package br.unifacear.edu.SMP.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
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
import br.unifacear.edu.SMP.entity.Sala;
import br.unifacear.edu.SMP.repository.SalaRepository;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@CrossOrigin(origins = "*")
@RestController
public class SalaController {
	
	@Autowired
	SalaRepository salarepository;
	
	@GetMapping("/salas")
	public List<Sala> listarSala(){
		return salarepository.findAll();
	}
	
	@GetMapping("/sala/{id}")
	public Sala listarSalaId(@PathVariable(value="id")long id) {
		return salarepository.findById(id);
	}
	
	@GetMapping("/sala/{select}/{menssage}")
	public List<Sala> listarSalaFiltro(@PathVariable(value="select")String select,@PathVariable(value="menssage")String str) {
		salarepository.findAll();
		List<Sala> list = new ArrayList<Sala>();
		if(select.equals("1")) {
			for (Sala sala : salarepository.findAll()) {
				Integer n1 = Integer.parseInt(str);
				if(sala.getNumeroSala() == n1) {
					list.add(sala);
					return list;				
				}	
			}
			
		}else if(select.equals("2")) {
			for (Sala sala : salarepository.findAll()) {				
				if(sala.getAndar().equals(str)) {
					list.add(sala);
									
				}	
			}
			return list;
		}else if(select.equals("3")) {
			for (Sala sala : salarepository.findAll()) {
				if(sala.getBloco().equals(str)) {
					list.add(sala);
									
				}	
			}
			return list;	
		}
		return null;
	}
	
	@PostMapping("/sala")
	public void salvar(@RequestBody Sala sala) {
		int size = 256;
		int cont = 0;
		cont = salarepository.findAll().size();
		cont = cont +1;
		System.out.println(cont);
		try {
			 OutputStream f = new FileOutputStream("C:\\www\\smries\\src\\assets\\sala"+sala.getNumeroSala()+".png");
		
			 ByteArrayOutputStream out = QRCode.from(""+cont)
						.to(ImageType.PNG)
						.withSize(size, size)
						.stream();
			
			String encodedFile = Base64.getEncoder().encodeToString(out.toByteArray());
			sala.setImagem(encodedFile);
			f.write(out.toByteArray());
			
			f.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		salarepository.save(sala);
	}
	
	@DeleteMapping("/sala")
	public void deletar(@RequestBody @Valid Sala sala) {
		salarepository.delete(sala);
	}
	
	@PutMapping("/sala")
	public Sala atualizaSala(@RequestBody @Valid Sala sala) {
		return salarepository.save(sala);
	}
	
	
}
