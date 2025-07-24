package io.altar.jseproject.model;

public abstract class myEntity { //  classe base abstrata que contém atributos e comportamentos comuns para todas as entidades
	private Long id; //id comuim a todas as entidades

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
