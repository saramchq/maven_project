package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class CreateShelf extends State {
	@Override
	public int on() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n===== CRIAR PRATELEIRA =====");
		
		System.out.println("CAPACIDADE (NR INTEIRO): ");
		int capacidade = scanner.nextInt();
		
		System.out.println("PREÇO DE ALUGUER: ");
		double precoAluguer = scanner.nextDouble();
		
		Shelf novaPrateleira = new Shelf(capacidade, precoAluguer);
		
		ShelfRepository.getInstance().create(novaPrateleira);
		
		System.out.println("Prateleira criada com sucesso! ID: " + novaPrateleira.getId());
		
		return 0;
		
	}
}
