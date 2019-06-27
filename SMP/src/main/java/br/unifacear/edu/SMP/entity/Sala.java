package br.unifacear.edu.SMP.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="sala")
public class Sala  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	@NotNull
	private Integer numerosala;
	@NotNull
	private String bloco;
	@NotNull
	private String andar;
	@NotNull
	private String imagem;
	
	public Sala() {
	}
	
	public Integer getNumeroSala() {
		return numerosala;
	}
	
    public void setNumerosala(Integer numerosala) {
		this.numerosala = numerosala;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setNumeroSala(Integer numeroSala) {
		this.numerosala = numeroSala;
	}
	
	
	
}
