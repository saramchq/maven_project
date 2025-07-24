package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.repositories.ShelfRepository;

public class DeleteShelf extends State {
	@Override
	public int on () {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n===== REMOVER PRATELEIRA =====");
		System.out.println("Informe o ID da prateleira que deseja remover: ");
		long id = scanner.nextLong();
		
		ShelfRepository.getInstance().remove(id);
		
		System.out.println("Caso a prateleira se encontre no nosso banco de dados, foi removida com sucesso! ");
		
		return 0;
	}

}
