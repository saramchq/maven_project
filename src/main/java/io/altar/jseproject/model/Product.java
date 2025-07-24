package io.altar.jseproject.model;
import java.util.List;
import java.util.ArrayList;


public class Product extends myEntity {
	
	// ############ o id agora vem da superclasse myEntity #################
	//private static int contadorIds = 1; // começa no 1
	//private final int id; //final significa q só pode ser atribuido uma unica vez ou seja uma vez definido no construtor nao pode mais ser alterado
	// #####################################################################
	
	private List<Long>prateleiras; //ids das prateleiras
	private double descontoUni;
	private double iva;
	private double pvp;

		public Product(double descontoUni, double iva, double pvp) {
			//this.id = contadorIds++; // faz mais sentido q eu crie os ids p serem gerados automaticamente c um incremento do q me lembrar de atribuir um id manualmente
			this.descontoUni = descontoUni;
			this.iva = iva;
			this.pvp = pvp;
			this.prateleiras = new ArrayList<>(); // <> chamam se generics e sao usados p especificar o tipo de elementos q vao estar dentro da lista
		}

		
		public List<Long> getPrateleiras() { // devolve a lista de prateleiras onde o produto se encontra
				return prateleiras;
			}

			public void setPrateleiras(List<Long> prateleiras) { // substitui a lista de prateleiras atual por uma nova lista
				this.prateleiras = prateleiras; //  isto serve p caso eu queira remover um produto do sistema limpar as prateleiras onde ele estava
		}
		

		//public int getId() { // acesso o valor do atributo ido fora da class e retorna me o valor atual do atributo
		//	return id;
		//}

		public double getDescontoUni() { //Devolve o valor atual do desconto unitário
			return descontoUni;
		}

		public void setDescontoUni(double descontoUni) { // Define um novo valor para o desconto unitário do produto
			this.descontoUni = descontoUni;
		}

		public double getIva() { //Devolve o IVA atual do produto em %
			return iva;
		}

		public void setIva(double iva) { //Altera o valor do IVA do produto
			this.iva = iva;
		}

		public double getPvp() { //Devolve o Preço de Venda ao Público atual do produto
			return pvp;
		}

		public void setPvp(double pvp) { //Altera o valor do PVP do produto
			this.pvp = pvp;
		}	
}
