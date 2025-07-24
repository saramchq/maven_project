package io.altar.jseproject.textinterface.states;

import java.util.List;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ListProducts extends State {
	@Override
	public int on () {
		System.out.println("\n===== LISTA DE PRODUTOS =====");
		
		//chama o metodo estatico getInstance() da class ProductRepository q deevolve a sua instancia unica
		List<Product> produtos = ProductRepository.getInstance().getAll(); //o metodo getAll devolve uma lista com todos os produtos guardados no repositório
		
		if (produtos.isEmpty()) {
			System.out.println(" Não existem produtos registados.");
		} else { 
			for (Product p : produtos ) { // para cada produto da lista produtos vai buscar um id
				System.out.println("ID: " + p.getId() + " | PVP: " + p.getPvp() + " | IVA: " + p.getIva() + " | DESCONTO: " + p.getDescontoUni() + " | PRATELEIRAS: " + p.getPrateleiras());
			}
		}
		
		// Mostra submenu dos produtos
		System.out.println("\n----- GESTÃO DE PRODUTOS -----");
		System.out.println("1 - Criar novo produto");
		System.out.println("2 - Consultar um produto");
		System.out.println("3 - Editar um produto");
		System.out.println("4 - Remover um produto");
		System.out.println("0 - Voltar ao menu principal");
		System.out.print("Escolha uma opção: ");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opcao = -1;

		if (scanner.hasNextInt()) {
			opcao = scanner.nextInt();
			scanner.nextLine();
		} else {
			System.out.println("Opção inválida. A voltar ao menu principal.");
		}
		
		return opcao; // devolve a escolha para o StateMachine decidir o próximo estado
	}
	
	
}


//p.getId > herdado da superclass myEntity
//p.getPvp, getIva > do produto
//p.getDescontoUni > desconto aplicado
//p.getPrateleiras > lista de ids das prateleiras onde está o produto