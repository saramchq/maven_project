package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

public class MenuInit extends State {

	@Override
	public int on() {
		System.out.println("\n==== MENU PRINCIPAL ====");
		System.out.println("1. Listar Produtos");
		System.out.println("2. Listar Prateleiras");
		System.out.println("0. Sair");
		System.out.print("Escolha uma opção: ");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNextInt()) {
			int opcao = scanner.nextInt();
			scanner.nextLine();

			if (opcao == 0) {
				return -1; // termina programa
			} else if (opcao == 1 || opcao == 2) {
				return opcao - 1;
			}
		}
		System.out.println("Opção inválida.");
		return 0; // volta ao menu inicial

	}
}