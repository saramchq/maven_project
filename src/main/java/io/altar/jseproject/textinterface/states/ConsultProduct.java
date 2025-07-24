package io.altar.jseproject.textinterface.states;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ConsultProduct extends State {

	private Scanner scanner = new Scanner(System.in);
	private ProductRepository productRepo = ProductRepository.getInstance();

	@Override
	public int on() {
		System.out.println("----- CONSULTAR PRODUTO -----");
		System.out.print("Informe o ID do produto que deseja consultar: ");

		if (scanner.hasNextLong()) {
			long id = scanner.nextLong();
			scanner.nextLine(); // limpa o buffer

			Product produto = productRepo.getById(id);

			if (produto != null) {
				System.out.println("ID: " + produto.getId());
				System.out.println("DESCONTO: " + produto.getDescontoUni());
				System.out.println("IVA: " + produto.getIva());
				System.out.println("PVP: " + produto.getPvp());
				System.out.println("PRATELEIRA: " + produto.getPrateleiras());
			} else {
				System.out.println("Produto com ID " + id + " não encontrado.");
			}
		} else {
			System.out.println("ID inválido. Por favor insira um número.");
			scanner.nextLine(); // limpa entrada inválida
		}

		return 0;
	}
}
