package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ConsultShelf extends State {

	private Scanner scanner = new Scanner(System.in);
	private ShelfRepository shelfRepo = ShelfRepository.getInstance();

	@Override
	public int on() {
		System.out.println("----- CONSULTAR PRATELEIRA -----");
		System.out.print("Informe o ID da prateleira que deseja consultar: ");

		if (scanner.hasNextLong()) {
			long id = scanner.nextLong();
			scanner.nextLine(); // limpa o buffer

			Shelf prateleira = shelfRepo.getById(id);

			if (prateleira != null) {
				System.out.println("ID: " + prateleira.getId());
				System.out.println("CAPACIDADE: " + prateleira.getCapacidade());
				System.out.println("PREÇO DO ALUGUER: " + prateleira.getPrecoAluguer());
			} else {
				System.out.println("Prateleira com ID " + id + " não encontrada.");
			}
		} else {
			System.out.println("ID inválido. Por favor insira um número.");
			scanner.nextLine(); // limpa entrada inválida
		}

		return 0;
	}
}
