package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "store")
public class Store extends myEntity {
	
	private static final long serialVersionUID = 1L;
	
	//private long id;
	private String name;
	
	@ElementCollection
	private List<Long> userIds = new ArrayList<>(); // ids dos users q trabalham em x loja
	
	@OneToMany
	private List<Shelf> shelves = new ArrayList<>(); // lista de prateleiras da loja

	public Store() {

	}

	public Store(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

}