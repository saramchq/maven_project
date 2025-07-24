package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.repositories.ProductRepository;

public class DeleteProduct extends State {
	@Override
	public int on() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n===== REMOVER PRODUTO =====");
		System.out.println("Informe o ID do produto que deseja remover: ");
		long id = scanner.nextLong();
		
		ProductRepository.getInstance().remove(id);
		
		System.out.println("Caso o produto se encontre no nosso banco de dados, foi removido com sucesso!");
		
		return 0;
	}
}
