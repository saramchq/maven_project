package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_user") // p evitar conflito com a palavra reservada USER
public class User extends myEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, unique = true, length = 150)
	private String email;
	
	@Column(nullable = false, length = 40)
	private String role; // cargo do user
	
	//ids das lojas onde o user trabalha
	@ElementCollection
	private List<Long> storeIds = new ArrayList<>(); // ids das lojas onde o user travbalha

	public User() {

	}

	public User(String name, String email, String role) {
		this.name = name;
		this.email = email;
		setRole(role); //chama o setRole p garantir q ate aqi o valor vem normalizado

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = (role == null) ? null : role.trim().toLowerCase();
		// trim remove os espaços no inicio e fim da string e o tolowercase
		// converte tudo p minusculas
	}

	public List<Long> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
	}

}
