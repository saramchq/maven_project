package io.altar.jseproject.model;

import java.io.Serializable;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // classe modelo p outras entidades
public abstract class myEntity implements Serializable {
	private static final long serialVersionUID = 1L; 
	//garante compatibilidade na serialização qnd um obj é convertido em bytes p ser armazenado ou enviado

	@Id //indica q este campo é primary key no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//faz c q o banco gere o valor do id automaticamente c auto incremento
	private Long id; //pk p todas as entidades q herdarem desta classe
	
	//getter p id
	public Long getId() {
		return id;
	}
	
	//setter p id
	public void setId(Long id) {
		this.id = id;
	}
}
