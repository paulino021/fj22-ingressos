package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {
	
	public Permissao() {
		
	}
	
	@Id
	private String nome;
	
	
	public Permissao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		
		return nome;
	}
	
	
	

}
