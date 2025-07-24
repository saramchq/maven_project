package io.altar.jseproject.model;

public class Shelf extends myEntity{ // esta classe representa uma prateleira
	
	// ############ o id agora vem da superclasse myEntity #################
	//private static int contadorIds = 1; //não é um objeto especifico e serve pra gerar ids unicos p cada prateleira
	//private final int id; //id é final pq so pode ser atribuido uma vez no construtor
	// #####################################################################
	private int capacidade;
	private long idProduto; //aqui é onde guardo o id do produto
	private double precoAluguer;
	
	public Shelf(int capacidade, double precoAluguer) { 
		//this.id=contadorIds++;
		this.capacidade = capacidade; 
		this.precoAluguer = precoAluguer;
	}
	
	public Shelf(int capacidade, int idProduto, double precoAluguer) {  //constructor overloading = dois construtores com o mesmo nome. Os metodos podem ser iguais desde q utilizem diferentes parametros.
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
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public double getPrecoAluguer() {
		return precoAluguer;
	}
	public void setPrecoAluguer(double precoAluguer) {
		this.precoAluguer = precoAluguer;
	}
	//public int getId() {
		//return id;
	//}
	public void setIdProduto(long idProduto) {
	    this.idProduto = idProduto;
	}

}

