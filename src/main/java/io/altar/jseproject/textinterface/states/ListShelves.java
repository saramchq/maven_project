package io.altar.jseproject.textinterface.states;

import java.util.List;
import java.util.Scanner;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ListShelves extends State {
	@Override
	public int on() {
		System.out.println("\n===== LISTA DE PRATELEIRAS =====");
		
		List<Shelf> prateleiras = ShelfRepository.getInstance().getAll();
		
		if (prateleiras.isEmpty()) {
			System.out.println("Não existem prateleiras registadas!");
		} else {
			for ( Shelf s : prateleiras) {
				System.out.println("ID: " + s.getId() + " | CAPACIDADE: " + s.getCapacidade() + " | PRODUTO GUARDADO (ID): " + s.getIdProduto() + " | PREÇO DE ALUGUER: " + s.getPrecoAluguer());
			}
		}

		// Mostra submenu das prateleiras
		System.out.println("\n----- GESTÃO DE PRATELEIRAS -----");
		System.out.println("1 - Criar nova prateleira");
		System.out.println("2 - Consultar prateleira");
		System.out.println("3 - Editar prateleira");
		System.out.println("4 - Remover prateleira");
		System.out.println("0 - Voltar ao menu principal");
		System.out.print("Escolha uma opção: ");

		// Lê input do utilizador
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int opcao = -1;

		if (scanner.hasNextInt()) {
			opcao = scanner.nextInt();
			scanner.nextLine(); // limpa buffer
		} else {
			System.out.println("Opção inválida. A voltar ao menu principal.");
		}

		return opcao; // devolve a escolha para o StateMachine decidir o próximo estado
	}
}
