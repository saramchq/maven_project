package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private long id;
	private String name;
	private List<Long> userIds = new ArrayList<>(); // ids dos users q trabalham em x loja
	private List<Shelf> shelves = new ArrayList<>(); // lista de prateleiras da loja

	public Store() {

	}

	public Store(Long id, String name) {
		this.id = id;
		this.name = name;
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