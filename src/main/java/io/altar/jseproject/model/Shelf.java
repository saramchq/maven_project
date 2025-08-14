package io.altar.jseproject.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shelf")
public class Shelf extends myEntity{ // esta classe representa uma prateleira
	
	private static final long serialVersionUID = 1L;
	// ############ o id agora vem da superclasse myEntity #################
	//private static int contadorIds = 1; //não é um objeto especifico e serve pra gerar ids unicos p cada prateleira
	//private final int id; //id é final pq so pode ser atribuido uma vez no construtor
	// #####################################################################
	@ManyToOne
	private Store store;
	private int capacidade;
	private Long idProduto; //aqui é onde guardo o id do produto. Como este valor pode eventualmente não existir (ex shelf sem produto associado), é mais seguro usar Long e nao long( q n pode ser null pq tem 0 por padrão)
	private double precoAluguer;
	
	public Shelf() { // construtor vazio necessario p criar automaticamente as 12 prateleiras da Store
		
	} 
	
	public Shelf(int capacidade, double precoAluguer) { 
		//this.id=contadorIds++;
		this.capacidade = capacidade; 
		this.precoAluguer = precoAluguer;
	}
	
	public Shelf(int capacidade, Long idProduto, double precoAluguer) {  //constructor overloading = dois construtores com o mesmo nome. Os metodos podem ser iguais desde q utilizem diferentes parametros.
		//this.id = contadorIds++;
		this.capacidade = capacidade;
	    this.idProduto = idProduto;
	    this.precoAluguer = precoAluguer;
	}

	
	public int getCapacidade() {
		return capacidade;
	}	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public double getPrecoAluguer() {
		return precoAluguer;
	}
	public void setPrecoAluguer(double precoAluguer) {
		this.precoAluguer = precoAluguer;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}

