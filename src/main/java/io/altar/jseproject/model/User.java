package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private long id;
	private String name;
	private String email;
	private String role; // cargo do user
	private List<Long> storeIds = new ArrayList<>(); // ids das lojas onde o user travbalha

	public User() {

	}

	public User(long id, String name, String email, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		this.role = role;
	}

	public List<Long> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
	}

}
