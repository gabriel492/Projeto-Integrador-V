/**
 * 
 */
package br.unifacear.edu.SMP.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

/**
 * @author Gabriel
 *
 */

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	@NotNull
	private String login;
	@NotNull
	private String senha;
	
	public Pessoa() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getlogin() {
		return login;
	}
	public void setlogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
}
